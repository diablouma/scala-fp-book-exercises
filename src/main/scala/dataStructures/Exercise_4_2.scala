package dataStructures

import dataStructures.List.flatMap

object Exercise_4_2 {
  def main(args: Array[String]): Unit = {
//    def
  }

  def variance(xs: Seq[Double]): Option[Double] = {
    mean(xs).flatMap(m => mean(xs.map(item => math.pow(item - m, 2))))
  }

  def lift[A,B](f: A => B): Option[A] => Option[B] = {
    (maybeA: Option[A]) => (maybeA: Option[A]).map(f)
  }

      def mean(xs: Seq[Double]): Option[Double] =
        if(xs.isEmpty) None
        else Some(xs.sum / xs.length)
  }
}
