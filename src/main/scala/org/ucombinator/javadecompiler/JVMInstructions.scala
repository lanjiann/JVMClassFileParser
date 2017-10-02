package org.ucombinator.javadecompiler

sealed trait JVMBytecodeInstruction
case class Nop() extends JVMBytecodeInstruction { final val opcode = 0 } //
case class Aconst_null() extends JVMBytecodeInstruction { final val opcode = 1 }
case class Iconst_m1() extends JVMBytecodeInstruction { final val opcode = 2}
case class Iconst_0() extends JVMBytecodeInstruction { final val opcode = 3}
case class Iconst_1() extends JVMBytecodeInstruction { final val opcode = 4}
case class Iconst_2() extends JVMBytecodeInstruction { final val opcode = 5}
case class Iconst_3() extends JVMBytecodeInstruction { final val opcode = 6}
case class Iconst_4() extends JVMBytecodeInstruction { final val opcode = 7}
case class Iconst_5() extends JVMBytecodeInstruction { final val opcode = 8}
case class Lconst_0() extends JVMBytecodeInstruction { final val opcode = 9}
case class Lconst_1() extends JVMBytecodeInstruction { final val opcode = 10}
case class Fconst_0() extends JVMBytecodeInstruction { final val opcode = 11}
case class Fconst_1() extends JVMBytecodeInstruction { final val opcode = 12}
case class Fconst_2() extends JVMBytecodeInstruction { final val opcode = 13}
case class Dconst_0() extends JVMBytecodeInstruction { final val opcode = 14 }
case class Dconst_1() extends JVMBytecodeInstruction { final val opcode = 15 }
case class Bipush(byte: U1) extends JVMBytecodeInstruction { final val opcode = 16 }
case class Sipush(short: U2) extends JVMBytecodeInstruction { final val opcode = 17 }
case class Ldc(index: U1) extends JVMBytecodeInstruction { final val opcode = 18 }
case class Ldc_w(wideIndex: U2) extends JVMBytecodeInstruction { final val opcode = 19 }
case class Ldc2_w(wideIndex: U2) extends JVMBytecodeInstruction { final val opcode = 20 }
case class Iload(index: U1) extends JVMBytecodeInstruction { final val opcode = 21 }
case class Lload(index: U1) extends JVMBytecodeInstruction { final val opcode = 22 }
case class Fload(index: U1) extends JVMBytecodeInstruction { final val opcode = 23 }
case class Dload(index: U1) extends JVMBytecodeInstruction { final val opcode = 24 }
case class Aload(index: U1) extends JVMBytecodeInstruction { final val opcode = 25 }
case class Iload_0() extends JVMBytecodeInstruction { final val opcode = 26 }
case class Iload_1() extends JVMBytecodeInstruction { final val opcode = 27 }
case class Iload_2() extends JVMBytecodeInstruction { final val opcode = 28 }
case class Iload_3() extends JVMBytecodeInstruction { final val opcode = 29 }
case class Lload_0() extends JVMBytecodeInstruction { final val opcode = 30 }
case class Lload_1() extends JVMBytecodeInstruction { final val opcode = 31 }
case class Lload_2() extends JVMBytecodeInstruction { final val opcode = 32 }
case class Lload_3() extends JVMBytecodeInstruction { final val opcode = 33 }
case class Fload_0() extends JVMBytecodeInstruction { final val opcode = 34 }
case class Fload_1() extends JVMBytecodeInstruction { final val opcode = 35 }
case class Fload_2() extends JVMBytecodeInstruction { final val opcode = 36 }
case class Fload_3() extends JVMBytecodeInstruction { final val opcode = 37 }
case class Dload_0() extends JVMBytecodeInstruction { final val opcode = 38 }
case class Dload_1() extends JVMBytecodeInstruction { final val opcode = 39 }
case class Dload_2() extends JVMBytecodeInstruction { final val opcode = 40 }
case class Dload_3() extends JVMBytecodeInstruction { final val opcode = 41 }
case class Aload_0() extends JVMBytecodeInstruction { final val opcode = 42 }
case class Aload_1() extends JVMBytecodeInstruction { final val opcode = 43 }
case class Aload_2() extends JVMBytecodeInstruction { final val opcode = 44 }
case class Aload_3() extends JVMBytecodeInstruction { final val opcode = 45 }
case class Iaload() extends JVMBytecodeInstruction { final val opcode = 46 }
case class Laload() extends JVMBytecodeInstruction { final val opcode = 47 }
case class Faload() extends JVMBytecodeInstruction { final val opcode = 48 }
case class Daload() extends JVMBytecodeInstruction { final val opcode = 49 }
case class Aaload() extends JVMBytecodeInstruction { final val opcode = 50 }
case class Baload() extends JVMBytecodeInstruction { final val opcode = 51 }
case class Caload() extends JVMBytecodeInstruction { final val opcode = 52 }
case class Saload() extends JVMBytecodeInstruction { final val opcode = 53 }
case class Istore(index: U1) extends JVMBytecodeInstruction { final val opcode = 54 }
case class Lstore(index: U1) extends JVMBytecodeInstruction { final val opcode = 55 }
case class Fstore(index: U1) extends JVMBytecodeInstruction { final val opcode = 56 }
case class Dstore(index: U1) extends JVMBytecodeInstruction { final val opcode = 57 }
case class Astore(index: U1) extends JVMBytecodeInstruction { final val opcode = 58 }
case class Istore_0() extends JVMBytecodeInstruction { final val opcode = 59 }
case class Istore_1() extends JVMBytecodeInstruction { final val opcode = 60 }
case class Istore_2() extends JVMBytecodeInstruction { final val opcode = 61 }
case class Istore_3() extends JVMBytecodeInstruction { final val opcode = 62 }
case class Lstore_0() extends JVMBytecodeInstruction { final val opcode = 63 }
case class Lstore_1() extends JVMBytecodeInstruction { final val opcode = 64 }
case class Lstore_2() extends JVMBytecodeInstruction { final val opcode = 65 }
case class Lstore_3() extends JVMBytecodeInstruction { final val opcode = 66 }
case class Fstore_0() extends JVMBytecodeInstruction { final val opcode = 67 }
case class Fstore_1() extends JVMBytecodeInstruction { final val opcode = 68 }
case class Fstore_2() extends JVMBytecodeInstruction { final val opcode = 69 }
case class Fstore_3() extends JVMBytecodeInstruction { final val opcode = 70 }
case class Dstore_0() extends JVMBytecodeInstruction { final val opcode = 71 }
case class Dstore_1() extends JVMBytecodeInstruction { final val opcode = 72 }
case class Dstore_2() extends JVMBytecodeInstruction { final val opcode = 73 }
case class Dstore_3() extends JVMBytecodeInstruction { final val opcode = 74 }
case class Astore_0() extends JVMBytecodeInstruction { final val opcode = 75 }
case class Astore_1() extends JVMBytecodeInstruction { final val opcode = 76 }
case class Astore_2() extends JVMBytecodeInstruction { final val opcode = 77 }
case class Astore_3() extends JVMBytecodeInstruction { final val opcode = 78 }
case class Iastore() extends JVMBytecodeInstruction { final val opcode = 79 }
case class Lastore() extends JVMBytecodeInstruction { final val opcode = 80 }
case class Fastore() extends JVMBytecodeInstruction { final val opcode = 81 }
case class Dastore() extends JVMBytecodeInstruction { final val opcode = 82 }
case class Aastore() extends JVMBytecodeInstruction { final val opcode = 83 }
case class Bastore() extends JVMBytecodeInstruction { final val opcode = 84 }
case class Castore() extends JVMBytecodeInstruction { final val opcode = 85 }
case class Sastore() extends JVMBytecodeInstruction { final val opcode = 86 }
case class Pop() extends JVMBytecodeInstruction { final val opcode = 87 }
case class Pop2() extends JVMBytecodeInstruction { final val opcode = 88 }
case class Dup() extends JVMBytecodeInstruction { final val opcode = 89 }
case class Dup_x1() extends JVMBytecodeInstruction { final val opcode = 90 }
case class Dup_x2() extends JVMBytecodeInstruction { final val opcode = 91 }
case class Dup2() extends JVMBytecodeInstruction { final val opcode = 92 }
case class Dup2_x1() extends JVMBytecodeInstruction { final val opcode = 93 }
// case class Dup2_x2() extends Instruction { final val opcode = 94 } // TODO: ???
// case class Swap() extends Instruction { final val opcode = 95 }    // TODO: ???
case class Iadd() extends JVMBytecodeInstruction { final val opcode = 96 }
case class Ladd() extends JVMBytecodeInstruction { final val opcode = 97 }
case class Fadd() extends JVMBytecodeInstruction { final val opcode = 98 }
case class Dadd() extends JVMBytecodeInstruction { final val opcode = 99 }
case class Isub() extends JVMBytecodeInstruction { final val opcode = 100 }
case class Lsub() extends JVMBytecodeInstruction { final val opcode = 101 }
case class Fsub() extends JVMBytecodeInstruction { final val opcode = 102 }
case class Dsub() extends JVMBytecodeInstruction { final val opcode = 103 }
case class Imul() extends JVMBytecodeInstruction { final val opcode = 104 }
case class Lmul() extends JVMBytecodeInstruction { final val opcode = 105 }
case class Fmul() extends JVMBytecodeInstruction { final val opcode = 106 }
case class Dmul() extends JVMBytecodeInstruction { final val opcode = 107 }
case class Idiv() extends JVMBytecodeInstruction { final val opcode = 108 }
case class Ldiv() extends JVMBytecodeInstruction { final val opcode = 109 }
case class Fdiv() extends JVMBytecodeInstruction { final val opcode = 110 }
case class Ddiv() extends JVMBytecodeInstruction { final val opcode = 111 }
case class Irem() extends JVMBytecodeInstruction { final val opcode = 112 }
case class Lrem() extends JVMBytecodeInstruction { final val opcode = 113 }
// 114
// 115
case class Ineg() extends JVMBytecodeInstruction { final val opcode = 116 }
case class Lneg() extends JVMBytecodeInstruction { final val opcode = 117 }
// 118
case class Dneg() extends JVMBytecodeInstruction { final val opcode = 119 }
case class Ishl() extends JVMBytecodeInstruction { final val opcode = 120 }
case class Lshl() extends JVMBytecodeInstruction { final val opcode = 121 }
case class Ishr() extends JVMBytecodeInstruction { final val opcode = 122 }
case class Lshr() extends JVMBytecodeInstruction { final val opcode = 123 }
case class Iushr() extends JVMBytecodeInstruction { final val opcode = 124 }
case class Lushr() extends JVMBytecodeInstruction { final val opcode = 125 }
case class Iand() extends JVMBytecodeInstruction { final val opcode = 126 }
case class Land() extends JVMBytecodeInstruction { final val opcode = 127 }
case class Ior() extends JVMBytecodeInstruction { final val opcode = 128 }
case class Lor() extends JVMBytecodeInstruction { final val opcode = 129 }
case class Ixor() extends JVMBytecodeInstruction { final val opcode = 130 }
case class lxor() extends JVMBytecodeInstruction { final val opcode = 131 }
case class Iinc(index: U1, byte: U1) extends JVMBytecodeInstruction { final val opcode = 132 } // `byte` should be signed
case class i2l() extends JVMBytecodeInstruction { final val opcode = 133 }
case class i2f() extends JVMBytecodeInstruction { final val opcode = 134 }
case class i2d() extends JVMBytecodeInstruction { final val opcode = 135 }
case class l2i() extends JVMBytecodeInstruction { final val opcode = 136 }
case class l2f() extends JVMBytecodeInstruction { final val opcode = 137 }
case class l2d() extends JVMBytecodeInstruction { final val opcode = 138 }
case class f2i() extends JVMBytecodeInstruction { final val opcode = 139 }
case class f2l() extends JVMBytecodeInstruction { final val opcode = 140 }
case class f2d() extends JVMBytecodeInstruction { final val opcode = 141 }
case class d2i() extends JVMBytecodeInstruction { final val opcode = 142 }
case class d2l() extends JVMBytecodeInstruction { final val opcode = 143 }
case class d2f() extends JVMBytecodeInstruction { final val opcode = 144 }
case class i2b() extends JVMBytecodeInstruction { final val opcode = 145 }
case class i2c() extends JVMBytecodeInstruction { final val opcode = 146 }
case class i2s() extends JVMBytecodeInstruction { final val opcode = 147 }
case class lcmp() extends JVMBytecodeInstruction { final val opcode = 148 }
case class fcmpl() extends JVMBytecodeInstruction { final val opcode = 149 }
case class fcmpg() extends JVMBytecodeInstruction { final val opcode = 150 }
case class dcmpl() extends JVMBytecodeInstruction { final val opcode = 151 }
case class dcmpg() extends JVMBytecodeInstruction { final val opcode = 152 }
//case class Ifeq((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 153 }
//case class Ifne((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 154 }
//case class Iflt((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 155 }
//case class Ifge((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 156 }
//case class Ifgt((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 157 }
//case class Ifle((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 158 }
//case class If_icmpeq((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 159 }
//case class If_icmpne((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 160 }
//case class If_icmplt((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 161 }
//case class If_icmpge((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 162 }
//case class If_icmpgt((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 163 }
//case class If_icmple((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 164 }
//case class If_acmpeq((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 165 }
//case class If_acmpne((read-s2 ip), (get-pc ip)) extends Instruction { final val opcode = 166 }
case class Goto(branchOffset: U2) extends JVMBytecodeInstruction { final val opcode = 167 }  // (branchbyte1 << 8) | branchbyte2
case class Jsr(offset: U2) extends JVMBytecodeInstruction { final val opcode = 168 }  // (branchbyte1 << 8) | branchbyte2
case class Ret(index: U1) extends JVMBytecodeInstruction { final val opcode = 169 }

