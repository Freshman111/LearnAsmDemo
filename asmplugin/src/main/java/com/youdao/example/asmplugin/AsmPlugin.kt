package com.youdao.example.asmplugin

import com.android.build.api.instrumentation.FramesComputationMode
import com.android.build.api.instrumentation.InstrumentationScope
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 * @author jun.wang04
 * created at 2023/11/25 21:20
 */
class AsmPlugin: Plugin<Project> {

    override fun apply(project: Project) {
//        project.extensions.create("asmconfig", AsmExtension::class.java)

        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
        androidComponents.onVariants { variant ->
//            val extension = project.extensions.getByType(AsmExtension::class.java)
            println("AsmPlugin start")
            variant.instrumentation.setAsmFramesComputationMode(
                FramesComputationMode.COMPUTE_FRAMES_FOR_INSTRUMENTED_METHODS
            )
            variant.instrumentation.transformClassesWith(
                TestClassVisitorFactory::class.java,
                InstrumentationScope.PROJECT

            ) {}
        }


    }

}