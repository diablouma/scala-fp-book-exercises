import scala.annotation.tailrec

object Exercise2_2 {
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def go(n: Int): Boolean = {
      if (n == as.length - 1) true
      else if (ordered(as(n), as(n + 1))) go(n + 1)
      else false
    }
    go(0)
  }

  def main(args: Array[String]): Unit = {
    println(isSorted[Int](Array[Int](1,2,3), (prev: Int, next: Int) => prev < next))
    println(isSorted[Int](Array[Int](1,3,2), (prev: Int, next: Int) => prev < next))
    println(isSorted[String](Array[String]("a","b","c"), (prev: String, next: String) => prev < next))
    println(isSorted[String](Array[String]("d","b","c"), (prev: String, next: String) => prev < next))
  }
}
