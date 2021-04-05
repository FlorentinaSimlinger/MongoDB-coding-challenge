# MongoDB-coding-challenge

## Notes:
- I used most of the time playing with different libraries. I started out with gson but realized that
it's more difficult to traverse as relies on the use of objects. I then switched to Json from json.org.
- I also wasted some time because I didn't set up my project to use Maven. I was unfamiliar with that as
we never had to use it for school. I thus had to find the jar files and add them manually.

## To run:
- install Java 11
- navigate into the src folder of the project
- `javac -cp .:../gson-2.8.6.jar Main/Main.java`
- `cat path-to-json-file.json | java -cp .:../gson-2.8.6.jar Main/Main`
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