package com.rdk.sandbox

import java.security.*

class SandboxSecurityPolicy : Policy() {

    /**
     * Determines if the code should be executed within the sandbox with restricted permissions or not.
     */
    override fun getPermissions(domain: ProtectionDomain): PermissionCollection {
        return if (isSanboxClass(domain)) {
            sandboxPermissions()
        } else {
            applicationPermissions()
        }
    }

    private fun isSanboxClass(domain: ProtectionDomain): Boolean {
        return domain.classLoader is SandboxClassLoader
    }

    /**
     * Permission for code that is executed in the sandbox
     */
    private fun sandboxPermissions(): PermissionCollection {
        // permissions.add(new FilePermission("/my-application/plugin-workspace/*", "read,write"));
        // permissions.add(new SocketPermission("localhost:8081", "connect"));
        // permissions.add(new FilePermission("/foo/bar", "read"));
        return Permissions()
    }

    /**
     * Application code gets full permission
     */
    private fun applicationPermissions(): PermissionCollection {
        val permissions = Permissions()
        permissions.add(AllPermission())
        return permissions
    }
}