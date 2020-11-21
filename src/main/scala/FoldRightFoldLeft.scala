import dataStructures.List._
import dataStructures._
object FoldRightFoldLeft {
  def main(args: Array[String]): Unit = {
    foldRight(List(1,2,3), 0)((x, y) => {
      println("fold right val1: " + x + " val2: " + y)
      x + y
    })

    foldLeft(List(1,2,3), 0)((x, y) => {
      println("fold left val1: " + x + " val2: " + y)
      x + y
    })
  }
}
