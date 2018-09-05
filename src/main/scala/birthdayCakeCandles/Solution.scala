package birthdayCakeCandles

object Solution {
  def birthdayCakeCandles(ar: Array[Int]): Int = {
    var max = -1
    var res = 0
    ar.foreach(
      x => if (x>max) {
        max = x
        res=1
      } else if (x == max) res = res+1
    )
    res
  }
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val arCount = stdin.readLine.trim.toInt
    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = birthdayCakeCandles(ar)
    println(result)

  }
}
