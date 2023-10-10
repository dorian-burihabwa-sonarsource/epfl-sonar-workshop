# EPFL Sonar Workshop (October 2023)

This repository serves as the base project to implement custom rules for Java.
It is derived from the [base template of the sonar-java project](https://github.com/SonarSource/sonar-java/tree/1947bdb5bec965afcee43087febf32245cb06253/docs/java-custom-rules-example).

For more details about how to write custom rules, please refer to the official tutorial, [Writing Custom Java Rules 101](https://github.com/SonarSource/sonar-java/blob/1947bdb5bec965afcee43087febf32245cb06253/docs/CUSTOM_RULES_101.md).

[A brief introduction to SonarQube](docs/sonarqube-101.md)

## Adding your own project to SonarQube

We are going to analyze our own repository by adding it manually.

- On the ["How do you want to create your project?"](http://localhost:9000/projects/create) Select ["Manually"](http://localhost:9000/projects/create?mode=manual).
- Enter "epfl-sonar-workshop" as the project name and project key, and click "Set Up"
- Select ["Locally"](http://localhost:9000/dashboard?id=epfl-sonar-workshop&selectedTutorial=local),
- On the "Provide a token" step, create the 30-days token and __make a copy of it__
- On the "Run analysis on your project" step, select Maven and __make a copy of the command suggested by SonarQube__
- __Before running the command, replace "mvn" with "./mvnw" on Linux/Mac__
- Open a terminal at the root of the project and run the command suggested by SonarQube

If the command succeeds, your browser tab should update soon with the results of the analysis.

### Building the custom rules plugin

To build the plugin and run the tests, just run:

```shell
./mvnw clean verify
```

If the build goes through properly, the `target` folder at the top of the project should now contain multiple JAR files.
One of them should be named [epfl-sonar-workshop-7.16.0.30901.jar](target%2Fepfl-sonar-workshop-7.16.0.30901.jar).

### Loading your plugin into a SonarQube instance

To load your plugin, copy your [epfl-sonar-workshop-7.16.0.30901.jar](target%2Fepfl-sonar-workshop-7.16.0.30901.jar) to `lib/extensions/`folder in your SonarQube instance.
Restart the SQ instance.

You can check that your plugin is now loaded by querying localhost:900/api/plugins/installed.

## Additional resources

- [SonarQube 9.9 Official documentation](https://docs.sonarsource.com/sonarqube/9.9)
- [Sonar-java](https://github.com/SonarSource/sonar-java)
- [Writing Custom Java Rules 101](https://github.com/SonarSource/sonar-java/blob/1947bdb5bec965afcee43087febf32245cb06253/docs/CUSTOM_RULES_101.md)

## License

All contents under this directory are licensed under the more permissive [MIT No Attribution](LICENSE.txt) license.
