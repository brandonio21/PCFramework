TESTS_DIR="tests"
SAMPLE_EXTENSION="_sample"
CORNER_CASES_EXTENSION="_corner"
GENERATED_EXTENSION="_generated"
INPUT_ENDING=".in"
OUTPUT_ENDING=".out"

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

# Declare variables regarding where the files are
sourceFile="Problem${1}.java"
classFile="Problem${1}"
sampleInput="${TESTS_DIR}/problem${1}${SAMPLE_EXTENSION}${INPUT_ENDING}"
sampleOutput="${TESTS_DIR}/problem${1}${SAMPLE_EXTENSION}${OUTPUT_ENDING}"
generatedInput="${TESTS_DIR}/problem${1}${GENERATED_EXTENSION}${INPUT_ENDING}"
cornerInput="${TESTS_DIR}/problem${1}${CORNER_CASES_EXTENSION}${INPUT_ENDING}"
cornerOutput="${TESTS_DIR}/problem${1}${CORNER_CASES_EXTENSION}${OUTPUT_ENDING}"
userOutput="${2}/output/problem${1}${OUTPUT_ENDING}"

# If the user used the "all" option, recursively call the program
if [[ "$1" = "a" ]]; then
	index=1
	while [ $index -lt ${NUMBER_OF_PROBLEMS} ]; do
		$0 $index $2
		let "index++"
	done
	exit 1
fi

# Check to see if the user has the source code for the specified problem.
if [ ! -e "${2}/${sourceFile}" ]; then
	printf "%s\n" "${2} does not have problem ${1}"
	exit 1
else
	printf "%s\n" "Testing ${2}'s problem ${1}"
fi

# Test the user's solution against the sample IO and put the output
# in their directory
printf "%s\n" "Testing problem against sample IO"
javac "${2}/${sourceFile}"
cat "${sampleInput}" | java -cp ${2} ${classFile} > ${2}/myOutput
cat "${sampleOutput}" > ${2}/sampleOutput
sampleDiff=`diff ${2}/myOutput ${2}/sampleOutput`
if [[ ${sampleDiff} != "" ]]
then
	tput setaf 1; printf "%s\n" "FAILED TO PASS SAMPLE IO! Would you like to see the vimdiff of output? (y/n)"
	tput sgr0
	read answer
	if [[ ${answer} == "y" ]]; then
		vimdiff ${2}/myOutput ${2}/sampleOutput
	fi
	rm ${2}/myOutput ${2}/sampleOutput
	rm "${2}/${classFile}.class"
	exit 1
else
	tput setaf 2; printf "%s\n" "PASSED SAMPLE IO"
	tput sgr0
	rm ${2}/myOutput ${2}/sampleOutput
fi

# Test the user's solution against the verified corner cases and put the output
# in their directory
printf "%s\n" "Testing problem against corner cases"
javac "${2}/${sourceFile}"
cat "${cornerInput}" | java -cp ${2} ${classFile} > ${2}/myOutput
cat "${cornerOutput}" > ${2}/cornerOutput
cornerDiff=`diff ${2}/myOutput ${2}/cornerOutput`
if [[ ${cornerDiff} != "" ]]
then
	tput setaf 1; printf "%s\n" "FAILED TO PASS CORNER-CASE IO! Would you like to see the vimdiff of output (y/n)"
	tput sgr0
	read answer
	if [[ ${answer} == "y" ]]; then
		vimdiff ${2}/myOutput ${2}/cornerOutput
	fi
	rm ${2}/myOutput ${2}/cornerOutput
	rm "${2}/${classFile}.class"
	exit 1
else
	tput setaf 2; printf "%s\n" "PASSED CORNER-CASE IO"
	tput sgr0
	rm ${2}/myOutput ${2}/cornerOutput
fi

# Finally, test the user's solution against generated output and put the output in 
# their directory
printf "%s\n" "Constructing output file using generated test cases"
if [ ! -d "${2}/output" ]; then
	mkdir "${2}/output"
fi

if [ ! -e "${generatedInput}" ]; then
	printf "Test file not there .. Creating test file using sampleIO and corner case IO\n"
	cp "${sampleInput}" "${generatedInput}"
	cat "${cornerInput}" >> "${generatedInput}"
fi
(cat "${generatedInput}" | java -cp ${2} ${classFile}) > "${userOutput}"
rm "${2}/${classFile}.class"
printf "%s\n" "Done."

