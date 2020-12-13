package dataStructures

import dataStructures.List.{appendInTermsOfFoldRight, elementAt}

import scala.annotation.tailrec

sealed trait Option[+A] {
  def map[B](f: A => B): Option[B] = {
    this match {
      case None => None
      case Some(a) => Some(f(a))
    }
  }

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    a flatMap (aa => b map (bb => f(aa, bb)))

  def getOrElse[B>:A](default: => B): B = {
    this match {
      case None => default
      case Some(a) => a
    }
  }

  def flatMap[B](f: A => Option[B]): Option[B] = {
    this match {
      case None => None
      case Some(a) => f(a)
    }
  }

  def orElse[B>:A](ob: => Option[B]): Option[B] = {
    this match {
      case None => ob
      case _ => this
    }
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => this
    case _ => None
  }
}

case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

object Option {
  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs).flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    val lengthOfList: Int = List.length(a)
    
    @tailrec
    def go(acc: Int, result: List[A]): Option[List[A]] = {
      val element = elementAt(a, acc)
      (acc, element) match {
        case (_, None) => None
        case (_,_) if acc == lengthOfList => Some(result)
        case (_, Some(a)) => go(acc + 1, appendInTermsOfFoldRight(result, List(a)))
      }
    }

    go(0, List[A]())
  }
}
