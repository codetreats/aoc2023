# aoc-template-python

This is a skeleton for [Advent Of Code](https://adventofcode.com/)

## Language

Kotlin

## Usage

### Start

```
./gradlew run
```

or start within IDE


### Implementation

A skeleton for each day is part of this repo.
You have to implement the following functions:

- convert: Receives a string array as input, which contains the lines of the input file.
The return can be arbitrary and must be set as the generic type of the class.
The result is stored as `input`
- run1: Should contain the code for part 1 of the day. Must return the result of this part as string.
- run2: see run1

With `useDummy` you can control whether you use the dummy data or the given input data (see below).

## Input

The input data must be placed inside the `src/main/resource` folder.
There is a file for example data (`dummy.txt`) and the given input data (`input.txt`)

## Tests

Run all tests:

```
./gradlew test
```

or inside the IDE

## Util/Common

Util and common contain useful functions or classes, which are needed often for AOC, e.g. a 2 dimensional board or and Dijkstra algorithm.
