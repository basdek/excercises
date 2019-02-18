package com.basdek

object Exercise3 extends App {

  // ugly procedural implementation

  def sumSquares(xs: List[Int]): Int = {

    var acc = 0

    for (i ← 0 until xs.length)
      acc += xs(i) * xs(i)

    acc

  }


  // 1) Rewrite it using standard library functions 

  def sumSquares2(xs: List[Int]) : Int = xs.map(x => x*x).sum

  // 2) Rewrite it using pure scala without using any var or stdlib functions
  def sumSquares3(xs : List[Int]) : Int = xs.map(x => x*x).fold(0)((acc, x) => acc+x)

  // 3) What would you do if you wanted to generalize this to something that's not an Int?
  //I would use a type class, like so:
  def sumSquares4[T](xs : List[T]) (implicit n : Numeric[T]) : T =
    xs.map(x => n.times(x,x)).fold(n.zero)((acc,x) => n.plus(acc, x))

  val lst = List(1,2,3,4,5)
  assert(sumSquares(lst) == sumSquares2(lst) && sumSquares(lst) == sumSquares3(lst) && sumSquares(lst) == sumSquares4(lst))



}
