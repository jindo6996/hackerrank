object ListReplication extends App {
  def f(n:Int) = {
    for (a <- 1 to n){
      val x = scala.io.StdIn.readInt.toString()+"\n"
      print(x*n)
    }
  }
  val n = scala.io.StdIn.readInt
  f(n)
}
