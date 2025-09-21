FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app

COPY . .

# mvnw 실행 권한 부여
RUN chmod +x ./mvnw

# 빌드
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
