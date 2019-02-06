object Exercise3 extends App {

  // ugly procedural implementation

  def sumSquares(xs: List[Int]): Int = {

    var acc = 0

    for (i ← 0 until xs.length)

      acc += xs(i) * xs(i)

    acc

  }


  // 1) Rewrite it using standard library functions 

  // 2) Rewrite it using pure scala without using any var or stdlib functions

  // 3) What would you do if you wanted to generalize this to something that's not an Int?

}
