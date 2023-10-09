# EPFL Sonar Workshop (October 2023)

This repository serves as the base project to implement custom rules for Java.
It is derived from the [base template of the sonar-java project](https://github.com/SonarSource/sonar-java/tree/1947bdb5bec965afcee43087febf32245cb06253/docs/java-custom-rules-example).

For more details about how to write custom rules, please refer to the official tutorial, [Writing Custom Java Rules 101](https://github.com/SonarSource/sonar-java/blob/1947bdb5bec965afcee43087febf32245cb06253/docs/CUSTOM_RULES_101.md).

## Running SonarQube locally

### Downloading SonarQube 9.9
Start by getting a copy of SonarQube 9.9 Community edition from the [SonarQube website](https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.2.77).
Following the instructions from the [official documentation](https://docs.sonarsource.com/sonarqube/9.9),

### Getting started with SonarQube
Unzip the archive, get into the unzipped folder and open a terminal.
To start SonarQube, run:

```shell
# Linux
./bin/linux-x86-64/sonar.sh console
# Mac OS
./bin/macosx-universal-64/sonar.sh console
# Windows
bin\windows-x86-64\StartSonar.bat
```

After a few seconds, you should be able to connect to your instance on http://localhost:9000.

TODO: Insert image here

Login with the default credentials (user: admin, password: admin) and update with a new password of your choice.

## Adding a new project to SonarQube
We are going to analyze our own repository by adding it manually.

- On the ["How do you want to create your project?"](http://localhost:9000/projects/create) Select ["Manually"](http://localhost:9000/projects/create?mode=manual).
- Enter "epfl-sonar-workshop" as the project name and project key, and click "Set Up"
- Select ["Locally"](http://localhost:9000/dashboard?id=epfl-sonar-workshop&selectedTutorial=local),
- On the "Provide a token" step, create the 30-days token and **make a copy of it**.
- On the "Run analysis on your project" step, select Maven and **make a copy of the command suggested by SonarQube**
- Open a terminal at the root of the project and run the command suggested by SonarQube

If the command succeeds, your browser tab should update soon with the results of the analysis.


## Building the custom rules plugin

To build the plugin and run the tests, just run:

```shell
./mvnw clean verify
```

If the build goes through properly, the `target` folder at the top of the project should now contain multiple JAR files.
One of them should be named [epfl-sonar-workshop-7.16.0.30901.jar](target%2Fepfl-sonar-workshop-7.16.0.30901.jar).

## Loading your plugin into a SonarQube instance

To load your plugin, copy your [epfl-sonar-workshop-7.16.0.30901.jar](target%2Fepfl-sonar-workshop-7.16.0.30901.jar) to `lib/extensions/`folder in your SonarQube instance.
Restart the SQ instance.

You can check that your plugin is now loaded by querying localhost:900/api/plugins/installed.

## License

All contents under this directory are licensed under the more permissive [MIT No Attribution](LICENSE.txt) license.
