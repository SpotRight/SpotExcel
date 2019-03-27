import com.spotright.sbt._

lazy val spotexcel =
  (project in file(".")).
  settings(spotright.settingsLog4J: _*).
  settings(
    name := "spotexcel-core",
    organization := "com.spotright.spotexcel",
    version := "1.0.2",
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
    )
  )
