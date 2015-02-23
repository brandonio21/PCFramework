PCFramework
===========

PCFramework is essentially a quick framework for setting up the backend to 
a programming competition. This backend is specifically designed for people
who are working in a team.  

This Framework was originally created for University of California, San Diego's
Women in Computing club as they held their quarterly Beginner's Programming
Competition.

## Installation Instructions ##
Basically, just download and run the install script.  
Using wget

```
wget "https://raw.githubusercontent.com/brandonio21/PCFramework/master/install.sh"
./install.sh
```

Using curl:
```
curl -O "https://raw.githubusercontent.com/brandonio21/PCFramework/master/install.sh"
./install.sh
```

This installer will download the necessary files and assist you in the creation
of the directory structure.


## Workflow ##
The first part of the workflow is getting the directory structure on everyones'
computers. I usually do this with Dropbox. I run the `install.sh` script inside
of my Dropbox root directory and then make the resulting directory a shared 
directory. If you have something against Dropbox or other such services, you 
could always use git to distribute the directory to the members of your team.

As questions are created for the programming competition, they should be placed
within the `Questions` subdirectory. There should also be three separate test
cases for each question: Sample cases (Ones given as examples with the question
itself), Corner cases (the hard cases to test), and generated cases (The ones
that a generator is written for). The first two are preferrably handwritten and
the latter is, preferrably, generated.  
 
Once the questions are established, the _Sample Cases_ and _Corner Cases_ should
be put in the `dev/tests` directory. The example files in the `dev/tests` 
directory show exactly how to do this. Then, a template file should be created 
in the `Solutions/Templates` folder. This template file's job is to read the 
cases from the case input file and call the competitor's function on the input,
outputting the resulting data to stdout. After the template file is created,
a Generator should be written in the `Solutions/dev/Generators` directory. 
These generators should create a large number of random cases to catch possible
bugs in the competitor's programs. An example is provided for reference.

With the template file being created, _Solution Writers_, who basically act
like the competitors themselves, can copy the template files into their 
directories at `Solutions/dev/Name`. Then, the _Solution Writer_ writes a 
solution to the problem. Once the solution is written, they can use several
scripts to verify their solution. `test.sh` is used for comparing the solution
to expected output. `compare.sh` is used for comparing the solutions of 
several solution writers. `clean.sh` is used for cleaning up residue from 
_test.sh_ runs, and `verify.sh` is used for making sure all _FinalSolutions_
are indeed final.

## Script Usage ##
The included shell scripts, which are very useful, can be called using the 
following syntax. Keep in mind they must be called from the `Solutions/dev` 
directory.

```
./test.sh <problemNumber> <name>
```

```
./compare.sh <name1> <name2> <problemNumber>
```

```
./clean.sh <name>
```

Keep in mind that all `problemNumber` arguments can be replaced with `a` to
test all problems.