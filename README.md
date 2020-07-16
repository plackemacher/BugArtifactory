# BugArtifactory
 
Project to demonstrate that no dependencies are found for a module that depeneds on a local module as a dependency with the `api()` call.
 
## Setup
 
 1. Modify `gradle.properties` with the proper Artifactory configuration (host name, credentials, repositories).
 2. Ensure that Android SDK Platform 28 and Android SDK Build-Tools 28.0.3 are installed.
 3. Run `./gradlew clean assembleRelease :foo:extractModuleInfo :muu:extractModuleInfo` within the project folder.
 4. Examine the two stack traces that appear.
 5. Run `./gradlew clean assembleRelease artifactoryPublish` within the project folder.
 6. Examine the Builds in Artifactory and see that are zero dependencies for the `foo` and `muu` module IDs.
