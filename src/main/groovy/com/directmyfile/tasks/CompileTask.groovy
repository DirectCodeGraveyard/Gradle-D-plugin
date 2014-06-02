package com.directmyfile.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

class CompileTask extends DefaultTask {

    String linkedName
    String srcDir = "src/main/d"

    String compiler = "dmd"

    List<String> opts = []

    @InputDirectory
    File getSrcDir() {
        project.file(srcDir)
    }

    @OutputDirectory
    File getObjectsDir() {
        project.file("${project.buildDir}/objects/")
    }

    @OutputFile
    File getOutputFile() {
        project.file("${project.buildDir}/libs/${linkedName}")
    }

    @TaskAction
    def compileD() {

        def srcDir = project.fileTree(srcDir) {
            include '**/*.d'
        }

        srcDir = srcDir ?: project.name

        project.exec { ->
            executable compiler
            args(opts)
            args("-of${getOutputFile()}")
            args("-od${getObjectsDir()}")
            srcDir.each { file ->
                args(file.absolutePath)
            }
        }
    }
}
