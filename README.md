# EPFL Sonar Workshop (October 2023)

This repository serves as the base project to implement custom rules for Java.
It is derived from the [base template of the sonar-java project](https://github.com/SonarSource/sonar-java/tree/1947bdb5bec965afcee43087febf32245cb06253/docs/java-custom-rules-example).

For more details about how to write custom rules, please refer to the official tutorial, [Writing Custom Java Rules 101](https://github.com/SonarSource/sonar-java/blob/1947bdb5bec965afcee43087febf32245cb06253/docs/CUSTOM_RULES_101.md).

## A brief introduction to SonarQube

### Downloading SonarQube 9.9
Start by getting a copy of SonarQube 9.9 Community edition from the [SonarQube website](https://binaries.sonarsource.com/Distribution/sonarqube/sonarqube-9.9.2.77).
Following the instructions from the [official documentation](https://docs.sonarsource.com/sonarqube/9.9),

### Starting SonarQube
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

Login with the default credentials (user: admin, password: admin) and update with a new password of your choice.

### Exploring SonarQube

With your new running instance, let's get familiar with some of the concepts present of the Sonar ecosystem.

#### Rules

You should be able to list all the rules available to you by browsing on the [rules page](http://localhost:9000/coding_rules).
You can play around with the filters.

Note how every rule has:
- A unique key
- A description
- A type
- A severity
- A repository of origin

Additionally, a rule may have:
- Multiple language implementations
- Tags
- Customizable parameters

---
Before moving on, ask yourself:
- How many rules are there for Java?
- How many rules are there that apply both for Java and Kotlin?
- Can I find a rule with a customizable parameter?
---

#### Quality profiles

In order to apply a set of rules to your project, they can be grouped as __quality profiles__.
Sonar provides default a quality profile named "Sonar way".
It serves as the default quality profile.

Such a profile can then be:
- copied (an identical separate copy that can be modified)
- extended (depends on the original one that can be modified but can bring its own modifications)

The new profiles can then be set as defaults for our SonarQube instance or just used for some of our existing projects.

---
Before moving on, ask yourself:
- How many rules are there in the "Sonar Way" quality profile for Java?
- Is there a difference with the number of available rules?
---


#### Quality gates

To get a quick look at your project's health and ensure a reasonable state, [Quality Gates](http://localhost:9000/quality_gates/) can prove usefué.
It is a combination of a quality profile and a set of conditions that should be matched.
The quality gate can either been green or red.
You can leverage this quality gate toggle in your CI pipeline to get familiar to block releases or trigger alerts for your development team.

---
Before moving on, ask yourself:
- What is the name of the default quality gate?
- Is this quality gate applied to all code?
---

## Analyzing your first project with SonarQube

We are going to analyze our first project with SonarQube.
First, clone or get a copy of the [spring-petclinic project](https://github.com/spring-projects/spring-petclinic).
Then follow the instructions to get the project analyzed.

- On the ["How do you want to create your project?"](http://localhost:9000/projects/create) Select ["Manually"](http://localhost:9000/projects/create?mode=manual).
- Enter "spring-petclinic" as the project name and project key, and click "Set Up"
- Select ["Locally"](http://localhost:9000/dashboard?id=epfl-sonar-workshop&selectedTutorial=local),
- On the "Provide a token" step, create the 30-days token and **make a copy of it**.
- On the "Run analysis on your project" step, select Gradle and **make a copy of the command suggested by SonarQube**
- Open a terminal at the root of the project and run the command suggested by SonarQube

If the command succeeds, your browser tab should update soon with the results of the analysis.

Take some time to look around and explore the results of the analysis.

---
Before moving on, ask yourself:
- How many issues are detected?
- What is the status of the quality gate?
- What is the version of the project you analyzed?
- How many lines of code are there in the project?
---


## Adding your own project to SonarQube
We are going to analyze our own repository by adding it manually.

- On the ["How do you want to create your project?"](http://localhost:9000/projects/create) Select ["Manually"](http://localhost:9000/projects/create?mode=manual).
- Enter "epfl-sonar-workshop" as the project name and project key, and click "Set Up"
- Select ["Locally"](http://localhost:9000/dashboard?id=epfl-sonar-workshop&selectedTutorial=local),
- On the "Provide a token" step, create the 30-days token and **make a copy of it**.
- On the "Run analysis on your project" step, select Maven and **make a copy of the command suggested by SonarQube**
- ** Before running the command, replace "mvn" with "./mvnw"
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
