[![Build Status](https://travis-ci.org/RoccoDev/HiveAPIKt.svg?branch=master)](https://travis-ci.org/RoccoDev/HiveAPIKt)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/681b24a27f8349eb8a41c5e92b4cd3d2)](https://www.codacy.com/app/RoccoDev/HiveAPIKt?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=RoccoDev/HiveAPIKt&amp;utm_campaign=Badge_Grade)
 [ ![Download](https://api.bintray.com/packages/roccodev/maven/HiveAPIKt/images/download.svg) ](https://bintray.com/roccodev/maven/HiveAPIKt/_latestVersion)

# HiveAPIKt - A HiveMC API wrapper written in Kotlin
A simple yet efficient API wrapper for the HiveMC Minecraft Server 100% written in Kotlin.

### Add as a dependency
Gradle:
```java
repositories {
  jcenter()
}

dependencies {
  compile 'tk.roccodev.hiveapi:HiveAPIKt:0.1'
}

```
Maven:
```xml
<repositories>
    <repository>
      <id>jcenter</id>
      <url>https://jcenter.bintray.com/</url>
    </repository>
</repositories>

<dependency>
  <groupId>tk.roccodev.hiveapi</groupId> 
  <artifactId>HiveAPIKt</artifactId> 
  <version>1.0</version>
  <type>pom</type> 
</dependency>
```

### Examples
For more information, check the [wiki](https://github.com/RoccoDev/HiveAPIKt/wiki).

Stats are fetched through `GameStats` objects, or the `HivePlayer` object if you want global stats.
You can find a player either by name or by UUID.

```java
BED bedwarsStats = new BED("RoccoDev");
return bedwarsStats.getKills();
```
Or, if you're using Kotlin:
```kotlin
val bedwarsStats: BED = BED("RoccoDev");
return bedwarsStats.kills;
```

### Dependencies & Contributing
If you would like to contribute, feel free to fork this project and open a pull request.
Here's the complete list of dependencies (probably a more updated version is inside build.gradle):

+ [Klaxon](https://github.com/cbeust/klaxon) for parsing JSON

Dependency management is done through Gradle.
