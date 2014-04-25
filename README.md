dita-ot-issues
==============

A set of fixtures for testing DITA-OT issues.

### Basic use

In most cases, provided that your `DITA_HOME` environment variable points to a working DITA-OT installation, to generate output for a given issue, you should be able to just do something like:

    cd fixtures/1173
    ant -find
    
The Ant buildfile in this repository should be able to build pretty much any DITA file regardless of the DITA-OT version you're using. You don't need to set the `CLASSPATH`, either — in fact, it's probably better if it's empty. If it doesn't work, though, please let me know.

A default set of properties passed to DITA-OT is defined in the `build.properties` file in the root of this repository.

To locate your DITA-OT installation, the buildfile uses the `DITA_HOME` environment variable. You can tell it to use another DITA-OT version by doing:

    ant -Ddita.home=/path/to/dita-ot ...

By default, the buildfile looks for a DITA map called `root.ditamap` in the directory where you run `ant`. If your DITA file has another name, you'll have to tell that to the buildfile.

There's two ways to do that. The buildfile reads the `build.properties` file in the current directory and passes the properties in that file to DITA-OT. So, if a specific set of DITA properties needs to be set for an issue to occur, you can add them into the `build.properties` file for that issue.

That means that to specify the name of your DITA file, you can add a `build.properties` file like this into the directory of the issue you're working on:

    args.input = ${user.dir}/indirect-keyref-test.ditamap
    
Or you can specify a different transtype than the default one:

    transtype = pdf2
    
Or you can set any other DITA-OT property that you need to.

After that, a simple `ant -find` is enough to build the document.

You can also pass any DITA-OT properties as command-line arguments as you normally would:

    cd fixtures/1605
    ant -Dargs.input=$PWD/indirect-keyref-test.ditamap -Dtranstype=pdf2 -find
    # On Windows, use %CD% instead of $PWD

You can even specify which DITA-OT Ant targets to execute. For example, to only run the DITA-OT preprocessing stage, into `build.properties`, add:

    ant.targets = build-init preprocess
    
Or, on the command line:

    ant -Ddost.ant.targets="build-init preprocess" -find

**NOTE**: The parameter is `ant.targets` in `build.properties` and `dost.ant.targets` on the command line because of Ant's property prefix magic.


