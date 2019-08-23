package net.thoughtmachine.lsp

import org.eclipse.lsp4j.InitializeParams
import org.junit.Test
import kotlin.test.assertTrue

class ClientTest {
    @Test
    fun testClient(){
        val server = Client.launcher.remoteProxy
        val initializeParams = InitializeParams()

        initializeParams.rootUri = "file://."

        val resp = server.initialize(initializeParams)

        assertTrue { resp.get().capabilities.documentFormattingProvider }
    }

}