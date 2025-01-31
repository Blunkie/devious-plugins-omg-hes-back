rootProject.name = "devious-plugins"

include(":action-bars")
include(":auto-flicker")
include(":auto-switcher")
include(":reply-gpt")

for (project in rootProject.children) {
    project.apply {
        projectDir = file(name)
        buildFileName = "$name.gradle.kts"

        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}
