package Functional_Programming

import scala.collection.mutable.ArrayBuffer

object functionsrONot {
  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val T = stdin.readLine.trim.toInt

    for (nItr <- 1 to T) {
      val dd = ArrayBuffer.fill(500){}
      val n = stdin.readLine.trim.toInt
      for (iN <- 1 to n) {
        val xy = stdin.readLine.trim.split(" ").map(_.toInt)
//        if (dd(xy(0)).isNaN) dd. =  xy(1)
      println(dd))
      }
    }
  }
}