//[170 (read-padding ip 4)
//     (let ([default (read-s4 ip)]
//           [lo (read-s4 ip)]
//           [hi (read-s4 ip)])
//      `(tableswitch ,default ,lo ,hi
//                    ,(for/list ([i (in-range (add1 (- hi lo)))])
//                       (read-s4 ip))))]

//[171 (read-padding ip 4)
//     `(lookupswitch ,(read-s4 ip)
//                    ,(for/list ([i (in-range (read-u4 ip))])
//                        (list (read-s4 ip) (read-s4 ip))))]

case class Ireturn() extends JVMBytecodeInstruction { final val opcode = 172 }
case class Lreturn() extends JVMBytecodeInstruction { final val opcode = 173 }
case class Freturn() extends JVMBytecodeInstruction { final val opcode = 174 }
case class Dreturn() extends JVMBytecodeInstruction { final val opcode = 175 }
case class Areturn() extends JVMBytecodeInstruction { final val opcode = 176 }
case class Return() extends JVMBytecodeInstruction { final val opcode = 177 }
case class Getstatic(index: U2) extends JVMBytecodeInstruction { final val opcode = 178 }
case class Putstatic(index: U2) extends JVMBytecodeInstruction { final val opcode = 179 }
case class Getfield(index: U2) extends JVMBytecodeInstruction { final val opcode = 180 }
case class Putfield(index: U2) extends JVMBytecodeInstruction { final val opcode = 181 }
case class Invokevirtual(index: U2) extends JVMBytecodeInstruction { final val opcode = 182 }
case class Invokespecial(index: U2) extends JVMBytecodeInstruction { final val opcode = 183 }
case class Invokestatic(index: U2) extends JVMBytecodeInstruction { final val opcode = 184 }

