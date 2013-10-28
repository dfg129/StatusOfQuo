
import play.Project._

name := "StatusOfQuo"

version := "1.0"

playScalaSettings


resolvers ++= Seq(
"Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
"Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
"org.reactivemongo" % "play2-reactivemongo_2.10" % "0.10.0-SNAPSHOT" exclude("com.github.scala-incubator.io", "scala-io-file_2.10.0-RC1")
)


