package cs320

package object hw06 extends Homework06 {
  def run(str: String): String = ???



  def tests: Unit = {
    test(run("""{{fun {b} {seqn {setbox b {+ 2 {openbox b}}}
                          {setbox b {+ 3 {openbox b}}}
                          {setbox b {+ 4 {openbox b}}}
                          {openbox b}}}
                {newbox 1}}"""), "10")
    testExc(run("{get {rec {x 1}} y}"), "no such field")
    test(run("{{fun {r} {seqn {set r x 5} {get r x}}} {rec {x 1}}}"), "5")
    test(run("42"), "42")
    test(run("{fun {x} x}"), "function")
    test(run("{newbox 1}"), "box")
    test(run("{rec}"), "record")

    /* Write your own tests */
//    test(run("""{{fun {b} {seqn {setbox b {+ 2 {openbox b}}}
//                          {setbox b {+ 3 {openbox b}}}
//                          {setbox b {+ 4 {openbox b}}}
//                          {openbox b}}}
//                {newbox 1}}"""), "10")
//    testExc(run("{get {rec {x 1}} y}"), "no such field")
//    test(run("{{fun {r} {seqn {set r x 5} {get r x}}} {rec {x 1}}}"), "5")
//    test(run("42"), "42")
//    test(run("{fun {x} x}"), "function")
//    test(run("{newbox 1}"), "box")
//    test(run("{rec}"), "record")
  }
}
