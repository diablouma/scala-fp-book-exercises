import dataStructures.List._

object Exercise_3_2 {
  def main(args: Array[String]): Unit = {
    val aList = dataStructures.List(1,2,3)
    println(tail(aList))
    val anotherList = dataStructures.Nil
    println(tail(anotherList))
    val anotherList2 = dataStructures.List(1)
    println(tail(anotherList2))
    val anotherList3 = dataStructures.List("1","2")
    println(tail(anotherList3))
  }
}
