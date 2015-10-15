package com.spotright.spotexcel

sealed abstract class XRow {

  def shows: String

  def showgen(cells: Seq[XCell], attrs: String*): String = {
    val sb = StringBuilder.newBuilder

    sb ++= "<ss:Row"
    attrs.foreach {
      attr =>
        sb ++= " "
        sb ++= attr
    }
    sb ++= ">\n"
    cells.foreach {
      cell =>
        sb ++= "  "
        sb ++= cell.shows
        sb ++= "\n"
    }
    sb ++= "</ss:Row>"

    sb.result()
  }
}

case class Header(cells: Seq[XCell]) extends XRow {

  def shows: String = showgen(cells, """ss:StyleID="1"""")
}

object Header {
  def withCells(cells: XCell*): Header = Header(cells)
}

case class Row(cells: Seq[XCell]) extends XRow {
  def shows: String = showgen(cells)
}

object Row {
  def withCells(cells: XCell*): Row = Row(cells)
}

case object EmptyRow extends XRow {
  val cells = Seq.empty[XCell]
  def shows = "<ss:Row />"
}
