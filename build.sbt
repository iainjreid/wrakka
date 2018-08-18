name := "wrakka"
organization := "com.candied"
version := "0.0.1"
scalaVersion := "2.12.6"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

bintrayPackageLabels := Seq("akka", "utilities")

lazy val akkaVersion = "2.5.14"
lazy val akkaHttpVersion = "10.1.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream"          % akkaVersion
)
