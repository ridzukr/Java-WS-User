
1) Создаем Maven-проект.

2) В pom.xml подтягиваем зависимости и плагин.

3) В org/example/server
формируем пакеты, классы.

4) Запускаем
 org/example/server/UserServicePublisher

5) Сгенерированный WSDL-файл (XML формат) можем получить
в браузере через запуск http://localhost:8080/ws/user

6) В IDE запустим Maven-команды через боковую панель Maven.
mvn clean
mvn install
mvn jaxws:wsimport

В org/example/client/generated появятся сгенерированные
файлы.

7) В org/example/client/generated исследуем файлы.
При необходимости, подтянем зависимости.

8) Создаем JUnit тесты. Тестируем приложение.

