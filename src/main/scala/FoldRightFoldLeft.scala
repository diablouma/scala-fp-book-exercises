import dataStructures.List._
import dataStructures._
object FoldRightFoldLeft {
  def main(args: Array[String]): Unit = {
    foldRight(List(1,2,3), 0)((x, z) => {
      println("fold right val1: " + x + " val2: " + z)
      x + z
    })

    foldLeft(List(1,2,3), 0)((y, z) => {
      println("fold left val1: " + z + " val2: " + y)
      z + y
    })
  }
}
