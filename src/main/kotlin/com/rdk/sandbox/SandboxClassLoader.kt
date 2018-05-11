package com.rdk.sandbox

import java.net.URL
import java.net.URLClassLoader
import java.nio.file.Path

/**
 * Convenient class loader, to make the URLClassLoader easier accessible.
 */
class SandboxClassLoader(jarFileUrl: URL) : URLClassLoader(arrayOf(jarFileUrl)) {
    constructor(jarFilePath: Path) : this(jarFilePath.toUri().toURL())
}
