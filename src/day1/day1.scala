package day1
import scala.io.Source
import scala.util.control.ControlThrowable

object day1 extends App {
  def accumulateAndCheck(acc:(Int, Set[Int]), i:(Int, Set[Int])): (Int, Set[Int]) =
  {
    val _1 = acc._1 + i._1;
    if (acc._2 contains _1)
    {
      throw Returned(_1)
    }
    val _2 = acc._2 + _1;
    (_1, _2)
  }
  case class Returned[A](value: A) extends ControlThrowable {}
  def shortcut[A](a: => A) = try { a } catch { case Returned(v) => v }
  val integers: Array[Int] = Source.fromFile("./input.txt").mkString.split("\n").map(_.toInt)
  def multiplyArray(multiply: Int, acc: (Int, Array[Int]), array: Array[Int]): Array[Int] = {
    if (acc._1 == multiply) acc._2
    else multiplyArray(multiply, (acc._1 +1, acc._2 ++ array), array)
  }
  val integersBig = multiplyArray(1000, (0,scala.Array.emptyIntArray), integers)
  println("Part 1 (sum): " + integers.foldLeft(0) { (acc, i) => acc + i })
  println("Part 2 (first double frequency): " + shortcut(integersBig.map((_, Set.empty[Int])).foldLeft((0, Set.empty[Int]))(accumulateAndCheck)))
}
