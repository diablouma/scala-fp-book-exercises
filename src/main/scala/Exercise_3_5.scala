import dataStructures.List.dropWhile

object Exercise_3_5 {
  def main(args: Array[String]): Unit = {
    println(dropWhile[Int](dataStructures.List[Int](1), (item: Int) => item % 1 == 0 ))
    println(dropWhile[Int](dataStructures.List[Int](1), (item: Int) => item % 1 != 0 ))
    println(dropWhile[Int](dataStructures.List[Int](1,10,5,6), (item: Int) => item % 5 == 0 ))
    println(dropWhile[Int](dataStructures.List[Int](5,11,5,6), (item: Int) => item % 5 == 0 ))
  }
}
