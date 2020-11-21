package dataStructures

import scala.annotation.tailrec

// sealed: all the implementations must be in this file
sealed trait List[+A] // + is a covariant which means that if A is subtype of B, then List[A] is subtype of List[B]
case object Nil extends List[Nothing] // first data constructor, declared with case// Nothing is a subtype of all types
// then List[Nothing] is a subtype of all List so Nil will be subtype of any List
case class Cons[+A](head: A, tail: List[A]) extends List[A] // second data constructor

//companion object:
object List {

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((_, acc) => acc + 1)
  }

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
        // on the first iteration I call f(0, el primer elemento de la lista)
        // resulting in: 0, 1
        // I can evaluate the function f, and get a result from the beginning
      //   call:     Cons(1, Cons(2,Nil))
        // foldLeft(Cons(2,Nil), f(List(), 1) devuelve Cons(1, List())
        // next call: for Cons(2, Nil)
        // foldLeft(Nil, f(list(1), 2) devuelve Cons(2, list(1))
      case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
    }
  }

  def reverse[A](l: List[A]): List[A] = {
//    List(1,2)
    foldLeft(l, List[A]())((acc, h) => Cons(h, acc))
  }

  def foldRight[A,B](as: List[A], z:B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      // on the first call I call f(the first element of the list, recursive call,
      // entonces solo cuando llegue al final tendré el primer resultado del acumulador
      // 0, foldRight(tail, accumulador)
      // al final de la lista es cuando recién tendré el primer resultado
      // e iré acumulando hacia el inicio de la lista;
      // this foldRight function also is not tail recursive
        // I will be able to get the result of evaluating the exection of f
        // only when foldRight reached the last element, as on that point
        // I will have the first return for foldRight(xs,z)
        // than will be used to evaluate f
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def sum2(ns: List[Int]) =
    foldRight(ns, 0)((x,y) => x + y)

  def product2(ns: List[Double]) =
  // _ * _ in cases where scala is able to infer the types,
  // useful when parameters are used just once in the body of the function
  // each underscore introduces a new unnamed function
  // arguments are introduced from left to righ
  // _ * 2 means (x,2) => x*2
  // _.head means xs => xs.head
  // _ drop _ means (x,y) => x.drop(y)
    foldRight(ns, 1.0)(_ * _)


  // sum and product are really similar
  // differences, the one return 0 and the other 1 in case of Nil
  // the operation is + or *
  // we can extract this to subexpressions
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(x, xs) => x * product(xs)
  }

  def sumWithFoldLeft(ints: List[Int]): Int = {
      foldLeft(ints, 0)(_ + _)
  }

  def productWithFoldLeft(ints: List[Double]): Double = {
      foldLeft(ints, 1.0)(_ * _)
  }

  def lengthWithFoldLeft[A](l: List[A]): Int = {
    foldLeft(l, 0)((acc, _) => acc + 1 )
  }

  def tail[A](as: List[A]): List[A] = as match {
    case Nil => sys.error("tail not available on empty list")
    case Cons(_, xs) => xs
  }

  def setHead[A](as: List[A], newHead: A): List[A] = as match {
    case Nil => sys.error("setHead not possible on empty list")
    case Cons(_, xs) => Cons(newHead, xs)
  }

  // COnstant time, O(1) means that the function
  //  In "constant time" generally means that the time it will
  //  take to compute the result is independent of the size of the input.
  def init[A](l: List[A]): List[A] = {
    l match {
        case Cons(_, Nil) => Nil
        case Cons(h, t) => Cons(h, init(t)) // here we doing something else with the return of
        // init function so is to tail rec.
    }
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

  // currying this way, scala type inferer will be able to determine the types
  // of the second group of arguments
  @tailrec
  def dropWhileCurried[A](l: List[A])(f: A => Boolean): List[A] = l match {
    case Cons(h, t) if f(h) => dropWhileCurried(t)(f)
    case _ => l
  }

  def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h, t) => Cons(h, append(t, a2))
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
