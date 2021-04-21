[![Maven Central](https://img.shields.io/maven-central/v/dev.chriskrueger/kotlin-express?label=Maven%20Central)](https://search.maven.org/artifact/dev.chriskrueger/kotlin-express)
[![Kotlin](https://img.shields.io/badge/kotlin-1.4.32-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Gradle](https://img.shields.io/badge/Gradle-7-blue?style=flat)](https://gradle.org)
[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)


# kotlin-expess
A Kotlin wrapper for JavaScript express library.


## Adding to your project

The library is published to Maven Central.

### Gradle

Add the Maven Central repository if it is not already there.

```kotlin
repositories {
    mavenCentral()
}
```

To use the library in a single-platform project, add a dependency.

```kotlin
dependencies {
    implementation("dev.chriskrueger:kotlin-express:1.1.1")
}
```

## Example
```kotlin
val app = express()
app.get("") { _, res ->
    res.status(200).send("hello")
}
```
