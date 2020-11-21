import dataStructures.List._
import dataStructures._

object Exercise_3_14 {
  def main(args: Array[String]): Unit = {
    println(appendInTermsOfFoldLeft(List(1, 2, 3), List(4,5,6)))
    println(appendInTermsOfFoldRight(List(1, 2, 3), List(4,5,6)))
  }
}
