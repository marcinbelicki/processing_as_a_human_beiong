import Dependencies._

ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "processing_as_a_human_beiong",
    libraryDependencies += munit % Test
  )

libraryDependencies += "org.processing" % "core" % "3.3.7"
