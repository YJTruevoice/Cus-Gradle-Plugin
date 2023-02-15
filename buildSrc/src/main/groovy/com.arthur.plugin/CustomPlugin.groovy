package com.arthur.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def extension = project.extensions.create('componentVersionConfig', ComponentVersionConfig)
        println "project.extensions.create 'componentVersionConfig'"

        def componentVersionCheckTask = project.rootProject.task('componentVersionCheck') {
            doLast {
                Map<String, String> componentVersion = extension.componentVersionMap
                println "componentVersions ${componentVersion}"
                if (componentVersion != null) {
                    def versionValues = componentVersion.values()

                    for (v in versionValues) {
                        println "versionValue ${v}"
                        def versionSegment = v.split('\\.')
                        for (segment in versionSegment) {
                            if (!segment.isNumber()) {
                                throw VersionCheckException('二方库版本不符合release版本规范')
                            }
                        }
                    }
                }
            }
        }

        // 嫁接到assembleRelease任务之前执行
//        project.tasks.whenTaskAdded { task ->
//            println "whenTaskAdded ${task.name}"
//            if (task.name == "assembleRelease") {
//                task.dependsOn(componentVersionCheckTask)
//            }
//        }

    }
}