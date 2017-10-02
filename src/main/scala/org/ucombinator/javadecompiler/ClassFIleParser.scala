package org.ucombinator.javadecompiler

import java.io.DataInputStream
import java.lang.{Byte => JByte}


// #1
sealed trait ClassFileType

// U1, U2, U4
sealed trait UType extends ClassFileType
case class U1(b: Byte) extends UType {
  val v: Int = JByte.toUnsignedInt(b)
  val vSigned: Int = b.toInt
}

case class U2(b1: Byte, b2: Byte) extends UType {
  val v: Int = JByte.toUnsignedInt(b1) << 8 + JByte.toUnsignedInt(b2)
  val vSigned: Int = b1.toInt << 8 | b2
}


case class U4(b1: Byte, b2: Byte, b3: Byte, b4: Byte) extends UType {
  val v: Long = JByte.toUnsignedLong(b1) << 24 |
                 JByte.toUnsignedLong(b2) << 16 |
                 JByte.toUnsignedLong(b3) << 8 |
                 JByte.toUnsignedLong(b4)

  val vSigned: Long = b1.toLong << 24 |
                      JByte.toUnsignedLong(b2) << 16 |
                      JByte.toUnsignedLong(b3) << 8 |
                      JByte.toUnsignedLong(b4)
}

// `Table` related
sealed trait TableItem extends ClassFileType

sealed trait Cp_info extends TableItem
case class CONSTANT_Class_info(name_index: U2) extends Cp_info
case class CONSTANT_Fieldref_info(class_index: U2, name_and_type_index: U2) extends Cp_info
case class CONSTANT_Methodref_info(class_index: U2, name_and_type_index: U2) extends Cp_info
case class CONSTANT_InterfaceMethodref_info(class_index: U2, name_and_type_index: U2) extends Cp_info
case class CONSTANT_String_info(string_index: U2) extends Cp_info
case class CONSTANT_Integer_info(bytes: U4) extends Cp_info
case class CONSTANT_Float_info(bytes: U4) extends Cp_info
case class CONSTANT_Long_info(high_bytes: U4, low_bytes: U4) extends Cp_info
case class CONSTANT_Double_info(high_bytes: U4, low_bytes: U4) extends Cp_info
case class CONSTANT_NameAndType_info(name_index: U2, descriptor_index: U2) extends Cp_info
case class CONSTANT_Utf8_info(length: U2, bytes: List[U1]) extends Cp_info
case class CONSTANT_MethodHandle_info(reference_kind: U1, reference_index: U2) extends Cp_info
case class CONSTANT_MethodType_info(descriptor_index: U2) extends Cp_info
case class CONSTANT_InvokeDynamic_info(bootstrap_method_attr_index: U2, name_and_type_index: U2) extends Cp_info

case class Field_info(access_flags: U2, name_index: U2, descriptor_index: U2, attributes_count: U2, attributes: List[Attribute_info]) extends TableItem
case class Method_info(access_flags: U2, name_index: U2, descriptor_index: U2, attributes_count: U2, attributes: List[Attribute_info]) extends TableItem
case class Attribute_info(attribute_name_index: U2, attribute_length: U4, infos: List[U1]) extends TableItem


sealed trait Table extends ClassFileType
case class Constant_Pool(cp_infos: List[Cp_info]) extends Table
case class Fields(field_infos: List[Field_info]) extends Table
case class Methods(method_infos: List[Method_info]) extends Table
case class Attributes(attribute_infos: List[Attribute_info]) extends Table
case class Interfaces(interfaces: List[U2]) extends Table


object ClassFileParser {
  private val CONSTANT_Class = 7
  private val CONSTANT_Fieldref = 9
  private val CONSTANT_Methodref = 10
  private val CONSTANT_InterfaceMethodref = 11
  private val CONSTANT_String = 8
  private val CONSTANT_Integer = 3
  private val CONSTANT_Float = 4
  private val CONSTANT_Long = 5
  private val CONSTANT_Double = 6
  private val CONSTANT_NameAndType = 12
  private val CONSTANT_Utf8 = 1
  private val CONSTANT_MethodHandle = 15
  private val CONSTANT_MethodType = 16
  private val CONSTANT_InvokeDynamic = 18

//  val classFilePath = args(0)
//  val dataInputStream = new DataInputStream(new FileInputStream(classFilePath))
//  readClassFile(dataInputStream).foreach(println)

