## How to Import External Dependencies in Java using Eclipse

To import external dependencies in Java using Eclipse, follow these steps:

1. Download the necessary dependency files. These files typically have a .jar extension and can be found on Java library repository sites like Maven Central.
2. In this project the files are:
   - mysql-connector-java-8.0.17.jar
   - c3p0-0.9.5.4.jar
   - mchange-commons-java-0.2.16.jar
3. Copy the dependency files to the "lib" folder of your Java project. If this folder doesn't exist, create it.
4. Open Eclipse.
5. Add the dependencies to your Java project:
   - Right-click on the project folder -> Build Path -> Configure Build Path.
   - Click the "Libraries" tab and click the "Add JARs" button.
   - Navigate to the "lib" folder and select the mysql-connector-java-8.0.17.jar, c3p0-0.9.5.4.jar, and mchange-commons-java-0.2.16.jar files.
6. Verify that the dependencies were added correctly:
   - Check that the dependency files appear in the Libraries list in Build Path -> Configure Build Path.
7. You're done! Now you can use the external dependencies in your Java project.



## How to Import External Dependencies in Java using IntelliJ IDEA

To import external dependencies in Java using IntelliJ IDEA, follow these steps:

1. Download the necessary dependency files. These files typically have a .jar extension and can be found on Java library repository sites like Maven Central.
2. In this project the files are:
   1. mysql-connector-java-8.0.17.jar
   - c3p0-0.9.5.4.jar
   - mchange-commons-java-0.2.16.jar
3. Copy the dependency files to a folder in your project directory. For example, you can create a "lib" folder in the project root directory and copy the files there.
4. Open IntelliJ IDEA.
5. Add the dependencies to your Java project:
   - Right-click on the project folder -> Open Module Settings.
   - Click the "Dependencies" tab and click the "+" button.
   - Select "JARs or directories" and navigate to the folder containing the dependency files.
   - Select the necessary dependency files and click "OK".
   - Select the mysql-connector-java-8.0.17.jar, c3p0-0.9.5.4.jar, and mchange-commons-java-0.2.16.jar files and click "OK".
6. Verify that the dependencies were added correctly:
   - Check that the dependency files appear in the Dependencies list in Open Module Settings.
7. You're done! Now you can use the external dependencies in your Java project.