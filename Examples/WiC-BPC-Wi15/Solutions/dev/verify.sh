#!/bin/bash

if [[ "$1" = "a" ]]; then
	index=1
	while [ $index -lt 14 ]; do
		$0 $index $2
		let "index++"
	done
	exit 0
fi

"${PWD}/test.sh" ${1} ${2}
verifyDiff=`diff ${2}/output/problem${1}.out FinalIO/problem${1}.out`
if [[ ${verifyDiff} != "" ]]
then
	printf "%s\n" "Different. Press 'y' to view vimdiff"
	read answer
	if [[ ${answer} == "y" ]]; then
		vimdiff ${2}/output/problem${1}.out FinalIO/problem${1}.out 
	fi
	exit 1
else
	printf "%s\n" ">>>>Good to go."
	exit 0
fi
