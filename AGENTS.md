# Repository Guidelines

## Project Structure & Module Organization

This is a Java 17 Maven library for discovering and loading resources. Core source code lives in `src/main/java/com/stdsolutions/resxel`, with subpackages grouped by resource type or shared utility:

- `file/` handles filesystem locations, scopes, and resources.
- `jarfile/` handles resources inside JAR files.
- `nest/` contains nest implementations such as classpath and filesystem lookup.
- `shared/` contains reusable value types and helpers.
- `unexpected/` contains fallback scope and mode implementations.

Tests live in `src/test/java/com/stdsolutions/resxel`. Test fixtures are under `src/test/resources`, including local sample files and `jar/resxel.jar`. Build output belongs in `target/` and should not be committed.

## Build, Test, and Development Commands

- `.\mvnw.cmd clean test` runs the JUnit 5 test suite on Windows.
- `./mvnw clean test` runs the same tests on Unix-like systems.
- `.\mvnw.cmd clean install -DskipTests=false` performs the full local build used by CI.
- `.\mvnw.cmd qulice:check` runs Qulice style and quality checks explicitly.

CI runs Maven with Java 17 on Ubuntu, Windows, and macOS, so avoid platform-specific assumptions in path handling.

## Coding Style & Naming Conventions

Use Java package names under `com.stdsolutions.resxel`. Class and enum names use `PascalCase`; methods, fields, and local variables use `camelCase`. Test method names should describe behavior, for example `streamShouldReturnAllFilesRecursively`.

Qulice is configured in `pom.xml` and enforces style during the Maven lifecycle. Keep files UTF-8, end files with a newline, keep imports cohesive, and avoid unused or wildcard imports.

## Testing Guidelines

Use JUnit Jupiter (`org.junit.jupiter`) for tests. Place tests beside the matching package under `src/test/java`, and suffix test classes with `Test`. Prefer focused tests that exercise filesystem, JAR, and classpath behavior through fixtures in `src/test/resources` rather than environment-specific absolute paths.

Before submitting changes, run `.\mvnw.cmd clean test` and, for style-sensitive changes, `.\mvnw.cmd qulice:check`.

## Commit & Pull Request Guidelines

Recent commits use issue-prefixed messages such as `[#72] Fix checkstyle NewlineAtEndOfFileCheck`; merge commits follow GitHub's default pull request format. Prefer concise, imperative commit subjects and include the issue number when one exists.

Pull requests should describe the change, list verification commands run, link related issues, and mention any behavior that differs across filesystems, classpaths, or JAR resources.
