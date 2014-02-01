package com.directmyfile

import org.gradle.api.Project
import org.gradle.api.Plugin

class DPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.extensions.create('d', DExtension, target)
        target.task('compileD', type: CompileTask)
    }
}
