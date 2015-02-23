#!/bin/bash
WGET_FLAGS="-q --progress=bar --show-progress"
VERSION="1.05"

echo "University of California, San Diego"
echo "Women In Computing"
echo "Beginner's Programming Competition"
echo "Install Script Version: ${VERSION}"
echo "----------------------------------------------------"

echo "Checking for updates..."
`rm -rf update`
`mkdir update`
`wget -q -P update "https://dl.dropboxusercontent.com/u/398377/WICBPC/install.sh"`
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
	

printf "%s: " "What year is the competition? (ex/ Fa14)"
read year
printf "%s: " "How many problems are there this year?"
read numOfProblems

printf "%s\n" "Creating directory structure..."
`mkdir -p "WICBPC${year}/Questions"`
`mkdir -p "WICBPC${year}/Solutions/dev"`
`mkdir -p "WICBPC${year}/Solutions/dev/Generators"`
`mkdir -p "WICBPC${year}/Solutions/dev/tests"`
`mkdir -p "WICBPC${year}/Solutions/FinalIO"`
`mkdir -p "WICBPC${year}/Solutions/FinalSolutions"`
`mkdir -p "WICBPC${year}/Solutions/Templates"`


printf "%s\n" "Downloading README files"
`wget ${WGET_FLAGS} -P "WICBPC${year}/Questions" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Questions/README.md"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/README.md"`

printf "%s\n" "Downloading useful scripts"
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/clean.sh"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/compare.sh"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/test.sh"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/verify.sh"`
printf "%s\n" "Adding information about problem count"
`printf "#!/bin/bash\n%s\n" "NUMBER_OF_PROBLEMS=${numOfProblems}" | cat - "WICBPC${year}/Solutions/dev/compare.sh" > temp && mv temp "WICBPC${year}/Solutions/dev/compare.sh"`
`printf "#!/bin/bash\n%s\n" "NUMBER_OF_PROBLEMS=${numOfProblems}" | cat - "WICBPC${year}/Solutions/dev/test.sh" > temp && mv temp "WICBPC${year}/Solutions/dev/test.sh"`
`chmod +x WICBPC${year}/Solutions/dev/*.sh`


printf "%s\n" "Downloading example files..."
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/Templates" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/Templates/Problem1.java"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/tests" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/tests/problem1_corner.in"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/tests" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/tests/problem1_corner.out"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/tests" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/tests/problem1_generated.in"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/tests" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/tests/problem1_sample.in"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/tests" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/tests/problem1_sample.out"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/Generators" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/Generators/Generator.java"`
`wget ${WGET_FLAGS} -P "WICBPC${year}/Solutions/dev/Generators" "https://dl.dropboxusercontent.com/u/398377/WICBPC/Solutions/dev/Generators/Problem1Generator.java"`


printf "%s\n" "We will now create solution writer directories..."

printf "%s: " "Enter the name of a solution writer (0 to quit)"
read name
while [ "$name" != "0" ]; do
	`mkdir -p "WICBPC${year}/Solutions/dev/${name}"`
	printf "%s: " "Enter the name of a solution writer (0 to quit)"
	read name
done

printf "%s\n" "Done! Best of luck."

