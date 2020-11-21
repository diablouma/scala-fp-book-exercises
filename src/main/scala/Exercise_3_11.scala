import dataStructures.List._
import dataStructures._

object Exercise_3_11 {
  def main(args: Array[String]): Unit = {
    println(sumWithFoldLeft(List(1,2,3)))
    println(productWithFoldLeft(List(4.0, 5.0)))
    println(lengthWithFoldLeft(List(1,2,4,5)))
  }
}