//[185 (begin0
//       `(invokeinterface ,(read-u2 ip) ,(read-u1 ip))
//       (read-u1 ip))]


// 186 // TODO: ???

case class New(index: U2) extends JVMBytecodeInstruction { final val opcode = 187 }
case class newarray(atype: U1) extends JVMBytecodeInstruction { final val opcode = 188 }  // Table 6.5. newarray-A. Array type codes
case class anewarray(index: U2) extends JVMBytecodeInstruction { final val opcode = 189 }
case class Arraylength() extends JVMBytecodeInstruction { final val opcode = 190 }
case class Athrow() extends JVMBytecodeInstruction { final val opcode =  191 }
case class Checkcast(twoIndexBytes: U2) extends JVMBytecodeInstruction { final val opcode = 192 }
case class Instanceof(twoIndexBytes: U2) extends JVMBytecodeInstruction { final val opcode = 193 }
case class Monitorenter() extends JVMBytecodeInstruction { final val opcode = 194 }
case class Monitorexit() extends JVMBytecodeInstruction { final val opcode = 195 }

//[196 (match (read-byte ip)
//       [132 `(wide-iinc ,(read-u2 ip) ,(read-s2 ip))]
//       [opc `(wide ,(match opc) ,(read-u2 ip))])]

case class Multianewarray(index: U2, dimensions: U1) extends JVMBytecodeInstruction { final val opcode = 197 }
//case class Ifnull((read-s2 ip) ,(get-pc ip)) extends Instruction { final val opcode = 198 }
//case class Ifnonnull((read-s2 ip) ,(get-pc ip)) extends Instruction { final val opcode = 199 }