package InterviewPreparationKit

import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.mutable.ListBuffer

object sock_merchant {

  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    val max = ar.max
    val min = ar.min
    val arSorted = ar.foldLeft(Array.fill(max - min + 1)(0)) { (arr, n) =>
      arr(n - min) += 1
      arr
    }
    val res = arSorted.foldLeft(0)(_+ _/2)
    res
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("output.txt")

    val n = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
}
