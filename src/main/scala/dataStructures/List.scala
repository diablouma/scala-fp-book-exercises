package dataStructures

// sealed: all the implementations must be in this file
sealed trait List[+A] // + is a covariant which means that if A is subtype of B, then List[A] is subtype of List[B]
case object Nil extends List[Nothing] // first data constructor, declared with case// Nothing is a subtype of all types
// then List[Nothing] is a subtype of all List so Nil will be subtype of any List
case class Cons[+A](head: A, tail: List[A]) extends List[A] // second data constructor

//companion object:
object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => xs
  }

  def setHead[A](as: List[A], newHead: A): List[A] = (as, newHead) match {
    case (_, Nil) => as
    case (_, null) => as
    case (Cons(_, xs), x) => Cons(x, xs)
  }

  // A* variadic function, accepts zero or more arguments of type A
  // Allows to call like List(1,2,3,4) List("hi", "bye")
  // _* is a special instance of type ascription which tells the
  // compiler to treat a single argument of a sequence type as a
  // \variable argument sequence, i.e. varargs.
  def apply[A](as: A*): List[A] =
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
