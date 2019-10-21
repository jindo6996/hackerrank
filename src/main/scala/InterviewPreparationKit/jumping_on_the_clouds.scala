package InterviewPreparationKit

import java.io._
import java.math._
import java.security._
import java.text._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.math.min

object jumping_on_the_clouds {

  def jumpingOnClouds(c: Array[Int], n : Int): Int = {
    val minAtStepList = Array.fill(n + 5)(1000100000)
    minAtStepList(0) = 0;
    minAtStepList(1) = 0;
    for (i <- 0 to c.length -2 )
      if (c(i+1) == 0) minAtStepList(i + 2) = min(minAtStepList(i + 1), minAtStepList(i)) + 1
    minAtStepList(n)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter("output.txt")

    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c, n)

    printWriter.println(result)

    printWriter.close()
  }
}
