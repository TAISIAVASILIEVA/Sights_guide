**REST-сервис для хранения данных о городских достопримечательностях**

**Хранящиеся структуры данных:**

Город:
* Идентификатор
* Название города
* Численность населения
* Наличие метро
* Страна

Достопримечательность:
* Идентификатор
* Название достопримечательности
* Краткое описание
* Тип достопримечательности (Музей, заповедник, памятник, здание, галерея)
* Идентификатор города


**Основные возможности:**
1. Получение всех достопримечательностей(опциональные фильтры - параметр для сортировки по наименованию достопримечательности, параметр для фильтрации по типу достопримечательности)
2. Получение достопримечательностей конкретного города
3. Добавление достопримечательности
4. Изменение данных достопримечательности(только поле "краткое описание")
5. Удаление достопримечательности
6. Добавление города
7. Изменение данных по городу(только поля: численность населения, наличие метро)


**Информация о сервисе**

* Используемая база-данных: PostgreSQL
* Название локальной базы данных: CitySights
* При первом запуске сервис самостоятелньно создает необходимые объекты в БД с помощью Liquibase.
* Логирование REST-сервиса осуществляется в папку CitySights/logs
* Сервис развертывается на порту 8080, доступен по адресу: `localhost:8080/`

**Для запуска необходимо**

* В файле application.yml сконфигурировать `url`, `username`, `password` в соответствии со своим локальным сервером PostgresSQL
* Создать базу данных с названием "CitySights"

**Документацию на REST-методы сервиса можно посмотреть по URL: `localhost:8080/documentation`**
