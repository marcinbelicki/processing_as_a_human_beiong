package pl.daria.math

object QuestionOne extends App {

  val allMargins = 30 to 46

  for {
    c <- allMargins
    d <- allMargins
    x = (700 - 2 * c) / 6.0
    y = (1000 - 2 * d) * .125
    gcdXY = gcd(gcd(x, y), gcd(c, d))
    if gcdXY >= 5
  } {
    println(s"x = $x")
    println(s"y = $y")
    println(s"c = $c")
    println(s"d = $d")
    println(s"gcdXY = $gcdXY")
  }


  def gcd(a: Double, b: Double): Double = {
    if (a < b) return gcd(b, a)
    // base case
    if (Math.abs(b) < 0.001) a
    else gcd(b, a - Math.floor(a / b) * b)
  }
}
