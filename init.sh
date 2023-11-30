#!/bin/bash
DAYTEMPLATE="template/DayXX.kt.template"
TESTTEMPLATE="template/DayXXTest.kt.template"

RESFOLDER="src/main/resources"
SRCFOLDER="src/main/kotlin/net/codetreats/aoc"
TESTFOLDER="src/test/kotlin/net/codetreats/aoc"

for DAY in {01..25}; do
  SRCDIR="$SRCFOLDER/day$DAY"
  TESTDIR="$TESTFOLDER/day$DAY"
  RESDIR="$RESFOLDER/day$DAY"

  mkdir -p $SRCDIR $TESTDIR $RESDIR
  if ! [ -f "$SRCDIR/Day$DAY.kt" ] ; then
    cat $DAYTEMPLATE | sed -e "s/XX/$DAY/g" | sed -e "s/(0/(/g" > "$SRCDIR/Day$DAY.kt"
  fi
  if ! [ -f "$TESTDIR/Day""$DAY""Test.kt" ] ; then
    cat $TESTTEMPLATE | sed -e "s/XX/$DAY/g" > "$TESTDIR/Day""$DAY""Test.kt"
  fi
  if ! [ -f "$RESDIR/input.txt" ] ; then
    touch "$RESDIR/input.txt"
  fi
  if ! [ -f "$RESDIR/dummy.txt" ] ; then
    touch "$RESDIR/dummy.txt"
  fi
done