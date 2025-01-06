# MPR-PROJEKT
**MPR Projekt - flightmanagement**

Założenie projektu polega na możliwości tworzenia lotów i automatycznego dostosowania jego zależności na podstawie aktualnej pogody, jak również czasu lotu. Pozwala również na operacje `CRUD` pasażerów lotów.

Projekt podzieliłem na 3 moduły by był bardziej czytelny.
Jest rozdzielony na 3 modele, znajdują się w nim relacje bazodanowe, które wykorzystują `Derived Query Methods`.
Używam `MapStruct` do mapowania Request na Response.
Podłączyłem się do `OpenWeatherMap API`, by móc pobierać aktualne dane pogodowe dla danego miasta.
Endpointy projektu, pozwalają wyświetlać, tworzyć oraz usuwać dane z bazy danych za pomocą `GET`, `POST`, `PUT`, `DELETE`.

- **Połączenie z konsolą bazy danych**:
```
http://localhost:8080/h2-console/login.jsp
JDBC URL: jdbc:h2:file:./database/database;DB_CLOSE_ON_EXIT=FALSE
User Name: sa
Password: password
```
- **Ustawienie Headers dla Postmana**:
```
Key = Content-Type
Value = application/json
```
- **Przykładowe Body dla Request**:
    1. Tworzenie miasta (POST) - `http://localhost:8080/cities/create`
        ```json
        {
            "name": "Warsaw",
            "country": "Poland",
            "latitude": 52.2297,
            "longitude": 21.0122
        }
        ```
    2. Tworzenie lotniska (POST) - `http://localhost:8080/airports/create`
        ```json
        {
            "name": "WAW",
            "cityId": 1
        }
        ```
    3. Tworzenie lotu (POST) - `http://localhost:8080/flights/create`
        ```json
        {
            "flightNumber": "ABCXYZ1234",
            "flightLength": 2,
            "departureTime": "2025-01-05T10:30:00",
            "departureAirportId": 1,
            "arrivalAirportId": 2
        }
        ```
    4. Tworzenie/Edycja pasażera (POST/PUT) - `http://localhost:8080/passengers/create` lub `http://localhost:8080/passengers/update`
        ```json
        {
            "email": "jackblack@gmail.com",
            "firstName": "Jack",
            "lastName": "Black",
            "flights": [1, 2]
        }
        ```
    5. Wydobycie aktualnych danych pogodowych dla miasta z API (POST) - `http://localhost:8080/weather/fetch`
        ```json
        {
            "cityName": "Warsaw"
        }
        ```
