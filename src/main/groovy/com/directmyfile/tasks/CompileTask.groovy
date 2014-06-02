package com.directmyfile.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CompileTask extends DefaultTask {

    String linkedName
    String srcDir = "src/main/d"

    String compiler = "dmd"

    List<String> opts = []

    @TaskAction
    def compileD() {
        def srcDir = project.fileTree(srcDir) {
            include '**/*.d'
        }

        srcDir = srcDir ?: project.name

        project.exec { ->
            executable compiler
            args(opts)
            args("-of${project.file("${project.buildDir}/libs/${linkedName}")}")
            args("-od${project.file("${project.buildDir}/objects")}")
            srcDir.each { file ->
                args(file.absolutePath)
            }
        }
    }
}
