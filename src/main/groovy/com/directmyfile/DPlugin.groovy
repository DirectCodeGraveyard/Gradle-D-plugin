package com.directmyfile

import com.directmyfile.tasks.*
import org.gradle.api.Project
import org.gradle.api.Plugin

class DPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.extensions.create('d', DExtension, target)
        target.task('compileD', type: CompileTask)

        target.tasks.maybeCreate('build')
        target.tasks.getByName('build').dependsOn('compileD')
    }
}
