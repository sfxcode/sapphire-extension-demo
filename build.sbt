name := "sapphire-extension-demo"

organization := "com.sfxcode.sapphire"

version := "0.3.0"

scalaVersion := "2.11.6"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.7"

mainClass := Some("Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots",
  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "3.0.1" % "test"
)

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.11"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"
