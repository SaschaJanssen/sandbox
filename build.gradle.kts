plugins {
    base
    kotlin("jvm") version "1.2.41" apply false
}

allprojects {

    group = "com.rdk.sandbox"
    version = "1.0"

    repositories {
        jcenter()
    }

}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}