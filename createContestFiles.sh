#!/bin/bash
NUM_PROBLEMS=15

# This script will make the contest files folder
CONTEST_FILES_DIR="ContestFiles"
PROBLEM_PREFIX="Problem"
SAMPLE_DIR="SampleIO"
SOLUTIONS_DIR="Solutions"
TEMPLATES_DIR="${SOLUTIONS_DIR}/Templates"
TEST_CASE_DIR="${SOLUTIONS_DIR}/dev/tests"


if [ ! -d ${CONTEST_FILES_DIR} ]; then
	mkdir ${CONTEST_FILES_DIR}
fi


# Now we need to loop through each problem
i=1
while [ $i -le ${NUM_PROBLEMS} ]; do
	fileProblemName=$i
	printf -v fileProblemName "%02d" $i
	if [ ! -d ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName} ]; then
		mkdir ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}
	fi

	if [ ! -d ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}/${SAMPLE_DIR} ]; then
		mkdir ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}/${SAMPLE_DIR} 
	fi

	# Now we must copy the templates
	for f in ${PWD}/${TEMPLATES_DIR}/${PROBLEM_PREFIX}${i}.*; do
		cp $f ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}/
	done

	# Now we copy the sample files
	for f in ${PWD}/${TEST_CASE_DIR}/problem${i}_sample.*; do
		cp $f ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}/${SAMPLE_DIR}/

		# Verify that this contains stuff
		if [ "$(cat ${CONTEST_FILES_DIR}/${PROBLEM_PREFIX}${fileProblemName}/${SAMPLE_DIR}/$(echo $f | sed "s/.*\///"))" == "" ]; then
			echo "WARNING: $(echo $f | sed "s/.*\///") is empty"
		fi

	done
	let "i++"
done

# Now we can zip it
zip -qq -r ContestFiles ${CONTEST_FILES_DIR}/*
