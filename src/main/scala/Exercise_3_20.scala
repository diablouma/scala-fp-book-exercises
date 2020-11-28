import dataStructures.List._
import dataStructures._

object Exercise_3_20 {
  def main(args: Array[String]): Unit = {
    println(flatMap(List(3, 4, 5, 6, 7, 8))(item => List(item*2,item*2)))
  }
}
