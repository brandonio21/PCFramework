#!/bin/bash
WGET_FLAGS="-q --progress=bar --show-progress"
VERSION="1.15"
REMOTE_URL="https://raw.githubusercontent.com/brandonio21/PCFramework/master"
COMPETITION_NAME="WICBPC"

echo "PCFramework for WiC @ UCSD"
echo "Install Script Version: ${VERSION}"
echo "----------------------------------------------------"

echo "Checking for updates..."
`rm -rf update`
`mkdir update`
`wget -q -P update "${REMOTE_URL}/install.sh"`
if [[ `diff install.sh update/install.sh` != "" ]]; then
	printf "%s" "Updating... "
	`mv update/install.sh installnew.sh`
	`rm -rf update`
	`mv installnew.sh install.sh`
	`chmod +x install.sh`
	printf "%s\n" "Please relaunch"
	exit 0
else
	printf "%s\n" "Up to date!"
	`rm -rf update`
fi
	

printf "%s: " "What is the name of the competition? (ex/ WiC-BPC)"
read COMPETITION_NAME
printf "%s: " "What year is the competition? (ex/ Fa14)"
read year
printf "%s: " "How many problems are there this year?"
read numOfProblems

printf "%s\n" "Creating directory structure..."
`mkdir -p "${COMPETITION_NAME}-${year}/Questions"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/dev"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/dev/.writers"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/dev/Generators"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/dev/tests"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/FinalIO"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/FinalSolutions"`
`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/Templates"`


printf "%s\n" "Downloading README files"
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Questions" "${REMOTE_URL}/Questions/README.md"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/README.md"`

printf "%s\n" "Downloading useful scripts"
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/clean.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/compare.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/test.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/verify.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/compile.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev" "${REMOTE_URL}/Solutions/dev/run.sh"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}" "${REMOTE_URL}/createContestFiles.sh"`

printf "%s\n" "Adding information about problem count"
`printf "#!/bin/bash\n%s\n" "NUMBER_OF_PROBLEMS=${numOfProblems}" | cat - "${COMPETITION_NAME}-${year}/Solutions/dev/compare.sh" > temp && mv temp "${COMPETITION_NAME}-${year}/Solutions/dev/compare.sh"`
`printf "#!/bin/bash\n%s\n" "NUMBER_OF_PROBLEMS=${numOfProblems}" | cat - "${COMPETITION_NAME}-${year}/Solutions/dev/test.sh" > temp && mv temp "${COMPETITION_NAME}-${year}/Solutions/dev/test.sh"`
`chmod +x ${COMPETITION_NAME}-${year}/Solutions/dev/*.sh`


printf "%s\n" "Downloading example files..."
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/Templates" "${REMOTE_URL}/Solutions/Templates/Problem1.java"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/tests" "${REMOTE_URL}/Solutions/dev/tests/problem1_corner.in"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/tests" "${REMOTE_URL}/Solutions/dev/tests/problem1_corner.out"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/tests" "${REMOTE_URL}/Solutions/dev/tests/problem1_generated.in"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/tests" "${REMOTE_URL}/Solutions/dev/tests/problem1_sample.in"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/tests" "${REMOTE_URL}/Solutions/dev/tests/problem1_sample.out"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/Generators" "${REMOTE_URL}/Solutions/dev/Generators/Generator.java"`
`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Solutions/dev/Generators" "${REMOTE_URL}/Solutions/dev/Generators/Problem1Generator.java"`


printf "%s\n" "We will now create solution writer directories..."

printf "%s: " "Enter the name of a solution writer (0 to quit)"
read name
while [ "$name" != "0" ]; do
	`mkdir -p "${COMPETITION_NAME}-${year}/Solutions/dev/${name}"`
	`ln -s "${COMPETITION_NAME}-${year}/Solutions/dev/${name}" "${COMPETITION_NAME}-${year}/Solutions/dev/.writers/${name}"`
	printf "%s: " "Enter the name of a solution writer (0 to quit)"
	read name
done

printf "%s: " "Would you like to download example packages? (y/n)"
read answer
if [ "$answer" == "y" ]; then
	`mkdir -p "${COMPETITION_NAME}-${year}/Examples"`
	`wget ${WGET_FLAGS} -P "${COMPETITION_NAME}-${year}/Examples/" "${REMOTE_URL}/Examples/WiC-BPC-Wi15.tar.gz"`
	`tar -xf ${COMPETITION_NAME}-${year}/Examples/WiC-BPC-Wi15.tar.gz -C "${COMPETITION_NAME}-${year}/Examples/"`
	`rm -f ${COMPETITION_NAME}-${year}/Examples/WiC-BPC-Wi15.tar.gz`
fi

printf "%s\n" "Done! Best of luck."

