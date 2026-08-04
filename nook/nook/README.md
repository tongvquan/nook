# Nook

## 1. Start Docker containers

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

## 2. Run the application

Run the application with Gradle:

```bash
./gradlew bootRun
```

On Windows PowerShell:

```powershell
.\gradlew.bat bootRun
```

## 3. Run SonarQube analysis

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

## 4. URLs

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
