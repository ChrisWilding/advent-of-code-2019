package dev.wilding.aoc

import spock.lang.Specification

class AppTest extends Specification {
  def "3rd digit of 654321 is 4"() {
    when:
    def result = App.nthDigit(654321, 2)

    then:
    result == 4
  }

  def "200000 does not match"() {
    when:
    def result = App.matchesWithAtLeastAPair(200000)

    then:
    !result
  }

  def "222222 does match"() {
    when:
    def result = App.matchesWithAtLeastAPair(222222)

    then:
    result
  }

  def "123444 does not match with only a pair"() {
    when:
    def result = App.matchesWithOnlyAPair(123444)

    then:
    !result
  }

  def "111122 does match with only a pair"() {
    when:
    def result = App.matchesWithOnlyAPair(111122)

    then:
    result
  }
}
