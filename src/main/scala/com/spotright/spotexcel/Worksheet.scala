package com.spotright.spotexcel

case class Worksheet(name: String, rows: Seq[XRow], defaultColumnWidth: Int = 80) {

  lazy val shows: String = {
    val sb = StringBuilder.newBuilder

    sb ++= "<ss:Worksheet ss:Name="
    sb += '"'
    sb ++= name
    sb += '"'
    sb ++= ">"
    sb ++= "\n"
    sb ++= "  <ss:Table ss:DefaultColumnWidth="
    sb += '"'
    sb.append(defaultColumnWidth)
    sb += '"'
    sb ++= ">"
    sb ++= "\n"
    sb ++= rows.map{_.shows}.mkString("\n")
    sb ++=
      """
        |  </ss:Table>
        |</ss:Worksheet>""".stripMargin

    sb.result()
  }
}

object Worksheet {

  def named(name: String): WS = WS(name)

  case class WS(name: String) {
    def withRows(rows: XRow*): Worksheet = Worksheet(name, rows)
  }
}
