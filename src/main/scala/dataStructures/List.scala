package dataStructures

import scala.annotation.tailrec

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
    case Nil => sys.error("tail not available on empty list")
    case Cons(_, xs) => xs
  }

  def setHead[A](as: List[A], newHead: A): List[A] = as match {
    case Nil => sys.error("setHead not possible on empty list")
    case Cons(_, xs) => Cons(newHead, xs)
  }

  @tailrec
  def dropMine[A](as: List[A], quantityOfElementsToDrop: Int): List[A] = (as, quantityOfElementsToDrop) match {
    case (Nil, 0) => Nil
    case (Cons(h, xs), q) => if (q == 0) Cons(h, xs) else dropMine(xs, q - 1)
  }

  @tailrec
  def dropFromBookResolution[A](as: List[A], quantityOfElementsToDrop: Int): List[A] = {
    if (quantityOfElementsToDrop <= 0) as
    else as match {
      case Nil => Nil
      case Cons(_, t) => dropFromBookResolution(t, quantityOfElementsToDrop - 1)
    }
  }

  // the key here is the pattern guard
  // if(f(h)) before the =>
  // what the exercise says is that I should continue removing
  // if the function matches, whenever the function does not match
  // I should stop
  // At the beginning I understood I should delete all the elements that
  // matches the condition
  @tailrec
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case _ => l
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
