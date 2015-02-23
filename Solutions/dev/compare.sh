OUTPUT_DIR="/output"

# Script used to compare the outputs of two people given their names and the 
# problem number.
# Specialized for Wi15 - Updated 1/24/2015
# Brandon Milton

#SYNTAX: <writerOne> <writerTwo> <problemNumber>

if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]
then
	printf "%s\n" "Incorrect syntax!"
	printf "%s\n" "Syntax: ${0} <nameOne> <nameTwo> <problemNumber>"
	printf "\t%s\n" "Example: ${0} Brandon Dylan 5"
	exit 1
fi

if [[ ${3} == "a" ]]; then
	problem=1
	while [ ${problem} -lt ${NUMBER_OF_PROBLEMS} ]; do
		${0} ${1} ${2} $problem
		let "problem++"
	done
	exit 0
fi

# Now that we have valid information, lets make sure the output exists
# Status Message:
printf "%s\n" "Testing Problem ${3}..."

if [ ! -e "${1}${OUTPUT_DIR}/problem${3}.out" ]; then
	# the first user doesnt have output. delegate to test script.
	printf "%s\n" "${1} Doesn't have output.. Generating... "
	./test.sh ${3} ${1}
fi

if [ ! -e "${2}${OUTPUT_DIR}/problem${3}.out" ]; then
	# the first user doesnt have output. delegate to test script.
	printf "%s\n" "${2} Doesn't have output.. Generating... "
	./test.sh ${3} ${2}
fi

if [ ! -e "${1}${OUTPUT_DIR}/problem${3}.out" ]; then
	# The first user didnt do this problem
	tput setaf 1; printf "%s\n" "${1} DIDN'T COMPLETE PROBLEM ${3}"
	tput sgr0
	exit 1
fi
if [ ! -e "${2}${OUTPUT_DIR}/problem${3}.out" ]; then
	tput setaf 1; printf "%s\n" "${2} DIDN'T COMPLETE PROBLEM ${3}"
	tput sgr0
	exit 1
fi
	

# Output definitely exists. Let's diff and if results, let's vimdiff.
diffData=`diff ${1}${OUTPUT_DIR}/problem${3}.out ${2}/output/problem${3}.out`
if [[ ${diffData} != "" ]]
then
	tput setaf 1; printf "%s\n" "Two output files DID NOT MATCH. Would you like to see vimdiff? (y/n)"
	tput sgr0
	read answer
	if [[ ${answer} == "y" ]]; then
		vimdiff ${1}${OUTPUT_DIR}/problem${3}.out ${2}${OUTPUT_DIR}/problem${3}.out
	fi
	exit 1
else
	tput setaf 2; printf "%s\n" "Solutions Match."
	tput sgr0
	exit 0
fi

