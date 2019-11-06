package cs320

package object hw01 extends Homework01 {
  // 1. Primitives (20 pts)

  //Write the function volumeOfCuboid, which consumes three non-negative integer numbers a, b,
  //and c denoting lengths of three sides and produces the volume of the cuboid. (Note: 0 ≤ a, b, c ≤ 1, 000)
  def volumeOfCuboid(a: Int, b: Int, c: Int): Int = a * b * c

  //Write the function concat, which consumes two strings x and y, and it returns their concatenation.
  // For example, test(concat("abc", "def"), "abcdef")
  def concat(x: String, y: String): String = x + y

  // 2. Function Values (30 pts)

  //Write the function addN, which consumes an integer number n and produces a function that adds n
  //to a given integer number
  def addN(n: Int): Int => Int = (x: Int) => x + n

  //Write the function twice, which consumes a function f whose type is Int => Int
  //and returns another function that applies the function f twice.
  def twice(f: Int => Int): Int => Int = (x: Int) => f(f(x))

  //Write the function compose, which consumes two Int => Int functions f and g and
  //returns their composition f ◦ g.
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  // 3. Data Structures (50 pts)

  // 3.1. Lists (20 pts)

  //Define the function double, which consumes a list l of integers and returns another
  //list whose elements are doubles of elements of l.
  def double(l: List[Int]): List[Int] = l.map(_ * 2)

  //Define the function sum, which consumes a list l of integers and returns the sum of elements of the list l.
  def sum(l: List[Int]): Int = l.foldRight(0)(_ + _)

  // 3.2. Maps (10 pts)

  //Define the function getKey, which consumes a map m from strings to integers and a string s. If there exists
  //a mapping for the string s in the map m, it returns the corresponding integer number. Otherwise, it throws
  //an error with a message containing the string s via the helper function error.
  def getKey(m: Map[String, Int], s: String): Int = {
    if (m.get(s) != Nil)
      m.get(s).get.intValue()
    else
      throw new Exception(s)  //error(s)  //either works similarly..?`
  }

  // 3.3. User-defined Structures (20 pts)

  //Define the function countLeaves, which consumes a tree t and returns the number of its leaf nodes.
  def countLeaves(t: Tree): Int = t match {
    case Branch(l, v, r) => {countLeaves(l) + countLeaves(r)}
    case Leaf(v) => 1
  }
//  {
//    if((t.left isInstanceOf Branch) && (t.right isInstanceOf Branch))
//      1
//    else if (t.left !isInstanceOf Branch)
//      countLeaves(t.right)
//    else if (t.right !isInstanceOf Branch)
//      countLeaves(t.left)
//    else
//      0
//
//  }

  //Define the function flatten, which consumes a tree t and returns a list containing the values of nodes
  //inside the tree t with in-order tree traversals.
  def flatten(t: Tree): List[Int] = t match {
    case Branch(l, v, r) => {List.concat(List.concat(flatten(l),List(v)), flatten(r))}
    case Leaf(v) => List(v)
  }

  def tests: Unit = {
    test(concat("abc", "def"), "abcdef")
    test(addN(5)(3), 8)
    test(addN(5)(42), 47)
    test(twice(addN(3))(2), 8)
    test(twice(addN(3))(7), 13)
    test(compose(addN(3), addN(4))(5), 12)
    test(compose(addN(3), addN(4))(11), 18)

    val l: List[Int] = List(1, 2, 3)
    test(double(l), List(2, 4, 6))
    test(double(double(l)), List(4, 8, 12))

    test(sum(List(1,2,3)), 6)
    test(sum(List(4,2,3,7,5)), 21)

    val m: Map[String, Int] = Map("Ryu" -> 42, "PL" -> 37)
    test(getKey(m, "Ryu"), 42)
    test(getKey(m, "PL"), 37)
    //testExc(getKey(m, "CS320"), "CS320")  //comment out until want to test

    val tree: Tree = Branch(Leaf(1), 2, Branch(Leaf(3), 4, Leaf(5)))
    test(countLeaves(tree), 3)
    test(flatten(tree), List(1, 2, 3, 4, 5))

    /* Asim's Tests */
    test(concat("bob_", "marley"), "bob_marley")

    test(addN(1)(1), 2)
    test(addN(0)(9), 9)

    test(twice(addN(0))(9), 9)
    test(twice(addN(1))(1), 3)

    test(compose(addN(1), addN(5))(5), 11)
    test(compose(addN(0), addN(0))(1), 1)

    val r: List[Int] = List(0, 0, 1)
    test(double(r), List(0, 0, 2))
    test(double(double(r)), List(0, 0, 4))

    test(sum(List(0,0,0)), 0)
    test(sum(List(1,1,1)), 3)

    val t: Map[String, Int] = Map("mich_stars" -> 3, "food_rate" -> 9)
    test(getKey(t, "mich_stars"), 3)
    test(getKey(t, "food_rate"), 9)
    //testExc(getKey(t, "food_sucked"), "food_sucked")  //comment out until want to test

    val y: Tree = Branch(Leaf(0), 1, Branch(Leaf(0), 2, Branch(Leaf(0), 3, Leaf(0))))
    test(countLeaves(y), 4)
    test(flatten(y), List(0, 1, 0, 2, 0, 3, 0))
  }
}
