#!/bin/bash

# A simple script used to clean the output of a certain person
if [ -z "$1" ]; then
	printf "%s\n" "Incorrect Syntax!"
	printf "%s\n" "Usage: $0 <name>"
	printf "\t%s\n" "Example: $0 Brandon"
	exit 1
fi
userOutputDir="${1}/output"


# Ask and then clean
printf "%s" "Are you sure you want to clean $1's output files? (y/n) "
read answer
if [[ $answer == "y" ]]; then
	rm -rf ${userOutputDir}
	rm -rf ${1}/*.class
	printf "%s\n" "$1's Output Cleaned"
fi
