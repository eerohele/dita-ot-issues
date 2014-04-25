dita-ot-issues
==============

A set of fixtures for testing DITA-OT issues.

### Usage

The Ant buildfile in this repository should be able to build every DITA file in this repository regardless of the DITA version you're using. You don't need to set the `CLASSPATH`, either — in fact, it's probably better if it's empty. If it doesn't work, though, please let me know.

By default, to locate your DITA-OT installation, the buildfile uses your `DITA_HOME` environment variable. You can tell it to use another DITA-OT version by doing:

    ant -Ddita.home=/path/to/dita-ot ...

The buildfile looks for a DITA map called `root.ditamap` by default. In those cases, you can just do something like:

    cd fixtures/1173
    ant -find
    
The `-find` option tells Ant to look for the buildfile up the directory tree.
    
Otherwise you'll have to pass the DITA map file as an argument:

    # Use %CD% instead of $PWD on Windows
    cd fixtures/1605
    ant -Dargs.input=$PWD/indirect-keyref-test.ditamap -find

The buildfile reads `build.properties` files in the current directory and passes the properties in that file to DITA-OT. That means that if an issue requires specific DITA properties to be set, you can add them into the `build.properties` file for that issue. For example, instead of passing the name of the DITA map file on the command line as above, you can add a build.properties file like this:

    args.input = ${user.dir}/indirect-keyref-test.ditamap
    
After that, a simple `ant -find` will do.


