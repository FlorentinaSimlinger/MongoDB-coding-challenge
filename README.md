# Coding challenge

## Notes:
- I used most of the time playing around with different libraries to work with Json. I started out using gson but realized that
it's not appropriate for our use case as it relies on the use of objects. I then switched to Json from json.org.
- I also spent some time adding those dependencies. I added the jar files manually, next time I would probably invest the time
in using Maven.
- If I had more time I would also look up how to avoid having to add the libraries on the classpath when
executing the code.

## To run:
- if not yet installed, install Java 11 by calling `sudo apt-get install openjdk-11-jdk`
- navigate into the src folder of the project
- to compile: `javac -cp .:../json-20210307.jar:../commons-lang3-3.12.0.jar Main/Main.java`
- to run: `cat path-to-json-file.json | java -cp .:../json-20210307.jar:../commons-lang3-3.12.0.jar Main/Main`
where `path-to-json-file.json` is for instance `../basic.json` for the test file I added
for testing purposes

## Sources used:
- for reading input stream and piping: https://stackoverflow.com/questions/5724646/how-to-pipe-input-to-java-program-with-bash?noredirect=1&lq=1
- for debugging compiling and running Java program from command line: https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean
- for adding external libraries without Maven: https://stackoverflow.com/questions/10656428/include-gson-in-my-java-program
- for adding gson to classpath when compiling and running: https://stackoverflow.com/questions/10656428/include-gson-in-my-java-program
- for creating a Json object using gson: https://stackoverflow.com/questions/4683856/creating-gson-object
- inspiration for recursion: https://medium.com/swlh/how-to-use-recursion-to-flatten-a-javascript-object-17e43cc00159
- for using reflectionEquals for asserting objects have same fields: https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/builder/EqualsBuilder.html#reflectionEquals-java.lang.Object-java.lang.Object-java.lang.String...-