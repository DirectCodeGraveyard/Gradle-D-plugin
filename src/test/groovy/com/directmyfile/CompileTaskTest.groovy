package com.directmyfile

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class CompileTaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('compileD', type: CompileTask)
        assertTrue(task instanceof CompileTask)
    }
}
