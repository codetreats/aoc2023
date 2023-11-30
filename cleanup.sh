#!/bin/bash
cd $(dirname $0)

RESFOLDER="src/main/resources"
SRCFOLDER="src/main/kotlin/net/codetreats/aoc"
TESTFOLDER="src/test/kotlin/net/codetreats/aoc"

rm -rf $RESFOLDER/*
rm -rf $TESTFOLDER/*

for DAY in {01..25}; do
    rm -rf $SRCFOLDER/day$DAY
done