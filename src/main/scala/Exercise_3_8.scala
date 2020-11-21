import dataStructures.List._
import dataStructures._

object Exercise_3_8 {
  def main(args: Array[String]): Unit = {
    //we get back the original list
    // Nil constructor is replaced by arg z
    // f replaces the the Cons constructor
    print(foldRight(List(1,2,3), Nil: List[Int])(Cons(_,_)))
  }
}
