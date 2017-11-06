package com.spotright.spotexcel

object Demo {

  def main(av: Array[String]): Unit = {
    println(workbook.shows)
  }

  def workbook: Workbook = {
    Workbook.withSheets(
      Worksheet.named("Employee Name & ID").withRows(
        Header.withCells(Cell("Name"), Cell("Department"), Cell("Employee ID")),
        Row.withCells(Cell("Lanny"), Cell("Engineering"), IntCell(2002)),
        Row.withCells(Cell("Brady"), Cell("Product"), IntCell(3001)),
        Row.withCells(Cell("Jessica"), Cell("Client Engagement"), IntCell(4001)),
        Row.withCells(Cell("Todd"), Cell("Sales & Business"), IntCell(1001))
      ),
      Worksheet.named("Metrics").withRows(
        Header.withCells(Cell("Category"), Cell("Count"), Cell("Population"), Cell("Percentage")),
        EmptyRow,
        Row.withCells(Cell("001"), IntCell(250), IntCell(768), NumCell(250.0/768)),
        Row.withCells(Cell("002"), IntCell(56), IntCell(500), NumCell(56.0/500)),
        Row.withCells(Cell("003"), IntCell(120), IntCell(600), NumCell(120.0/600)),
        Row.withCells(Cell("004"), LongCell(123456789L), LongCell(987654321L), NumCell(123456789.0/987654321L))
      )
    )
  }
}
