object Exercise_3_4 {
  def main(args: Array[String]): Unit = {
    val aList = dataStructures.List(1,2,3)
    println(dataStructures.List.dropMine(aList, 1))
    println(dataStructures.List.dropMine(aList, 2))
    println(dataStructures.List.dropMine(aList, 3))
    println(dataStructures.List.dropFromBookResolution(dataStructures.Nil, 3))
    println(dataStructures.List.dropMine(dataStructures.Nil, 3))
  }
}
