# EconomyAPI

![Maven Central Version](https://img.shields.io/maven-central/v/org.allaymc/economyapi?label=economyapi)

EconomyAPI is a plugin that unifies all economy plugins under one single API. The API can be used by both economy plugins
providing the API, and other plugins using the API (i.e. shop plugins). This allows for all plugins that require an economy
to work with any economy plugin.

## Usages

```kts
repositories {
    mavenCentral()
}

dependencies {
    compileOnly(group = "org.allaymc", name = "economyapi", version = "0.1.0")
}
```

WIP

## Install


- Download .jar file from [release](https://github.com/AllayMC/PlaceholderAPI/releases) or [action](https://github.com/AllayMC/PlaceholderAPI/actions/workflows/gradle.yml)

- Put it into `plugins` folder

- Restart the server, enjoy!


## Getting Started


1. **Clone this Repository**


```bash

git clone https://github.com/AllayMC/JavaPluginTemplate.git

```

   
2. **Navigate to the Cloned Directory**


```bash

cd JavaPluginTemplate

```

   
3. **Change Plugin Information**


- Rename package name from `org.allaymc.javaplugintemplate` to `your.group.name.and.pluginname`

- Update [build.gradle.kts](build.gradle.kts) and [settings.gradle.kts](settings.gradle.kts)

- Reload gradle

   
4. **Build and Run Your Plugin**


```bash

gradlew shadowJar

```

   
This command will produce a `.jar` file in the `build/libs` directory. 

Copy the `.jar` file to the `plugins` directory of your allay server.

Start the allay server and check the logs to ensure your plugin loads and operates

as expected.


5. **Test Your Plugin in Gradle**


```bash

gradlew runServer

```


This command will start an allay server with your plugin loaded.

Then close allay server by clicking `X` in the dashboard window.

## Requirement

Java: 21+

Allay: 0.17.0+

## Contributing

Contributions are welcome! Feel free to fork the repository, improve the code, and submit pull requests with your
changes.

## License

This project is licensed under the LGPL v3 License - see the [LICENSE](LICENSE) file for details.