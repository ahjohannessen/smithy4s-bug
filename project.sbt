Global / onChangedBuildSource := ReloadOnSourceChanges
Global / lintUnusedKeysOnLoad := false

lazy val Scala3 = "3.1.2"

lazy val root = project
  .in(file("."))
  .enablePlugins(NoPublishPlugin)
  .aggregate(appSpecs)

lazy val appSpecs = smithyProject("s4s-app")

def smithyProject(name: String) =
  Project(name, file(name))
    .settings(
      moduleName := name,
      autoScalaLibrary := false,
      libraryDependencies := Nil,
      crossPaths := false,
      crossVersion := CrossVersion.disabled,
      publishConfiguration :=
        publishConfiguration.value.withOverwrite(true),
      publishLocalConfiguration :=
        publishLocalConfiguration.value.withOverwrite(true),
      Compile / packageDoc / publishArtifact := false,
      Compile / packageSrc / publishArtifact := false,
      Compile / doc / sources := Seq.empty
    )

inThisBuild(
  List(
    scalaVersion := Scala3,
    crossScalaVersions := Seq(Scala3),
    mimaPreviousArtifacts := Set.empty,
    tlBaseVersion := "0.1",
    tlSonatypeUseLegacyHost := false,
    organization := "io.github.ahjohannessen",
    organizationName := "Alex Henning Johannessen",
    developers += tlGitHubDev("ahjohannessen", "Alex Henning Johannessen"),

    // ==== Github Actions

    githubWorkflowIncludeClean := false,
    githubWorkflowTargetBranches := Seq("main")
  )
)
