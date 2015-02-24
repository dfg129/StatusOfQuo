name := "StatusOfQuo"

name := """website"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
    "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23", 
	"org.reactivemongo" %% "play2-reactivemongo" % "0.10.5.0.akka23", 
	"com.typesafe.play" % "play-json_2.11" % "2.4.0-M2", 
	"ch.qos.logback" % "logback-classic" % "1.1.2"
)

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"




