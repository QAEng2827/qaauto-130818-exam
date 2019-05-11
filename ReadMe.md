Automation test for checking google search results from Chrome and FireFox Browsers

Project verifies searching in https://www.google.com.
Project includes case sensitive keyword test for search in first 2 pages.
There are 4 Page classes and 2 Test classes.
GoogleBasePage and GoogleBaseTest classes are used for common with other classes methods and parameters.

To execute tests from command line of Terminal: mvn clean install -DsuiteXmlFile=testNG.xml
To execute tests from GUI: right click on TestNG.xml and Run it.

For environment setup:

    Download and install Java/JDK. http://www.oracle.com/technetwork/java/javase/downloads/index.html
    Download and install Intelij Idea, Community version. https://www.jetbrains.com/idea/download/#section=windows
    Download Maven from https://maven.apache.org/download.cgi
    Define Maven path in PATH variable (to check from cmd mvn -version)
    Clone this project to Intelij Idea.
    Install Chrome and FireFox browsers

    To execute tests from command line of Terminal: mvn clean install -DsuiteXmlFile=testNG.xml
    To execute tests from GUI: right click on testNG.xml and Run it.

test