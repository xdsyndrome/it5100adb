ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
    "com.typesafe.slick" %% "slick" % "3.3.3",
    "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
    "com.typesafe.slick" %% "slick-codegen" % "3.3.2",
    "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
    "com.typesafe.play" %% "play-slick" % "5.0.0",
    "org.slf4j" % "slf4j-nop" % "1.7.36"
)

(Compile / sourceGenerators) += slick.taskValue // Automatic code generation on build

lazy val slick = taskKey[Seq[File]]("Generate Tables.scala")
slick := {
    val dir = (Compile / sourceManaged) value
    val outputDir = dir / "slick"
    val url = "jdbc:postgresql://[::1]:5433/postgres?user=postgres&password=123;INIT=runscript from 'src/main/sql/createTables.sql'" // connection info
    val jdbcDriver = "org.postgresql.Driver"
    val slickDriver = "slick.jdbc.PostgresProfile"
    val pkg = "models"

    val cp = (Compile / dependencyClasspath) value
    val s = streams value

    runner.value.run("slick.codegen.SourceCodeGenerator",
        cp.files,
        Array(slickDriver, jdbcDriver, url, outputDir.getPath, pkg),
        s.log).failed foreach (sys error _.getMessage)

    val file = outputDir / pkg / "Tables.scala"

    Seq(file)
}