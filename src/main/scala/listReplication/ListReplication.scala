package listReplication

object Solution extends App {
//  val filename = "/home/sepuser1/dailylab/hackerrank/src/main/scala/listReplication/ListReplication.txt"
  def f(n:Int, x:List[Int]): Unit = {
    x.foreach(a => {
      val x = a.toString+"\n"
      print(x*n)
    })
  }
  def displayResult(arr:List[Int]) = f(arr(0).toInt,arr.drop(1))
  displayResult(io.Source.stdin.getLines.toList.map(_.trim).map(_.toInt))
}
