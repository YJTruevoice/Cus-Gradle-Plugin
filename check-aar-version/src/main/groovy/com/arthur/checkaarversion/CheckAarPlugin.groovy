package com.arthur.checkaarversion

import org.gradle.api.Plugin
import org.gradle.api.Project


class CheckAarPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('checkAarPluginTask') {
            doLast {
                println("this is CheckAarPluginTask")
            }
        }
    }
}