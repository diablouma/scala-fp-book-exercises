import scala.annotation.tailrec

object PolymorphicFunctions {
  def findFirst(ss: Array[String], key: String): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n>= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def findFirstGeneric[A](ss: Array[A], key: A): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n>= ss.length) -1
      else if (ss(n) == key) n
      else loop(n + 1)
    }

    loop(0)
  }

  def findFirstGenericWithCallback[A](ss: Array[A], condition: A => Boolean): Int = {
    @tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (condition(ss(n))) n
      else loop(n + 1)
    }

    loop(0)
  }

  def conditionToFindFirst[A] (currentElement: A): Boolean = {
    currentElement == "b"
  }


  def main(args: Array[String]): Unit = {
    println(findFirst(Array("a", "b", "c"), "d"))
    println(findFirstGeneric[String](Array[String]("a", "b", "c"), "b"))
    println(findFirstGenericWithCallback[String](Array[String]("a", "b", "c"), (currentElement: String) => currentElement == "b"))
    println(findFirstGenericWithCallback[String](Array[String]("a", "b", "c"), conditionToFindFirst))
  }
}
