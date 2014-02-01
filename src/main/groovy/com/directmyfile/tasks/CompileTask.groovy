package com.directmyfile.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CompileTask extends DefaultTask {

    @TaskAction
    def compileD() {
        def srcDir = project.fileTree(project.d.srcDir) {
            include '**/*.d'
        }

        def args = ['dmd']
        args += '-of' + project.file('build/libs/' + project.d.linkedName)
        args += '-od' + project.file('build/objects')

        srcDir.each { File file ->
            args += file.getAbsolutePath()
        }

        args.execute().text
    }
}
