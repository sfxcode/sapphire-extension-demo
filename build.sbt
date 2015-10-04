name := "sapphire-extension-demo"

organization := "com.sfxcode.sapphire"

version := "0.4.5"

scalaVersion := "2.11.7"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalacOptions += "-target:jvm-1.8"

mainClass := Some("com.sfxcode.sapphire.extension.demo.Application")

resolvers ++= Seq(
  "sfxcode-releases" at "https://raw.github.com/sfxcode/mvn-repo/master/releases",
  "sfxcode-snapshots" at "https://raw.github.com/sfxcode/mvn-repo/master/snapshots",
  "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
)


libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test"

libraryDependencies += "com.sfxcode.sapphire" %% "sapphire-extension" % "0.4.5"

libraryDependencies += "org.json4s" %% "json4s-native" % "3.2.11"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
