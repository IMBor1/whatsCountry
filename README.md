# Phone Number Country Detector

Сервис для определения страны по номеру телефона.

## Требования

- Java 11 или выше
- PostgreSQL
- Gradle

## Настройка базы данных

1. Создайте базу данных PostgreSQL:
```sql
CREATE DATABASE phone_country;
```

2. Настройте подключение к базе данных в `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/phone_country
spring.datasource.username=your_postgres
spring.datasource.password=1234
```

## Запуск приложения

1. Клонируйте репозиторий:
```bash
git clone https://github.com/IMBor1/whatsCountry.git
cd whatsCountry
```

2. Соберите проект:
```bash
./gradlew build
```

3. Запустите приложение:
```bash
./gradlew bootRun
```

Приложение будет доступно по адресу: http://localhost:8088

## API Endpoints

### Определение страны по номеру телефона

```
GET /phone/country?phoneNumber={phoneNumber}
```

Примеры:
- http://localhost:8088/api/phone/country?phoneNumber=+12423222931
- http://localhost:8088/api/phone/country?phoneNumber=+77112227231

## Запуск тестов

```bash
./gradlew test
```

## Технологии

- Spring Boot 2.7.18
- PostgreSQL
- JPA/Hibernate
- JUnit
- Gradle
- HTML/JavaScript 