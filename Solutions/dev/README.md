Solutions Directory
===================

The purpose of the Solutions directory is to provide a place where all of the
solution writers can independently work on their solutions, while sharing
common resources such as the Problem template files.

### Getting Started ###
In order to get started, create your own subfolder and work on your problem
solutions there. Solutions should follow the naming paradigm of `ProblemX.java`
where X is the problem number that you are working on.


### Directory Map ###
|
README.md
|   (A simple readme file)
|
test.sh
|   (A simple testing script whose details are given later in this document)
|
compare.sh
|   (A script used to compare the solutions of various coders)
|
verify.sh
|   (A script used to verify that all of a user's solutions match the FinalIO)
|
clean.sh
|   (A script used to clean out a user's output directory. useful for lots
|    of testing and comparing)
|
---../Templates
|   (Contains all template files with structured main methods)
|
---../FinalIO
|   (Contains all of the official input/output files to be used during the 
|    competition.)
|
---../FinalSolutions
|   (Contains all of the official solutions that will be published after 
|    competition to people who request it)
|
---tests
|   (Contains all input files that will be used during the competition)
|
---Name
|   (Where name is the name of a person, contains all solutions that person 
|    wrote)
|


### Combining ###
When all solutions are completed, a script will be run that compares the results
of all solutions and points out any discrepencies. This will only work if 
solution files follow the `ProblemX.java` naming paradigm, so please be sure
to follow that paradigm.

### Testing ###
Individual testing needs to be done by testing against the sample output and
then creating an output file using all test cases found in the `Tests` directory
so that the outputs of all solution writers can be compared. All of this can be
automated by using the `test.sh` script. The syntax is as follows:
```
./test.sh 1 Brandon
```
Would be the code to run the tests for Problem 1 written by Brandon.

In order to test all scripts at once, use the `a` option, as in
```
./test.sh a Brandon
```

### Comparing ###
Once individual testing is complete, you should want to comapre your output with
the output of other solution writers. In order to do this, run the `compare.sh`
script. If you recently made changes to your solution, you should first run the
`clean.sh` script. The details are given below:

To clear your directory and prepare it for comparing:
```
./clean.sh Brandon
```

To clear the directory of the person you're comparing against;
```
./clean.sh Dylan
```

To compare solution outputs for a specific problem:
```
./compare.sh Brandon Dylan 5
```

To compare solution outputs for all problems:
```
./compare.sh Brandon Dylan a
```

Feel free to contribute to any part of the **Programming Competition** project.
