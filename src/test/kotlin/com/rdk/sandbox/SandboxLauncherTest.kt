package com.rdk.sandbox

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class SandboxLauncherTest {

    @Test
    fun `should launch and execute external JAR`() {
        SandboxLauncher.main(arrayOf("src/test/resources/demo.jar", "com.rdk.sandbox.demo.Demo", ""))
    }

    @Test
    fun `should throw exception on unprivileged access in external JAR`() {
        assertThrows(SecurityException::class.java, {
            SandboxLauncher.main(arrayOf("src/test/resources/demo.jar", "com.rdk.sandbox.demo.FileAccessDemo", ""))
        })
    }
}
