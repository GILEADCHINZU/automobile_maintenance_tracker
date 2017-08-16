
name := """automobiletracker"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.apache.poi" % "poi" % "3.12",
  "org.apache.poi" % "poi-ooxml" % "3.9",
  "redis.clients" % "jedis" % "2.9.0"
)

pipelineStages := Seq(digest, gzip)

PlayKeys.externalizeResources := false
