PCFramework
===========

PCFramework is essentially a quick framework for setting up the backend to 
a programming competition. This backend is specifically designed for people
who are working in a team.  

This Framework was originally created for University of California, San Diego's
Women in Computing club as they held their quarterly Beginner's Programming
Competition.

## Installation Instructions ##

### Git Installation ###
If you would like to use git to install and manage your programming competition
resources (this means you can easily update your scripts!), you can install
PCFramework by cloning this repo.
```
git clone https://github.com/brandonio21/PCFramework.git
```
If you are using this method, then `install.sh` is completely useless to you.
Feel free to remove it as to not cause confusion.

### Non-Git Installation (Recommended)
Basically, just download and run the install script.  
Using wget

```
wget "https://raw.githubusercontent.com/brandonio21/PCFramework/master/install.sh"
chmod +x install.sh
./install.sh
```

Using curl:
```
curl -O "https://raw.githubusercontent.com/brandonio21/PCFramework/master/install.sh"
chmod +x install.sh
./install.sh
```

This installer will download the necessary files and assist you in the creation
of the directory structure. This is also an auto-updating installer, so no
need to worry about not having the latest version. Use the same script for all
of your programming competitions!

In the future, this installer will be useful because you will be able to
specify a language for your competition, where scripts will then be provided
that are suited for your specific language.


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
outputting the resulting data to stdout. If the template file example is 
followed, the template files allow for comments within the cases as well using
the `//` character combination. After the template file is created,
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

When you're finishing up you're solutions, we can use the `compare.sh` script
to put all the IO files in the FinalIO directory for easy access. This can
be done by using the `compare.sh` script in conjunction with the `a` parameter
and by providing all solutions writers as the following arguments.

## Script Usage ##
The included shell scripts, which are very useful, can be called using the 
following syntax. Keep in mind they must be called from the `Solutions/dev` 
directory.

```
./test.sh <problemNumber> <name>
```

```
./compare.sh <problemNumber> <name1> <name2> <name3> ...
```

```
./clean.sh <name>
```

Keep in mind that all `problemNumber` arguments can be replaced with `a` to
test all problems.


## Adding your own languages ##
By default, PCFramework supports contestants using Java or C++ to write their
solutions. As the project involves, I'm sure there will be more languages
included in the default package. If you would like to add your own language,
simply add them to the `run.sh` and `compile.sh` files in the following format.

#### compile.sh ####
Add a new `else if` block containing your file extension. Say, for instance,
you wanted to allow your contestants to write code in C. You would add:
``` bash
else if [ "${fileExtension}" == "c" ]; then
    gcc -o $(echo $f | sed "s/${fileExtension}/o/") $f
    echo $(echo $f | sed "s/$PfileExtension}/o/")
fi
```
Note that the lines do the following:  
1) The `else if` statement checks the file's file extension and compares it.  
2) The `gcc` statement compiles the file into the .o file, which is specified
   by the `sed` command, which replaces the _.c_ extension with _.o_.  
3) The `echo` statement is optional.


#### run.sh ####
3) The `echo` statement is optional.


#### run.sh ####
3) The `echo` statement is optional.


#### run.sh ####
Add a new `else if` block containing your file extension. Say, for instance,
you wanted to allow your contestants to write code in python. (Note that since
C and C++ files compile in the same way, C run support already exists).
``` bash
else if [ "${fileExtension}" == "py" ]; then
    python "$directory/$fileName"
    exit 0
fi
```
Note that the lines do the following:  
1) The `else if` statement checks the file's file extension and compares it.
2) The `python` statement runs the file with the full path specified  
3) The `exit` line prevents any other languages being executed.


