# Weather Service Application

## Technology stack

- [Java Development Kit 19 on Alpine Linux](https://hub.docker.com/layers/library/openjdk/19-jdk-alpine/images/sha256-900cf954703d9076ed0c147d5be2fa1893fa1808ee7001f95638c9d26a7453e2)
- [Spring Boot 3.3.4](https://spring.io/blog/2024/09/19/spring-boot-3-3-4-available-now)
- [Lombok](https://projectlombok.org/)
- [Thymeleaf](https://www.thymeleaf.org/)

## Method 1: Launch Application in the development environment

```shell
# Clone the project
git clone https://github.com/Ossowitz/WeatherService.git
```

```text
Launch your application directly in the IDE
```

_Open in your browser http://serverIP:8080/weather._

## Method 2: Launch Application using Docker

```shell
# Clone the project
git clone https://github.com/Ossowitz/WeatherService.git
```

```shell
mvn deploy
```

```shell
cd /WeatherService
```

```shell
docker build -t WeatherService .
```

```shell
docker run -d -p 8080:8080 WeatherService
```

_Open in your browser http://serverIP:8080/weather._