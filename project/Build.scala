import sbt._

object ProjectDependencies {

  val sapphire_extension = RootProject(file("../sapphire-extension"))


}

object ProjectBuild extends Build {

  import ProjectDependencies._

  lazy val root = Project(id = "sapphire-extension-demo", base = file(".")).dependsOn(sapphire_extension)

}