package Functional_Programming

object FpUpdateList {
  def main(args: Array[String]): Unit = {
    val a = List[Int](1,-4,5, 7)
    val abs = f(a)
    println(abs)
  }
  def f(arr:List[Int]):List[Int] = {
    arr.map( Math.abs(_))
  }
}
