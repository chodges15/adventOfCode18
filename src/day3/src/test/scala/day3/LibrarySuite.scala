/*
 * This Scala Testsuite was generated by the Gradle 'init' task.
 */
package day3

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LibrarySuite extends FunSuite {
  test("someLibraryMethod is always true") {
    def claimsOverlap = new Library("./inputTest.txt")

    assert(claimsOverlap != Nil)
  }
}