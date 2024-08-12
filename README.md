# voting-service - 2024

# About

Microservice made with the intention of collecting votes from associates of a cooperative.

# Compiling the project

To compile the project you'll need Docker and Docker Compose, the docker compose will already run: Maven, Spring Boot, PostgreSQL and Kafka.

```docker-compose up --build```

# Postman Collection: 
https://api.postman.com/collections/21156084-0dfc0d20-3b05-404f-88c5-5b2837de43a5?access_key=PMAT-01H535DVM1T39PPRNF69KDCJMB

# API Endpoints

# NEW Voting-Topic (Pauta)
curl --location 'http://localhost:8080/voting-topic' \
--header 'Content-Type: application/json' \
--data '{
"subject": "Você está feliz com a forma que recompensamos nossos associados atualmente?"
}'

# NEW Voting-Session (Sessão)
curl --location 'http://localhost:8080/voting-session' \
--header 'Content-Type: application/json' \
--data '{
"votingTopic": {
"id": 1
},
"startDate": "2023-10-08T14:00:00.000",
"endDate": "2023-07-13T15:00:00.000"
}'

# NEW Vote(Voto)
curl --location 'http://localhost:8080/vote' \
--header 'Content-Type: application/json' \
--data '{
"votingTopic": {
"id": 1
},
"associateCode":3,
"vote":true,
"nationalId":"03899212037"
}'

# GET RESULTS
curl --location 'http://localhost:8080/voting-session/1/results'