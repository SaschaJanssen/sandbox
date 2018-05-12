package com.rdk.sandbox.function

/**
 * Classes that implements the SandboxFunction can be executed within the sandbox.
 */
interface SandboxFunction {

    fun execute(input: Any): String

}
