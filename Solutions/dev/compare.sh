OUTPUT_DIR="/output"

# Script used to compare the outputs of two people given their names and the 
# problem number.
# Specialized for Wi15 - Updated 2/22/2015
# Brandon Milton

#SYNTAX: <problemNumber> <writerOne> <writerTwo> ...
if [ -z "$1" ] || [ -z "$2" ] || [ -z "$3" ]; then
	printf "%s\n" "Incorrect syntax!"
	printf "%s\n" "Syntax: ${0} <problemNumber> <nameOne> <nameTwo>"
	printf "\t%s\n" "Example: ${0} 5 Brandon Dylan"
	exit 1
fi

problem=${1}
shift
while [ ! -z "$2" ]; do
	if [[ ${problem} == "a" ]]; then
		problem=1
		while [ ${problem} -lt ${NUMBER_OF_PROBLEMS} ]; do
			${0} ${problem} ${1} ${2}
			let "problem++"
		done
	fi
	printf "%s\n" "Testing Problem ${problem}..."
	if [ ! -e "${1}${OUTPUT_DIR}/problem${problem}.out" ]; then
		# The first user doesn't have output. Delegate to test script.
		printf "%s\n" "${1} doesn't have output. Generating..."
		./test.sh ${problem} ${1}
	fi

	if [ ! -e "${2}${OUTPUT_DIR}/problem${problem}.out" ]; then
		# The second user doesn't have output. Delegate.
		printf "%s\n" "${2} doesn't have output. Generating..."
		./test.sh ${problem} ${2}
	fi

	if [ ! -e "${1}${OUTPUT_DIR}/problem${problem}.out" ]; then
		# The first user didnt do the problem or something went wrong
		tput setaf 1; printf "%s\n" "${1} DIDN'T COMPLETE PROBLEM ${problem}"
		tput sgr0
		exit 1
	fi

	if [ ! -e "${2}${OUTPUT_DIR}/problem${problem}.out" ]; then
		# the second user didn't do the problem or something went wrong
		tput setaf 1; printf "%s\n" "${2} DIDN'T COMPLETE PROBLEM ${problem}"
		tput sgr0
		exit 1
	fi

	# if code reaches this point, output exists. diff and if
	diffData=`diff ${1}${OUTPUT_DIR}/problem${problem}.out ${2}${OUTPUT_DIR}/problem${problem}.out`
	if [[ ${diffData} != "" ]] 
	then
		tput setaf 1; printf "%s\n" "Two output files DID NOT MATCH. Would you like to see vimdiff? (y/n)"
		tput sgr0
		read answer
		if [[ ${answer} == "y" ]]; then
			vimdiff ${1}${OUTPUT_DIR}/problem${problem}.out ${2}${OUTPUT_DIR}/problem${problem}.out
		fi
		exit 1
	else
		tput setaf 2; printf "%s\n" "Solutions Match. (${1} and ${2})"
		tput sgr0
	fi



shift
done
		tput setaf 2; printf "%s\n" "Problem ${problem}: All Solutions Match."
		tput sgr0
exit 0
