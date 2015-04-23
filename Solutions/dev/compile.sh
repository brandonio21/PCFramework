#!/bin/bash
directory=$1
fileNameWithoutExt=$2

for f in ${directory}/*; do
	fileExtension=$(echo $f | sed "s/.*\.//")
	if [ "${fileExtension}" == "java" ]; then
		javac $f
		echo $(echo $f | sed "s/${fileExtension}/class/")

		else if [ "${fileExtension}" == "cpp" ]; then
			g++ -o $(echo $f | sed "s/${fileExtension}/o/") $f
			echo $(echo $f | sed "s/${fileExtension}/o/")
		fi
	fi
done


