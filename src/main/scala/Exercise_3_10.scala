import dataStructures.List._
import dataStructures._

object Exercise_3_10 {
  def main(args: Array[String]): Unit = {
    print(foldLeft(List(1,2,3), 0)((x,y) => x + y))
  }
}
