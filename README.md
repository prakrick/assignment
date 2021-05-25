# Test Automation Framework Setup
_This document will guide you through the setup process. If you find any aspects that are inaccurate please feel free to communicate it so that the document can be amended._

This is an test automation framework that can be used to automate and execute your web application test cases.

- Write test scripts
- Execute the tests scripts

>The instructions provided below are based upon the configuration used for creating this framework. Feel free to use alternatives whenever required.

## Installation

- Requires [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
- Requires [Eclipse](https://www.eclipse.org/downloads/)
- Requires [git](https://git-scm.com/downloads) 

### Cloning the repository
- Run: ```git clone https://github.com/prakrick/assignment.git```

### Project Setup
- Import the cloned project as 'Existing Maven Project' in eclipse
- Install 'Maven Integration for Eclipse', 'Cucumber Eclipse Plugin' from Eclipse marketplace
- Build the project to install the dependencies mentioned in the pom.xml file

### Running the test scripts
>The automation framework currently has 1 test case automated which has been annoted with tag "@regresesion"
- Go to ```src/test/java/com/evoAutoamtion/runner/TestRunner.java ```
- Right click on the TestRunner.java file and select Run As>Junit Test
OR
- Right click on the project folder in eclipse and Go to _Run As>Maven Test_
The test case execution should start now. 
Upon completion, you can find the automation report generated inside the _target_ folder in project root directory
```report name: cucumber-reports.html```
