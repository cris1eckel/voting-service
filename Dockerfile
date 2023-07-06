ARG REPOSITORY_URL=237180123938.dkr.ecr.eu-north-1.amazonaws.com
FROM ${REPOSITORY_URL}/ecr-public/docker/library/eclipse-temurin:11-jre-alpine
COPY target/voting.service.jar /opt/app/application.jar
COPY infra/image/entrypoint.sh /opt/app/entrypoint.sh
RUN chmod +x /opt/app/entrypoint.sh
RUN apk add --no-cache libstdc++
EXPOSE 8000
# JMX
EXPOSE 9011
# JVM debugging port
EXPOSE 5006

ENTRYPOINT [ "/opt/app/entrypoint.sh" ]
