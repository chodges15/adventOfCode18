package day3

import scala.io.Source

class Claim (val claimInput: String) {

  // is there a way to use dependency injection for the parsing aspect?
  val claimPattern = raw"""\#(\d) @ (\d),(\d): (\d)x(\d)""".r;

  val matches = claimPattern.findAllMatchIn(claimInput);
  val (claimNumber, xCoordinate, yCoordinate, width, heightInt) =
  {
    for (m <- matches) {
      case m.
    }

  }

  override def toString: String = s"Claim $claimNumber: [$xCoordinate, $yCoordinate] of size $width x $height"

}

class Library(sourceData: String) {

  val claimsList: Array[String] = Source.fromFile(sourceData).mkString.split("\n")

  claimsList.map(_.toString)

}