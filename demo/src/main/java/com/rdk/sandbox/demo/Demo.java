package com.rdk.sandbox.demo;

import com.rdk.sandbox.function.SandboxFunction;

/**
 * simple Function that can run within the sandbox.
 */
public class Demo implements SandboxFunction {

    @Override
    public String execute(Object o) {
        return "Hello World";
    }
}