  def readClassFile(input: DataInputStream): Map[String, ClassFileType] = {
    val magic: U4 = readU4(input)
    val minor_version: U2 = readU2(input)
    val major_version: U2 = readU2(input)

    val constant_pool_count: U2 = readU2(input)
    val constant_pool: Constant_Pool = readConstantPool(input, constant_pool_count.v)

    val access_flags: U2 = readU2(input)
    val this_class: U2 = readU2(input)
    val super_class: U2 = readU2(input)

    val interfaces_count: U2 = readU2(input)
    val interfaces: Interfaces = readInterfaces(input, interfaces_count.v)

    val fields_count: U2 = readU2(input)
    val fields: Fields = readFields(input, fields_count.v)

    val methods_count: U2 = readU2(input)
    val methods: Methods = readMethods(input, methods_count.v)

    val attributes_count: U2 = readU2(input)
    val attributes: Attributes = Attributes(readAttributes(input, attributes_count.v))

    Map(
      "magic" -> magic,
      "minor_version" -> minor_version,
      "major_version" -> major_version,
      "constant_pool_count" -> constant_pool_count,
      "constant_pool" -> constant_pool,
      "access_flags" -> access_flags,
      "this_class" -> this_class,
      "super_class" -> super_class,
      "interfaces_count" -> interfaces_count,
      "interfaces" -> interfaces,
      "field_count" -> fields_count,
      "field" -> fields,
      "methods_count" -> methods_count,
      "methods" -> methods,
      "attributes_count" -> attributes_count,
      "attributes" -> attributes
    )
  }

  // Why the `apply` methods DO NOT work?
  private def readU1(input: DataInputStream): U1 = U1(input.readByte())

  private def readU2(input: DataInputStream): U2 = U2(input.readByte(),
                                                      input.readByte())

  private def readU4(input: DataInputStream): U4 = U4(input.readByte(),
                                                      input.readByte(),
                                                      input.readByte(),
                                                      input.readByte())

  private def readConstantPool(input: DataInputStream, count: Int): Constant_Pool = {
    def readCpInfo(input: DataInputStream): Cp_info = {
     readU1(input).v match {
          // Constructor(U2)
          case CONSTANT_Class => CONSTANT_Class_info(readU2(input))
          case CONSTANT_String => CONSTANT_String_info(readU2(input))
          case CONSTANT_MethodType => CONSTANT_MethodType_info(readU2(input))
          // Constructor(U2, U2)
          case CONSTANT_Fieldref => CONSTANT_Fieldref_info(readU2(input), readU2(input))
          case CONSTANT_Methodref => CONSTANT_Methodref_info(readU2(input), readU2(input))
          case CONSTANT_InterfaceMethodref => CONSTANT_InterfaceMethodref_info(readU2(input), readU2(input))
          case CONSTANT_NameAndType => CONSTANT_NameAndType_info(readU2(input), readU2(input))
          case CONSTANT_InvokeDynamic => CONSTANT_InvokeDynamic_info(readU2(input), readU2(input))
          // Constructor(U4)
          case CONSTANT_Integer => CONSTANT_Integer_info(readU4(input))
          case CONSTANT_Float => CONSTANT_Float_info(readU4(input))
          // Constructor(U4, U4)
          case CONSTANT_Long => CONSTANT_Long_info(readU4(input), readU4(input))
          case CONSTANT_Double => CONSTANT_Double_info(readU4(input), readU4(input))
          // Constructor(U1, U2)
          case CONSTANT_MethodHandle => CONSTANT_MethodHandle_info(readU1(input), readU2(input))
          // Constructor(U2, U1)
          case CONSTANT_Utf8 => {
            val length: U2 = readU2(input)
            val bytes: List[U1] = List.tabulate(length.v) {
              _ => readU1(input)
            }
            CONSTANT_Utf8_info(length, bytes)
          }
          case _ => throw new Exception("WRONG tag. " +
            "This shouldn't happen if this is a legal .class file")
        }
    }

    Constant_Pool(
      List.fill(count - 1) { readCpInfo(input) }
    )
  }

  private def readInterfaces(input: DataInputStream, count: Int): Interfaces =
    Interfaces(List.fill(count) { readU2(input) })

  private def readAttributes(input: DataInputStream, count: Int): List[Attribute_info] = {
    def readAttributeInfo(input: DataInputStream) = {
      val attribute_name_index: U2 = readU2(input)
      val attribute_length: U4 = readU4(input)
      val info: List[U1] = for (_ <- (0 to attribute_length.v).toList) yield readU1(input)
      Attribute_info(attribute_name_index, attribute_length, info)
    }

    List.fill(count) { readAttributeInfo(input) }
  }


  private def readFields(input: DataInputStream, count: Int): Fields = {
    def readFieldInfo(input: DataInputStream): Field_info = {
      val access_flags: U2 = readU2(input)
      val name_index: U2 = readU2(input)
      val descriptor_index: U2 = readU2(input)
      val attributes_count: U2 = readU2(input)
      val attributes: List[Attribute_info] = readAttributes(input, attributes_count.v)
      Field_info(access_flags, name_index, descriptor_index, attributes_count, attributes)
    }

    Fields(List.fill(count) { readFieldInfo(input) } )
  }


  private def readMethods(input: DataInputStream, count: Int): Methods = {
    def readMethod(input: DataInputStream): Method_info = {
      val access_flags: U2 = readU2(input)
      val name_index: U2 = readU2(input)
      val descriptor_index: U2 = readU2(input)
      val attributes_count: U2 = readU2(input)
      val attribute_info: List[Attribute_info] = readAttributes(input, attributes_count.v)
      Method_info(access_flags, name_index, descriptor_index, attributes_count, attribute_info)
    }

    Methods(List.fill(count) { readMethod(input) } )
  }
}



