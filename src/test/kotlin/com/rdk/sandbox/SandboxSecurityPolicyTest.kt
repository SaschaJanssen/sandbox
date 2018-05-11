package com.rdk.sandbox

import com.rdk.sandbox.function.SandboxFunction
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SandboxSecurityPolicyTest {

    val sandboxPolicy = SandboxSecurityPolicy()

    @Test
    fun `default permissions should not be empty`() {
        val permissions = sandboxPolicy.getPermissions(this.javaClass.protectionDomain)
        assertThat(permissions.elements().toList()).isNotEmpty()
    }
    
}

class SandboxTest : SandboxFunction {
    override fun execute(input: Any): String {
        // do something
        return ""
    }

}