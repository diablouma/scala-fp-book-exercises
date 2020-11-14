import scala.annotation.tailrec

object MyModule {
  def abs(n: Int): Int =
    if (n < 0) -n
    else n

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int =
      if( n<=0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  def fibonacci(nth: Int): Int = {
    var serie = Array(0,1)
    var counter = 0
    var result = 0
    do {
      if (nth <= serie.length) {
        result = serie(nth - 1)
        return result
      } else {
        serie :+= (serie(counter) + serie(counter + 1))
        result = serie(serie.length - 1)
        counter = counter + 1
      }
    } while(counter <= nth)
     result
  }

  def fibonacciRecursiveWithArray(nth: Int): Int = {
    @tailrec
    def go(fibSerie: Array[Int], counter: Int):Int = {
      if (counter == nth) fibSerie(nth - 1)
      else {
        val newArray = fibSerie :+ (fibSerie(counter) + fibSerie(counter + 1))
        go(newArray, counter + 1)
      }
    }

    go(Array(0,1), 0)
  }

  def fibonacciRecursive(nthInSeries: Int): Int = {
      def go(prev: Int, next: Int, nthInSeries: Int): Int  = {
        if (nthInSeries == 0 || nthInSeries == 1) prev
        else {
          println("serie", prev, next)

          go(next, next + prev, nthInSeries - 1)
        }
      }

      go(0,1, nthInSeries)
  }

  private def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("factorial", 4, factorial))
    println(formatResult("fibonacci", 4, fibonacci))
    println("Fibonacci", fibonacci(2))
    println("FibonacciRecursiveWithArray", fibonacciRecursiveWithArray(2))
    println("FibonacciRecursive", fibonacciRecursive(3))
  }
}
