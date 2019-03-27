package com.spotright.spotexcel

case class Column(width: Int = 80, autoFitWidth: Boolean = false) {

  lazy val shows: String = {
    val sb = StringBuilder.newBuilder

    sb ++= "<ss:Column ss:Width="
    sb += '"'
    sb ++= width.toString
    sb += '"'
    if (autoFitWidth) {
      sb ++= """ss:AutoFitWidth="1""""
    }
    sb ++= "/>"

    sb.result()
  }
}