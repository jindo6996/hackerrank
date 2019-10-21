package InterviewPreparationKit

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object ctci_bubble_sort {
  // Complete the countSwaps function below.
  def countSwaps(a: Array[Int], n: Int) {
    var count = 0
    for (
      i <- 0 until n;
      j <- i + 1 until n
    ) {
      if (a(i) > a(j)) {
        val tmp = a(i)
        a(i) = a(j)
        a(j) = tmp
        count += 1
      }
    }
    println(s"Array is sorted in $count swaps.")
    println(s"First Element: ${a.head}")
    println(s"Last Element: ${a.last}")
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    countSwaps(a, n)
  }
}
