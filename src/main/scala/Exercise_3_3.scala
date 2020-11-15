object Exercise_3_3 {
  def main(args: Array[String]): Unit = {
    val aList = dataStructures.List(1,2,3)
    println(dataStructures.List.setHead(aList, 4))
    println(dataStructures.List.setHead(aList, dataStructures.Nil))
    println(dataStructures.List.setHead(aList, null))
  }
}
