package cs320

package object hw07 extends Homework07 {
  def run(str: String): String = ???

  def tests: Unit = {
    test(run("{{fun {x y} {- y x}} 10 12}"), "2")
    test(run("{fun {} 12}"), "function")
    testExc(run("{{fun {x y} 1} 2}"), "wrong arity")
    test(run("{withcc esc {{fun {x y} x} 1 {esc 3}}}"), "3")
    test(run("{{fun {x y} {- y x}} 10 12}"), "2")
    test(run("{fun {} 12}"), "function")
    testExc(run("{{fun {x y} 1} 2}"), "wrong arity")
    test(run("{withcc esc {{fun {x y} x} 1 {esc 3}}}"), "3")

    /* Write your own tests */
  }
}
