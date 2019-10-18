import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution3 {

  // Complete the miniMaxSum function below.
  def miniMaxSum(arr: Array[Long]) {
    val sum:Long = arr.sum
    print(s"${sum - arr.max} ${sum - arr.min}")

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val arr = stdin.readLine.split(" ").map(_.trim.toLong)
    miniMaxSum(arr)
  }
}
