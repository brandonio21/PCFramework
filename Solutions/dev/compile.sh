#!/bin/bash
directory=$1
fileNameWithoutExt=$2

for f in ${directory}/${fileNameWithoutExt}.*; do
	fileExtension=$(echo $f | sed "s/.*\.//")
	if [ "${fileExtension}" == "java" ]; then
		javac $f

		else if [ "${fileExtension}" == "cpp" ]; then
			g++ -std=c++11 -o $(echo $f | sed "s/${fileExtension}/o/") $f
		fi
	fi
done


