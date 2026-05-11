# ResXeL
ResXeL is a flexible Java library for discovering and loading resources.

## Purpose

ResXeL aims to provide one API for finding and reading resources from different
locations:

- regular filesystem paths;
- `file:` locations;
- `jar:file:` locations;
- resources available through the thread context class loader.

The core model is built around `Scope`, `Resource`, and `Location`. A scope
discovers resources, a resource exposes its content, and a location describes
where that resource came from.

## Practical Use Cases

This library can make sense when an application needs to work with resources
without hard-coding whether they come from disk, classpath, or a JAR file.
Possible examples include loading configuration files, templates, SQL scripts,
localization bundles, test fixtures, or plugin resources.

## Project Status

The project is currently experimental. The overall direction is useful, but the
implementation is not yet ready to be treated as a production dependency.

Known gaps include incomplete JAR resource reading, placeholder public types,
limited assertions in some tests, and no high-level entry point that ties the
API together. Before production use, the library should provide a complete
end-to-end scenario for filesystem, classpath, and JAR resources, with tests
that verify actual resource content.

## Legal Notice
The ResXeL Project is open and independent.
Name used descriptively, not a trademark.
