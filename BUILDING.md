# Building the development snapshot

Requirements:

- JDK 25
- Gradle 9.2.1 for the initial wrapper generation

From the project directory, generate the wrapper once:

```text
gradle wrapper --gradle-version 9.2.1
```

Then build with the generated wrapper:

```text
./gradlew build
```

On Windows:

```text
gradlew.bat build
```

The project target is fixed to Minecraft 26.2 and NeoForge 26.2.0.59 in `gradle.properties`.
