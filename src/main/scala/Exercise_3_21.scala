import dataStructures.List._
import dataStructures._

object Exercise_3_21 {
  def main(args: Array[String]): Unit = {
    println(filterUsingFlatMap(List(3, 4, 5, 6, 7, 8))(_ % 2 == 0))
  }
}
