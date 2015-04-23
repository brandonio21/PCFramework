#!/bin/bash
directory=$1
fileNameWithoutExt=$2
for f in ${directory}/*; do
	fileExtension=$(echo $f | sed "s/.*\.//")
	directory=$(echo $f | sed "s/\/.*//")
	fileName=$(echo $f | sed "s/.*\///")
	fileNameWithoutExt=$(echo $fileName | sed "s/\..*//")

	if [ "${fileExtension}" == "class" ]; then
		java -cp $directory $fileNameWithoutExt

		else if [ "${fileExtension}" == "o" ]; then
			$f
		fi

	fi
done

