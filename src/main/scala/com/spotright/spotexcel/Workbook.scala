package com.spotright.spotexcel

case class Workbook(sheets: Seq[Worksheet]) {

  lazy val shows = {
    val sb = StringBuilder.newBuilder

    sb ++=
      """<?xml version="1.0"?>
        |<ss:Workbook xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet">
        |    <ss:Styles>
        |        <ss:Style ss:ID="1">
        |            <ss:Font ss:Bold="1" />
        |        </ss:Style>
        |        <ss:Style ss:ID="2">
        |            <ss:NumberFormat ss:Format="#,###" />
        |            <ss:Alignment ss:Horizontal="Left" ss:Vertical="Bottom" />
        |        </ss:Style>
        |    </ss:Styles>
        |""".stripMargin
    sb ++= sheets.map{_.shows}.mkString("\n")
    sb ++= "\n"
    sb ++= "</ss:Workbook>"

    sb.result()
  }
}

object Workbook {

  def withSheets(sheets: Worksheet*): Workbook = Workbook(sheets)
}
