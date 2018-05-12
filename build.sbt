import com.typesafe.sbt.SbtNativePackager._

packageArchetype.java_application

name := "no-downers-finatra"

version := "0.1"

scalaVersion := "2.11.7"

lazy val versions = new {
  val finatra = "2.1.6"
  val guice = "4.0"
  val logback = "1.0.13"
  val finagleMetrics = "0.0.2"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % versions.finatra,
  "com.twitter.finatra" %% "finatra-httpclient" % versions.finatra,
  "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
  "com.twitter.inject" %% "inject-core" % versions.finatra,
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "com.github.rlazoti" %% "finagle-metrics" % versions.finagleMetrics,

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test",
  "com.twitter.finatra" %% "finatra-jackson" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test",
  "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

  "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test" classifier "tests",
  "com.twitter.finatra" %% "finatra-jackson" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-app" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-core" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-modules" % versions.finatra % "test" classifier "tests",
  "com.twitter.inject" %% "inject-server" % versions.finatra % "test" classifier "tests",

  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
  )

assemblyMergeStrategy in assembly := {
  case "BUILD" => MergeStrategy.discard
  case other => MergeStrategy.defaultMergeStrategy(other)
}