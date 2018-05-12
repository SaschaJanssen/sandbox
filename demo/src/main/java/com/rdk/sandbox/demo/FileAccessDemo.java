package com.rdk.sandbox.demo;

import com.rdk.sandbox.function.SandboxFunction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Function that will cause a {@link SecurityException} when executed with the {@link com.rdk.sandbox.SandboxLauncher}.
 */
public class FileAccessDemo implements SandboxFunction {

    @Override
    public String execute(Object o) {

        try {
            Files.createTempFile("temp", ".txt");
        } catch (IOException e) {
            // handle me
        }

        return "Never reached";
    }
}
