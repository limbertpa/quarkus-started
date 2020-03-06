# quarkus-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

```
mvn quarkus:dev
```

## Packaging and running the application

The application is packageable using 
`./mvnw package`.
`mvn package`.
It produces the executable `quarkus-started-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-started-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
`./mvnw package -Pnative`.
`mvn package -Pnative`.

Or you can use Docker to build the native executable using:
 `./mvnw package -Pnative -Dquarkus.native.container-build=true`.
 `mvn package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/quarkus-started-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .


`./mvnw package -Pnative -Dquarkus.native.container-build=true`

`./mvnw package -Pnative -Dquarkus.native.container-runtime=docker`

`docker build -f src/main/docker/Dockerfile.native -t quarkus-quickstart/getting-started .`

`docker run -i --rm -p 8080:8080 quarkus-quickstart/getting-started`