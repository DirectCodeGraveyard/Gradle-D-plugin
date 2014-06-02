package com.directmyfile

import com.directmyfile.tasks.CompileTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class DPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('compileD', type: CompileTask)

        if (target.tasks.hasProperty("build")) {
            target.tasks["build"].dependsOn("compileD")
        }

        if (target.tasks.hasProperty("jar")) {
            target.tasks["jar"].shouldRunAfter("compileD")
        }
    }
}
