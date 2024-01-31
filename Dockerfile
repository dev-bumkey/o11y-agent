#FROM openjdk:17-oracle
#COPY target/LogOperator-1.0-SNAPSHOT.jar my-app.jar
#CMD -jar my-app.jar

#COPY target/LogOperator-1.0-SNAPSHOT.jar my-app.jar
##COPY target/opentelemetry-javaagent.jar opentelemetry-javaagent.jar
#CMD ["java", "-javaagent:/opentelemetry-javaagent.jar", "-jar", "/my-app.jar"]
#ENV OTEL_EXPORTER_JAEGER_SERVICE_NAME=my-app
#ENV OTEL_EXPORTER_JAEGER_AGENT_HOST=jaeger-agent
#ENV OTEL_EXPORTER_JAEGER_AGENT_PORT=6831
FROM openjdk:17-jdk-slim
COPY target/LogOperator-1.0-SNAPSHOT.jar app.jar

RUN apt-get update
RUN apt-get install -y wget

ENV OTEL_EXPORTER_OTLP_ENDPOINT=${OTEL_EXPORTER_OTLP_ENDPOINT}
ENV OTEL_EXPORTER_OTLP_LOGS_ENDPOINT=${OTEL_EXPORTER_OTLP_ENDPOINT}
ENV OTEL_LOGS_EXPORTER=logging

RUN wget -q https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v2.0.0/opentelemetry-javaagent.jar
ENTRYPOINT ["java", "-javaagent:opentelemetry-javaagent.jar", "-jar", "app.jar"]

EXPOSE 8080:8080
