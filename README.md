# Nook

## 1. Project structure

The project follows a clean architecture style. Business rules stay near the center, while framework and infrastructure details stay in adapters.

```text
src/main/java/com/tongquan/nook
|-- domain
|-- application
|   |-- port
|   |   |-- in
|   |   `-- out
|   `-- service
|-- adapter
|   |-- in
|   |   `-- web
|   `-- out
|       |-- client
|       |-- kafka
|       |-- persistence
|       `-- redis
`-- shared
    |-- config
    |-- constants
    |-- exception
    |-- util
    `-- validation
        |-- annotation
        `-- validator
```

| Package | Responsibility |
| --- | --- |
| `domain` | Core business models, domain rules, domain services, and domain events. This layer should not depend on Spring, database, Redis, Kafka, or HTTP concerns. |
| `application` | Use case orchestration. Application services implement input ports and call output ports. |
| `application/port/in` | Input boundaries used by inbound adapters, such as web controllers. |
| `application/port/out` | Output boundaries implemented by outbound adapters, such as persistence, Redis, Kafka, or external clients. |
| `adapter/in/web` | HTTP controllers, request/response DTOs, and web-specific mappers. |
| `adapter/out/persistence` | Database entities, Spring Data repositories, persistence adapters, and persistence mappers. |
| `adapter/out/redis` | Redis-specific adapters and cache implementations. |
| `adapter/out/kafka` | Kafka producers, consumers, message DTOs, and message mappers. |
| `adapter/out/client` | External service clients and their adapters. |
| `shared/config` | Application-wide configuration, such as OpenAPI, security, CORS, Jackson, or infrastructure configuration. |
| `shared/constants` | Technical constants that are reused across the application. |
| `shared/exception` | Global exception handling and common technical error responses. |
| `shared/util` | Small framework-independent utility helpers. Keep this package minimal. |
| `shared/validation/annotation` | Custom validation annotations, such as `@ValidEnum`. |
| `shared/validation/validator` | Implementations for custom validation annotations. |

General dependency direction:

```text
adapter -> application -> domain
```

Adapters may depend on application ports. Application code may depend on domain code. Domain code should remain independent from framework and infrastructure code.

## 2. Start Docker containers

Start the required services with Docker Compose:

```bash
docker compose up -d
```

This command creates and starts the following containers:

- `nook-postgres`: PostgreSQL database
- `nook-redis`: Redis
- `nook-kafka`: Kafka
- `nook-sonar-db`: PostgreSQL database for SonarQube
- `nook-sonarqube`: SonarQube server

Check the container status:

```bash
docker compose ps
```

Stop the containers when they are no longer needed:

```bash
docker compose down
```

## 3. Run the application

Run the application with Gradle:

```bash
./gradlew bootRun
```

On Windows PowerShell:

```powershell
.\gradlew.bat bootRun
```

## 4. Run SonarQube analysis

SonarQube runs locally at:

```text
http://localhost:9000
```

Before running the analysis, create a SonarQube token from the local SonarQube UI and add it to `.env`:

```dotenv
SONAR_TOKEN=your-token
```

Run the analysis with Gradle:

```bash
./gradlew sonar
```

On Windows PowerShell:

```powershell
.\gradlew.bat sonar
```

The `sonar` task runs the tests and generates the JaCoCo XML coverage report before sending the analysis to SonarQube.

Current SonarQube project settings:

- Project key: `nook`
- Project name: `Nook`
- Host URL: `http://localhost:9000`

## 5. URLs

Health check endpoint:

```text
GET http://localhost:8080/actuator/health
```

Call it with `curl`:

```bash
curl http://localhost:8080/actuator/health
```

On Windows PowerShell:

```powershell
Invoke-RestMethod http://localhost:8080/actuator/health
```

Expected response:

```json
{
  "status": "UP"
}
```

If the status is `DOWN` or the endpoint does not respond, check the application logs and dependent services such as PostgreSQL, Redis, and Kafka.
