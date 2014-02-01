package com.directmyfile

import org.gradle.api.Project

class DExtension {

    String srcDir
    String linkedName // executable or lib

    DExtension(Project target) {
        srcDir = 'src/main/d'
        linkedName = target.rootProject.name
    }
}
