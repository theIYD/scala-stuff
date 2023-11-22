ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "use-play-framework",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.12", "3.3.1"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    )
  )