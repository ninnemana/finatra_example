name := "example"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.twitter" %% "finatra" % "1.5.2",
  "com.codahale" % "jerkson_2.9.1" % "0.5.0"
)

resolvers +=
  "Twitter" at "http://maven.twttr.com"

resolvers +=
  "repo.codahale.com" at "http://repo.codahale.com"