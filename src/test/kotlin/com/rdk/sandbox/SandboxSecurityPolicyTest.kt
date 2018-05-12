package com.rdk.sandbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.net.URLClassLoader
import java.nio.file.Files
import java.nio.file.Paths

class SandboxSecurityPolicyTest {

    val sandboxPolicy = SandboxSecurityPolicy()
    val path = Paths.get("src/test/resources/demo.jar")

    @BeforeEach
    internal fun setUp() {
        assertThat(Files.exists(path)).isTrue().withFailMessage("demo.jar not found")
    }

    @Test
    fun `should return default permissions if loaded with default class loader`() {

        val classLoader = URLClassLoader(arrayOf(path.toUri().toURL()))
        val loadedClass = classLoader.loadClass("com.rdk.sandbox.demo.Demo")

        val permissions = sandboxPolicy.getPermissions(loadedClass.protectionDomain)
        assertThat(permissions.elements().toList()).isNotEmpty()
    }

    @Test
    fun `should return restricted permissions for sandbox class if loaded with SandboxClassLoader`() {

        val classLoader = SandboxClassLoader(path)
        val loadedClass = classLoader.loadClass("com.rdk.sandbox.demo.Demo")

        val permissions = sandboxPolicy.getPermissions(loadedClass.protectionDomain)
        assertThat(permissions.elements().toList()).isEmpty()
    }


}