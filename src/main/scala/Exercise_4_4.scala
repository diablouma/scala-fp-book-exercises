import dataStructures.Option.sequence
import dataStructures.Some
import dataStructures.None
import dataStructures.List

object Exercise_4_4 {
  def main(args: Array[String]): Unit = {
    println(sequence(List(Some(4), Some(5), Some(6))))
    println(sequence(List(Some(4), None, Some(6))))
  }
}
