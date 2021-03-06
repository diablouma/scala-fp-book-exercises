object FollowingTypesToImpl {
  // partial application refers to give a fixed value for the first argument
  // and having a function that takes that fixed arg and other args
  def partial1[A,B,C](a: A, f:(A,B) => C): B => C = (b: B) => f(a, b)
  // currying: coverting a function of n arguments into multiple subsequent functions
  // that each take a single argument
 // 1. What is the return type? return A => (B => C)
  // 2. need a function literal that receives a type A as input
  // 3. need a function literalmthat receives b as input
  // 4.. need to return C, and the only way os to tall f with values of type A and B
  def curry[A,B,C](f: (A,B) => C): A => (B => C) = (a: A) => (b: B) => f(a, b)
  // return type (A,B) => C
  // the left side will be (a: A, b: B)
  // the only way to get C, is to call to A => B => C
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

  //return type: A => C
  // start with: (a: A) =>
  // to obtain C, I need a function that receives a type B f(b: B) returns C
  // type B can be gotten with a the function g that receives a type A g(a: A) returns B
  // to obtain  f(g(a: A))
  def compose[A,B,C](f: B => C, g: A => B): A => C = (a: A) => f(g(a: A))

  def main(args: Array[String]): Unit = {

  }
}
