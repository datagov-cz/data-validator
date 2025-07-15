FROM openjdk:23-jdk-slim AS build

WORKDIR /opt/data-validation
COPY ./ ./
RUN chmod a+x ./gradlew
RUN ./gradlew installDist
RUN chmod a+x /opt/data-validation/dist/bin/data-validator-cli

FROM openjdk:23-slim
WORKDIR /opt/data-validation
COPY --from=build ./opt/data-validation/dist ./
ENTRYPOINT  ["/opt/data-validation/bin/data-validator-cli"]
