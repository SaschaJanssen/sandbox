package com.rdk.sandbox

import com.rdk.sandbox.function.SandboxFunction
import java.nio.file.Paths
import java.security.Policy

class SandboxLauncher {

    private fun runExternal(externalJarPath: String, className: String, input: Any) {

        val pluginJarFile = Paths.get(externalJarPath)
        val pluginLoader = SandboxClassLoader(pluginJarFile)

        val pluginClass = pluginLoader.loadClass(className)
        val function = pluginClass.newInstance() as SandboxFunction
        function.execute(input)
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {

            if (args.size != 3) {
                // need three parameter to launch jar
                return
            }

            val externalJarPath = args[0];
            val className = args[1];
            val input = args[2];

            Policy.setPolicy(SandboxSecurityPolicy())
            System.setSecurityManager(SecurityManager())

            SandboxLauncher().runExternal(externalJarPath, className, input)
        }

    }
}
