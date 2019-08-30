package Functional_Programming
import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object EvalEx {
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    for (nItr <- 1 to n) {
      val x = stdin.readLine.trim.toDouble
      println("%.4f".format(recursion(x,1, x, 1)+1))
    }
  }
  def recursion(x: Double, i: Int, pow: Double, factorial:Int ) : Double ={
    println(i, pow, factorial)
    if (i==9) return (pow/factorial)
    (pow/factorial) + recursion(x, i+1, pow * x, factorial*(i+1))
  }
}
