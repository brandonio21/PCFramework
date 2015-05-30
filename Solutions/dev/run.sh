#!/bin/bash
directory=$1
fileNameWithoutExt=$2
for f in ${directory}/${fileNameWithoutExt}.*; do
	fileExtension=$(echo $f | sed "s/.*\.//")
	fileName=$(echo $f | sed "s/.*\///")
	fileNameWithoutExt=$(echo $fileName | sed "s/\..*//")

	if [ "${fileExtension}" == "class" ]; then
		java -cp $directory $fileNameWithoutExt
		exit 0

		else if [ "${fileExtension}" == "o" ]; then
			$f
			exit 0
		fi

	fi
done

