val Scala3 = "3.1.2"

ThisBuild / tlBaseVersion := "0.1"
ThisBuild / organization := "io.github.ahjohannessen"
ThisBuild / organizationName := "Alex Henning Johannessen"
ThisBuild / startYear := Some(2022)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers +=
  tlGitHubDev("ahjohannessen", "Alex Henning Johannessen")

ThisBuild / crossScalaVersions := Seq(Scala3)
ThisBuild / scalaVersion := Scala3
ThisBuild / githubWorkflowTargetBranches := Seq("main")
ThisBuild / tlSonatypeUseLegacyHost := false

lazy val root = project
  .in(file("."))
  .enablePlugins(NoPublishPlugin)
  .aggregate(appSpecs)

lazy val appSpecs = project
  .in(file("s4s-app"))
  .settings(
    moduleName := "s4s-app",
    autoScalaLibrary := false,
    libraryDependencies := Nil,
    crossPaths := false,
    crossVersion := CrossVersion.disabled,
    mimaPreviousArtifacts := Set.empty,
    publishConfiguration := publishConfiguration.value.withOverwrite(true),
    publishLocalConfiguration :=
      publishLocalConfiguration.value.withOverwrite(true),
    Compile / packageDoc / publishArtifact := false,
    Compile / packageSrc / publishArtifact := false,
    Compile / doc / sources := Seq.empty,
    Test / test := {}
  )
