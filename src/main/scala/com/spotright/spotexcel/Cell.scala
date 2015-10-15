package com.spotright.spotexcel

sealed abstract class XCell {

  def shows: String

  def showgen[A](ssType: String): A => String = {
    (a: A) =>
      val sb = StringBuilder.newBuilder
      sb ++= "<ss:Cell><ss:Data ss:Type="
      sb += '"'
      sb ++= ssType
      sb += '"'
      sb ++= ">"
      sb.append(a)
      sb ++= "</ss:Data></ss:Cell>"
      sb.result()
  }
}

case class Cell(data: String) extends XCell {
  def shows: String = showgen[String]("String")(data)
}

case class IntCell(data: Int) extends XCell {
  def shows: String = showgen[Int]("Number")(data)
}

case class LongCell(data: Long) extends XCell {
  def shows: String = showgen[Long]("Number")(data)
}

case class NumCell(data: Double) extends XCell {
  def shows: String = showgen[Double]("Number")(data)
}

case class BoolCell(data: Boolean) extends XCell {
  def shows: String = showgen[Boolean]("Boolean")(data)
}

case class DateTimeCell(data: String) extends XCell {
  def shows: String = showgen[String]("DateTime")(data)
}

case object EmptyCell extends XCell {
  def shows: String = "<ss:Cell />"
}
