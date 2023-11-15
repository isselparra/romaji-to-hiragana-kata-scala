ThisBuild / scalaVersion := "2.13.12"
ThisBuild / organization := "com.example"

lazy val romajiToHiraganaKata = (project in file("."))
  .settings(
    name := "Romaji to Hiragana Kata",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % "test",
  )
