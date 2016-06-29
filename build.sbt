name := "sapphire-extension-demo"

organization := "com.sfxcode.sapphire"

version := "0.5.4"

scalaVersion := "2.11.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.8"

mainClass := Some("com.sfxcode.sapphire.extension.demo.Application")

resolvers ++= Seq(

  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)


libraryDependencies += "org.specs2" %% "specs2-core" % "3.8.4" % "test"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.4.0"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.7"
