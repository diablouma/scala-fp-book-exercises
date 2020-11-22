import dataStructures.List._
import dataStructures._

object Exercise_3_18 {
  def main(args: Array[String]): Unit = {
    printArray(map(List(3, 4))(intItem => intItem * intItem))
    printArray(map(List(3, 4))(intItem => "Un entero multiplicado por 3 es:" + intItem * 3))
  }
}
