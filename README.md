# Computer Database Project
This repository contains 6 scenarios (3 US of Task 1) for Computer Database application covering the basic flow. This test framework executes Scenarios in parallel.

# Pre-requisites:
JDK 21
Maven 3.9.6
IntelliJ
Plugins for Cucumber, Maven, Gherkin
Jenkins
Github

# Project Structure:
<img width="260" alt="image" src="https://github.com/sonalidwivedi/Computer-Database/assets/114146513/f9679476-5923-4427-b26e-d57fd1b7f6da">





# Usage:
Clone the repository:
``` git clone https://github.com/sonalidwivedi/Computer-Database.git ```

# Navigate to the project directory:
``` cd Computer-Database ```

# Run the tests:
``` mvn clean install ```
``` mvn test ```

TestRunner file can also be directly be executed.The tests will execute in parallel, and you can view the test results in the target/cucumber-reports directory. Individual features acn also be executed

# Jenkins Setup:
1. Add maven integration plugin.
2. Add Maven, Git and JDK path in Settings.
3. Add a new Pipeline, providing the git repo, branch as master and Script Path as Jenkinsfile.
4. Generate the build

# Cucumber Report on Jenkins:
<img width="960" alt="image" src="https://github.com/sonalidwivedi/Computer-Database/assets/114146513/af34c90a-6928-4923-ba8a-3ba612d7d0f8">

