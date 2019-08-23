package net.thoughtmachine.plugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import net.thoughtmachine.lsp.Client
import org.eclipse.lsp4j.InitializeParams

class HelloWorldAction() : AnAction("Hello") {
    override fun actionPerformed(event: AnActionEvent) {
        val server = Client.launcher.remoteProxy
        val res = server.initialize(InitializeParams())

        if (res.get().capabilities.definitionProvider){
            event.showMessage("Succesfully initialised and server has definition provider ")
        } else {
            event.showMessage("")
        }

    }

    fun (AnActionEvent).showMessage(message: String) {
        Messages.showMessageDialog(project, message, "Greeting", Messages.getInformationIcon())
    }

}