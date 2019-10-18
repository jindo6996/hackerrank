package Algorithms

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._

object Result {

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def pickingNumbers(a: Array[Int]): Int = {
    val  countSort :Array[Int] = new Array[Int](102);
    var max = -1
    var min = 1000
    a.foreach(x =>{
      countSort(x) += 1
    })
    for (i <- 0  to 100) {
      if (countSort(i) + countSort(i+1) > max) max = countSort(i) + countSort(i+1)
    }
    max
  }

}

object picking_numbers {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter("./output")

    val n = StdIn.readLine.trim.toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.pickingNumbers(a)

    printWriter.println(result)

    printWriter.close()
  }
}
