# Execute external JARSs in a sandbox environment 

[![build status](https://travis-ci.org/SaschaRodekamp/sandbox.svg?branch=master)](https://travis-ci.org/SaschaRodekamp/sandbox)


The code executes an external JAR in its own Sandbox in which the access to the outside world can be restricted. 
This can be helpful if someone else implements functionality that is deployt in a single JAR and executed on your system.
 
To achieve that, the security police was extended, where a set of special permission (or en empty set) is defined for code which is launched within the sandbox. 

Disclaimer: 
This solution can not limit the CPU or Memory utilization of the external JAR.

Original described by https://blog.jayway.com/2014/06/13/sandboxing-plugins-in-java/