package com.arthur.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


class CusPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('cusPluginTask') {
            doLast {
                println("this is CusPluginTask")
            }
        }
    }
}