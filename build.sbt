name := "sapphire-extension-demo"

organization := "com.sfxcode.sapphire"

version := "0.6.1"

scalaVersion := "2.12.2"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.8"

mainClass := Some("com.sfxcode.sapphire.extension.demo.Application")

val sapphire_extension = RootProject(file("../sapphire-extension"))

lazy val root = Project(id = "sapphire-extension-demo", base = file(".")).dependsOn(sapphire_extension)


resolvers ++= Seq(

  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

resolvers += "bintray" at "https://jcenter.bintray.com"



libraryDependencies += "org.specs2" %% "specs2-core" % "3.9.2" % "test"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.5.2"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"



