import sbt._
import Keys._

object Slf4sBuild extends Build {
  lazy val slf4s = Project("sl4s-api", file(".")) settings(
    organization := "org.slf4s",
    name := "slf4s-api",
    scalaVersion := "2.10.3",
    crossScalaVersions := Seq("2.10.0", "2.10.1", "2.10.2", "2.10.3"),
    version := "1.7.5-SNAPSHOT",
    publishMavenStyle := true,
    publishArtifact in Test := false,
    pomIncludeRepository := { _ => false },
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("http://slf4s.org/")),
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
       Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.5",
      "org.scalatest" %% "scalatest" % "2.0" % "test",
      "org.mockito" % "mockito-all" % "1.9.5"
    )
  )
}
