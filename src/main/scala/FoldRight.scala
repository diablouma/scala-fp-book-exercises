import dataStructures.Cons
import dataStructures.Nil
import dataStructures.List._
object FoldRight {
  foldRight(Cons(1, Cons(2, Cons(3, Nil))), 0)((x, y) => x + y)
  1 + foldRight(Cons(2, Cons(3, Nil)), 0)((x, y) => x + y)
  1 + (2 + foldRight(Cons(3, Nil), 0)((x, y) => x + y))
  1 + (2 + (3 + foldRight(Cons(3, Nil), 0)((x, y) => x + y)))
  1 + (2 + (3 + 0))
  6
}
