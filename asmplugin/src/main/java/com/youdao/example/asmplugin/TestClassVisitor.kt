package com.youdao.example.asmplugin

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 *
 * @author jun.wang04
 * created at 2023/11/25 21:52
 */
class TestClassVisitor(classVisitor: ClassVisitor, private val className: String) :
    ClassVisitor(Opcodes.ASM7, classVisitor) {

    override fun visitMethod(
        access: Int,
        name: String?,
        descriptor: String?,
        signature: String?,
        exceptions: Array<out String>?
    ): MethodVisitor {
        val methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions)
        return TestMethodVisitor(
            api,
            methodVisitor,
            access,
            name ?: "",
            className,
            descriptor ?: ""
        )
    }
}