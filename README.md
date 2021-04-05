# MongoDB-coding-challenge

## To run:
- install Java 11
- navigate into the src folder of the project
- javac -cp .:../gson-2.8.6.jar Main/Main.java
- cat path-to-json-file.json | java -cp .:../gson-2.8.6.jar Main/Main
where path-to-json-file.json is for instance ../basic.json for the test file I added
for testing purposes

## Sources used:
- for reading input stream and piping: https://stackoverflow.com/questions/5724646/how-to-pipe-input-to-java-program-with-bash?noredirect=1&lq=1
- for debugging compiling and running Java program from command line: https://stackoverflow.com/questions/18093928/what-does-could-not-find-or-load-main-class-mean
- for adding external libraries without Maven: https://stackoverflow.com/questions/10656428/include-gson-in-my-java-program
- for adding gson to classpath when compiling and running: https://stackoverflow.com/questions/10656428/include-gson-in-my-java-program
