ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "learn-scala"
  )

libraryDependencies += "com.lihaoyi" %% "cask" % "0.9.1"