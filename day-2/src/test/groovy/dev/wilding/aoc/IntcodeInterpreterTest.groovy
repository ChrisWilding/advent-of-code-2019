package dev.wilding.aoc

import spock.lang.Specification

class IntcodeInterpreterTest extends Specification {

  def "1,0,0,0,99"() {
    setup:
    def ii = new IntcodeInterpreter([1, 0, 0, 0, 99] as ArrayList)


    when:
    ii.run()
    def result = ii.getIntcode()

    then:
    result == [2, 0, 0, 0, 99]
  }

  def "2,3,0,3,99"() {
    setup:
    def ii = new IntcodeInterpreter([2, 3, 0, 3, 99] as ArrayList)

    when:
    ii.run()
    def result = ii.getIntcode()

    then:
    result == [2, 3, 0, 6, 99]
  }

  def "2,4,4,5,99,0"() {
    setup:
    def ii = new IntcodeInterpreter([2, 4, 4, 5, 99, 0] as ArrayList)

    when:
    ii.run()
    def result = ii.getIntcode()

    then:
    result == [2, 4, 4, 5, 99, 9801]
  }

  def "1,1,1,4,99,5,6,0,99"() {
    setup:
    def ii = new IntcodeInterpreter([1, 1, 1, 4, 99, 5, 6, 0, 99] as ArrayList)

    when:
    ii.run()
    def result = ii.getIntcode()

    then:
    result == [30, 1, 1, 4, 2, 5, 6, 0, 99]
  }

  def "1,9,10,3,2,3,11,0,99,30,40,50"() {
    setup:
    def ii = new IntcodeInterpreter([1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50] as ArrayList)

    when:
    ii.run()
    def result = ii.getIntcode()

    then:
    result == [3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50]
  }
}
