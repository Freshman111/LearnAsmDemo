package com.youdao.example.asmplugin

import com.android.build.api.instrumentation.AsmClassVisitorFactory
import com.android.build.api.instrumentation.ClassContext
import com.android.build.api.instrumentation.ClassData
import org.objectweb.asm.ClassVisitor

/**
 *
 * @author jun.wang04
 * created at 2023/11/25 21:50
 */
abstract class TestClassVisitorFactory: AsmClassVisitorFactory<AsmParameters> {

    override fun createClassVisitor(
        classContext: ClassContext,
        nextClassVisitor: ClassVisitor
    ): ClassVisitor {
        return TestClassVisitor(nextClassVisitor, classContext.currentClassData.className)
    }

    override fun isInstrumentable(classData: ClassData): Boolean {
        val isInstrument = classData.className.contains("com.youdao.")
        println("isInstrumentable classData ${classData.className} isInstrument = $isInstrument")
        return isInstrument
//        parameters.get().specificClass.get().forEach {
//            if (classData.className.contains(it)) {
//                println("isInstrumentable classData true")
//                return true
//            }
//        }
//        return false
    }
}