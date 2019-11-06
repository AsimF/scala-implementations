package cs320

package object hw03 extends Homework03 {
  def run(str: String): String = ???

  def tests: Unit = {
    test(run("{{fun {x y} {+ x y}} 1 2}"), "3")
    test(run("{{fun {} {+ 3 4}}}"), "7")
    testExc(run("{{fun {x y} {+ x y}} 1}"), "wrong arity")
    test(run("{access {record {x 1} {y 2}} x}"), "1")
    testExc(run("{access {record {x 1} {y 2}} z}"), "no such field")
    testExc(run("{record {x {access {record {y 1}} z}}}"), "no such field")
    test(run("42"), "42")
    test(run("{fun {x} x}"), "function")
    test(run("{record {x 1}}"), "record")

    /* Write your own tests */
  }
}
