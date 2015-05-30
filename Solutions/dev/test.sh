#!/bin/bash
TESTS_DIR="tests"
SAMPLE_EXTENSION="_sample"
CORNER_CASES_EXTENSION="_corner"
GENERATED_EXTENSION="_generated"
INPUT_ENDING=".in"
OUTPUT_ENDING=".out"
COMPILE_COMMAND="./compile.sh"
RUN_COMMAND="./run.sh"
WRITERS_DIR=".writers"

SKIP_SAMPLE_IO=false
SKIP_CORNER_IO=false

# A testing script that puts everything in the right directories
# Specialized for Wi15 - Updated 1/24/2015
# Brandon Milton

# The first thing to do is check to see if the arguments were provided.
# If not, briefly inform the user on how they should be using the program.
if [ -z "$1" ]
then
	printf "%s\n" "There is no file to test!"
	printf "%s\n" "Syntax: ${0} <problemNumebr> <userDirectory>"
	printf "\t%s\n" "Example: ${0} 1 Brandon"
	exit 1
fi
if [ -z "$2" ]
then
	printf "%s\n" "There is no user provided!"
	printf "%s\n" "Syntax: ${0} <problemNumber> <userDirectory>"
	printf "\t%s\n" "Example: ${0} 1 Brandon"
	exit 1
fi

if [ ! -z "$3" ]; then
	if [[ "$3" = "-skipsample" ]]; then
		SKIP_SAMPLE_IO=true
	fi
	if [[ "$3" = "-skipcorner" ]]; then
		SKIP_CORNER_IO=true
	fi
fi

if [ ! -z "$4" ]; then
	if [[ "$4" = "-skipsample" ]]; then
		SKIP_SAMPLE_IO=true
	fi
	if [[ "$4" = "-skipcorner" ]]; then
		SKIP_CORNER_IO=true
	fi
fi

# Declare variables regarding where the files are
sourceFile="Problem${1}"
classFile="Problem${1}"
sampleInput="${TESTS_DIR}/problem${1}${SAMPLE_EXTENSION}${INPUT_ENDING}"
sampleOutput="${TESTS_DIR}/problem${1}${SAMPLE_EXTENSION}${OUTPUT_ENDING}"
generatedInput="${TESTS_DIR}/problem${1}${GENERATED_EXTENSION}${INPUT_ENDING}"
cornerInput="${TESTS_DIR}/problem${1}${CORNER_CASES_EXTENSION}${INPUT_ENDING}"
cornerOutput="${TESTS_DIR}/problem${1}${CORNER_CASES_EXTENSION}${OUTPUT_ENDING}"
userOutput="${2}/output/problem${1}${OUTPUT_ENDING}"

# If the user used the "userall" option, recursively call the program
if [[ "$2" = "a" ]]; then
	for file in ${PWD}/$WRITERS_DIR/*; do
		$0 $1 $(echo $file | sed "s/.*\///") $3 $4
	done
	exit 0
fi


# If the user used the "all" option, recursively call the program
if [[ "$1" = "a" ]]; then
	index=1
	while [ $index -le ${NUMBER_OF_PROBLEMS} ]; do
		$0 $index $2 $3 $4
		let "index++"
	done
	exit 0
fi

userDirectory=$2
if [[ "$2" = "t" ]]; then
	userDirectory="../Templates"
fi


# Check to see if the user has the source code for the specified problem.
# Using janky method
for f in ${userDirectory}/${sourceFile}.*; do
	if [ ! -f "$f" ]; then 
		echo "${userDirectory} does not have problem ${1}"
		exit 1
	fi
	break
done

# Test the user's solution against the sample IO and put the output
# in their directory
# printf "%s\n" "Testing problem against sample IO"

# Let's check what language the code is in first
if [ $SKIP_SAMPLE_IO = false ];
then
	$COMPILE_COMMAND ${userDirectory} ${sourceFile}
	cat "${sampleInput}" | $RUN_COMMAND ${userDirectory} ${sourceFile} > ${userDirectory}/myOutput
	cat "${sampleOutput}" > ${userDirectory}/sampleOutput
	sampleDiff=`diff ${userDirectory}/myOutput ${userDirectory}/sampleOutput`
	if [[ ${sampleDiff} != "" ]]
	then
		tput setaf 1; printf "%s\n" "$userDirectory: PROBLEM $1 FAILED TO PASS SAMPLE IO! Would you like to see the vimdiff of output? (y/n)"
		tput sgr0
		read answer
		if [[ ${answer} == "y" ]]; then
			vimdiff ${userDirectory}/myOutput ${userDirectory}/sampleOutput
		fi
		rm ${userDirectory}/myOutput ${userDirectory}/sampleOutput
		exit 1
	else
		tput setaf 2; printf "%s\n" "$userDirectory: PROBLEM $1 PASSED SAMPLE IO"
		tput sgr0
		rm ${userDirectory}/myOutput ${userDirectory}/sampleOutput
	fi
fi

# Test the user's solution against the verified corner cases and put the output
# in their directory
# printf "%s\n" "Testing problem against corner cases"
if [ $SKIP_CORNER_IO = false ];
then
	$COMPILE_COMMAND ${userDirectory} ${sourceFile}
	cat "${cornerInput}" | $RUN_COMMAND ${userDirectory} ${sourceFile} > ${userDirectory}/myOutput
	cat "${cornerOutput}" > ${userDirectory}/cornerOutput
	cornerDiff=`diff ${userDirectory}/myOutput ${userDirectory}/cornerOutput`
	if [[ ${cornerDiff} != "" ]]
	then
		tput setaf 1; printf "%s\n" "$userDirectory: PROBLEM $1 FAILED TO PASS CORNER-CASE IO! Would you like to see the vimdiff of output (y/n)"
		tput sgr0
		read answer
		if [[ ${answer} == "y" ]]; then
			vimdiff ${userDirectory}/myOutput ${userDirectory}/cornerOutput
		fi
		rm ${userDirectory}/myOutput ${userDirectory}/cornerOutput
		exit 1
	else
		tput setaf 2; printf "%s\n" "$userDirectory: PROBLEM $1 PASSED CORNER-CASE IO"
		tput sgr0
		rm ${userDirectory}/myOutput ${userDirectory}/cornerOutput
	fi
fi

# Finally, test the user's solution against generated output and put the output in 
# their directory
# printf "%s\n" "Constructing output file using generated test cases"
if [ ! -d "${userDirectory}/output" ]; then
	mkdir "${userDirectory}/output"
fi

if [ ! -e "${generatedInput}" ]; then
	printf "Test file not there .. Creating test file using sampleIO and corner case IO\n"
	cp "${sampleInput}" "${generatedInput}"
	cat "${cornerInput}" >> "${generatedInput}"
fi
(cat "${generatedInput}" | $RUN_COMMAND ${userDirectory} ${sourceFile}) > "${userOutput}"
# printf "%s\n" "Done."

