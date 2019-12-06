package dev.wilding.aoc

import spock.lang.Specification

class FuelCounterUpperTest extends Specification {

  def "for a mass of 1969, the fuel required is 654"() {
    setup:
    def fcu = new FuelCounterUpper()

    when:
    def result = fcu.calculate(1969)

    then:
    result == 654
  }

  def "for a mass of 100756, the fuel required is 33583"() {
    setup:
    def fcu = new FuelCounterUpper()

    when:
    def result = fcu.calculate(100756)

    then:
    result == 33583
  }

  def "the fuel required by a module of mass 100756 and its fuel is 50346"() {
    setup:
    def fcu = new FuelCounterUpper()

    when:
    def result = fcu.calculateFuelForFuel(100756)

    then:
    result == 50346
  }

}
