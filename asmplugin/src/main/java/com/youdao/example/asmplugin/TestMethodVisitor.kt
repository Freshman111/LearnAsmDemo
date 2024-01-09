package com.youdao.example.asmplugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.commons.AdviceAdapter

/**
 *
 * @author jun.wang04
 * created at 2023/11/25 22:00
 */
class TestMethodVisitor(
    api: Int,
    methodVisitor: MethodVisitor,
    access: Int,
    name: String,
    val className: String,
    descriptor: String
): AdviceAdapter(api, methodVisitor, access, name, descriptor) {

    override fun onMethodEnter() {
        println("onMethodEnter name = $name, className = $className")
        if (isNeedVisitMethod(name)) {
            mv.visitLdcInsn(name)
            mv.visitLdcInsn(className)
            mv.visitMethodInsn(
                INVOKESTATIC, "com/youdao/example/asmdemo/utils/TimeCache", "putStartTime",
                "(Ljava/lang/String;Ljava/lang/String;)V", false
            )
//            mv.visitInsn(POP)
        }
        super.onMethodEnter()
    }

    override fun onMethodExit(opcode: Int) {
        if (isNeedVisitMethod(name)) {
            mv.visitLdcInsn(name)
            mv.visitLdcInsn(className)
            mv.visitMethodInsn(
                INVOKESTATIC, "com/youdao/example/asmdemo/utils/TimeCache", "putEndTime",
                "(Ljava/lang/String;Ljava/lang/String;)V", false
            )
//            mv.visitInsn(POP)
        }
        super.onMethodExit(opcode)
    }

    //不把这个排除掉会报错
    private fun isNeedVisitMethod(name: String?):Boolean {
        return name != "putStartTime" && name != "putEndTime" && name != "<clinit>" && name != "printlnTime" && name != "<init>"
    }
}