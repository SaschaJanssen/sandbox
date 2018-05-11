package com.rdk.sandbox

import com.rdk.sandbox.function.SandboxFunction
import java.nio.file.Paths
import java.security.Policy

class AppLauncher {

    private fun runExternal(externalJarPath: String) {

        val pluginJarFile = Paths.get(externalJarPath)
        val pluginLoader = SandboxClassLoader(pluginJarFile)

        val pluginClass = pluginLoader.loadClass("de.hello.HelloFunction")
        val function = pluginClass.newInstance() as SandboxFunction
        function.execute("FooBaa")
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            if (args[0].isEmpty()) {
                // first parameter should be the jar that should be executed within the sandbox
                return
            }

            val externalJarPath = args[0];

            Policy.setPolicy(SandboxSecurityPolicy())
            System.setSecurityManager(SecurityManager())

            AppLauncher().runExternal(externalJarPath)
        }

    }
}
