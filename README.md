![CI](https://github.com/spinnaker-plugin-examples/springStagePlugin/workflows/CI/badge.svg)

The [SpringStagePlugin](https://github.com/spinnaker-plugin-examples/springStagePlugin), creates a custom pipeline stage using Spring.

This is for demo only and not meant to be used in a production environment.

# Usage

1) Run `./gradlew releaseBundle`
2) Put the `/build/distributions/<project>-<version>.zip` into the [configured plugins location for your service](https://pf4j.org/doc/packaging.html).
3) Configure the Spinnaker service. Put the following in the service yml to enable the plugin and configure the extension:

```
spinnaker:
  extensibility:
    plugins:
      Armory.RandomWaitPlugin:
        enabled: true
        config:
          defaultMaxWaitTime: 60
```

Or use the [examplePluginRepository](https://github.com/spinnaker-plugin-examples/examplePluginRepository) to avoid copying the plugin `.zip` artifact.

## Deployment on Spinnaker 1.20.6+

See the [Plugin Users Guide](https://spinnaker.io/guides/user/plugins/) and the [pf4jStagePlugin Deployment Example](https://spinnaker.io/guides/user/plugins/deploy-example/).

# Debugging

To debug the `random-wait-orca`  server component inside a Spinnaker service (like Orca) using IntelliJ Idea follow these steps:

1) Run `./gradlew releaseBundle` in the plugin project.
2) Copy the generated `.plugin-ref` file under `build` in the plugin project submodule for the service to the `plugins` directory under root in the Spinnaker service that will use the plugin .
3) Link the plugin project to the service project in IntelliJ (from the service project use the `+` button in the Gradle tab and select the plugin build.gradle).
4) Configure the Spinnaker service the same way specified above.
5) Create a new IntelliJ run configuration for the service that has the VM option `-Dpf4j.mode=development` and does a `Build Project` before launch.
6) Debug away...

See the [Test a Pipeline Stage Plugin](https://spinnaker.io/guides/developer/plugin-creators/deck-plugin/) guide for a detailed walkthrough of setting up a plugin local testing environment on your workstation.

# Videos

* [Intro to Spinnaker Plugins](https://youtu.be/HtkXeC8a38Y), 2020 April Spinnaker Gardening Days
* [Plugins Training Workshop](https://youtu.be/oEHPvO88ROA), 2020 July Spinnaker Gardening Days
* [How to build a PLUGIN: Building the frontend for a Spinnaker-native custom stage](https://youtu.be/u9NVlG58NYo)
* [How to build a PLUGIN: Creating a Spinnaker-native custom stage](https://youtu.be/b7BmMY1kR10)
* [Backend Plugin Development](https://drive.google.com/open?id=1JPkXG5NnXowb1OElAFj2VjnpvUDA-Wyi)
* [How to build a PLUGIN: The build process for a Spinnaker plugin](https://youtu.be/-AIOXdgvNqs)
* [How to build a PLUGIN: Delivering a plugin to your Spinnaker environment](https://youtu.be/G2eyc9gzNS0)

