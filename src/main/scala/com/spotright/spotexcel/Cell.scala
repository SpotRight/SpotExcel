package com.spotright.spotexcel

sealed abstract class XCell {

  def shows: String

  def showgen[A](ssType: String, attrs: String*): A => String = {
    (a: A) =>
      val sb = StringBuilder.newBuilder
      sb ++= "<ss:Cell"
      attrs.foreach {
        attr =>
          sb ++= " "
          sb ++= attr
      }
      sb ++= "><ss:Data ss:Type="
      sb += '"'
      sb ++= ssType
      sb += '"'
      sb ++= ">"
      sb.append(a)
      sb ++= "</ss:Data></ss:Cell>"
      sb.result()
  }
}

case class Cell(data: String, attrs: String*) extends XCell {
  def shows: String = showgen[String]("String", attrs: _*)(XmlUtility.escape(data))
}

case class IntCell(data: Int, attrs: String*) extends XCell {
  def shows: String = showgen[Int]("Number", attrs: _*)(data)
}

case class LongCell(data: Long, attrs: String*) extends XCell {
  def shows: String = showgen[Long]("Number", attrs: _*)(data)
}

case class NumCell(data: Double, attrs: String*) extends XCell {
  def shows: String = showgen[Double]("Number", attrs: _*)(data)
}

case class BoolCell(data: Boolean, attrs: String*) extends XCell {
  def shows: String = showgen[Boolean]("Boolean", attrs: _*)(data)
}

case class DateTimeCell(data: String, attrs: String*) extends XCell {
  def shows: String = showgen[String]("DateTime", attrs: _*)(data)
}

case object EmptyCell extends XCell {
  def shows: String = "<ss:Cell />"
}
