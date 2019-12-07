package dev.wilding.aoc

import spock.lang.Specification

class CrossedWiresTest extends Specification {
  def "scenario one"() {
    setup:
    def instructionA = List.of("R8", "U5", "L5", "D3")
    def wireA = new Wire(instructionA)
    def instructionB = List.of("U7", "R6", "D4", "L4")
    def wireB = new Wire(instructionB)
    def crossedWires = new CrossedWires(wireA, wireB)

    when:
    def result = crossedWires.getManhattanDistanceOfClosestIntersection()

    then:
    result == 6
  }

  def "scenario two"() {
    setup:
    def instructionA = List.of("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72")
    def wireA = new Wire(instructionA)
    def instructionB = List.of("U62","R66","U55","R34","D71","R55","D58","R83")
    def wireB = new Wire(instructionB)
    def crossedWires = new CrossedWires(wireA, wireB)

    when:
    def result = crossedWires.getManhattanDistanceOfClosestIntersection()

    then:
    result == 159
  }

  def "scenario three"() {
    setup:
    def instructionA = List.of("R98","U47","R26","D63","R33","U87","L62","D20","R33","U53","R51")
    def wireA = new Wire(instructionA)
    def instructionB = List.of("U98","R91","D20","R16","D67","R40","U7","R15","U6","R7")
    def wireB = new Wire(instructionB)
    def crossedWires = new CrossedWires(wireA, wireB)

    when:
    def result = crossedWires.getManhattanDistanceOfClosestIntersection()

    then:
    result == 135
  }
}
