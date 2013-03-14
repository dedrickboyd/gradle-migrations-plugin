package com.github.marceloemanoel.gradle.migrations.tasks

import org.apache.ibatis.migration.commands.BootstrapCommand
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import com.github.marceloemanoel.gradle.migrations.helper.CommandHelper;

class BootstrapTask extends DefaultTask {

    File baseDir
    String environment
    Boolean force

    public BootstrapTask(){
        setDescription("Bootstrap migrations");
        setGroup("Migration");
    }

    @TaskAction
    void bootstrap() {
        def command = new BootstrapCommand(baseDir, environment, force)
        CommandHelper.updateDriverClassLoader(project, command)
        command.execute()
    }
}