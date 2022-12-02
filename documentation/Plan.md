# План автоматизации тестирования сервиса покупки туров через интернет-банк

## 1. Перечень автоматизируемых сценариев

## Тестирование UI

### Позитивные сценарии (Happy Path):

#### 1: Покупка тура через кнопку "Купить" с главной страницы сервиса.
<em> 1.1: Оплата с помощью валидной карты, на которой есть достаточное количество денежных средств. Операция должна быть одобрена.</em>

Шаги воспроизведения:
1. Открыть главную страницу сервиса http://localhost:8080/
2. Нажать на кнопку "Купить"
3. Заполнить все поля валидными данными карты с достаточным количеством средств на счете (например, Номер карты - 1111 1111 1111 1111, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123)"
4. Нажать на кнопку "Продолжить"

<em>Ожидаемый результат: В правом верхнем углу появляется сообщение "Успешно Операция одобрена Банком"</em>

<em> 1.2: Оплата с валидной карты, на которой недостаточное количество денежных средств. Отказ в проведении операции.</em>

Шаги воспроизведения:
1. Открыть главную страницу сервиса http://localhost:8080/
2. Нажать кнопку "Купить"
3. Заполнить все поля валидными данными карты с недостаточным количеством средств на счете (например, Номер карты - 9999 9999 9999 9999, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123)
4. Нажать кнопку "Продолжить"

<em>Ожидаемый результат: В правом верхнем углу появляется сообщение "Ошибка! Банк отказал в проведении операции".</em>

#### 2: Покупка тура на вкладке "Купить в кредит" с главной страницы сервиса.
<em>Cценарий 2.1: Успешная покупка в кредит при оплате картой с валидным номером и достаточным кредитным лимитом</em>

Шаги воспроизведения:
1. Открыть главную страницу сервиса http://localhost:8080/
2. Нажать кнопку "Купить в кредит"
3. Заполнить все поля валидными данными карты с достаточным кредитным лимитом (например, Номер карты - 1111 1111 1111 1111, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123)
4. Нажать кнопку "Продолжить"

<em>Ожидаемый результат: В правом верхнем углу появляется сообщение "Успешно Операция одобрена Банком".</em>

<em>Cценарий 2.2: Отказ в покупке в кредит при оплате картой с валидным номером и недостаточным кредитным лимитом.</em>

Шаги воспроизведения:
1. Открыть главную страницу сервиса http://localhost:8080/
2. Нажать кнопку "Купить в кредит"
3. Заполнить все поля валидными данными карты с недостаточным кредитным лимитом (например, Номер карты - 9999 9999 9999 9999, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123)
4. Нажать кнопку "Продолжить"

<em>Ожидаемый результат: В правом верхнем углу появляется сообщение "Ошибка! Банк отказал в проведении операции".</em>

------------

### Проверка полей для ввода данных

Для тестирования полей для ввода данных необходимо выполнить следующие предусловия:
- пункты 1 и 2 из сценария 1.1 UI для формы "Оплата по карте" 
- пункты 1 и 2 из сценария 2.1 UI для формы "Кредит по данным карты"

Далее необходимо заполнить поля, нажать кнопку "Продолжить" и ожидать результат. 

**Все поля - пустые**

После выполнения предусловий оставить все поля незаполненными и нажать кнопку "Продолжить"

*Данный случай является невалидным для всех полей формы (в этом случае возникают ошибки "Поле обязательно для заполнения")*

**Поле "Номер карты"**

Поле "Номер карты" присутствует в обеих формах: "Оплата по карте" и "Кредит по данным карты" и допускает для ввода только цифры и их количество - 16.

После выполнения предусловий заполнить остальные поля валидными данными: Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123 и нажать кнопку "Продолжить"

*Невалидные данные для поля "Номер карты" (в этом случае возникают ошибки в зависимости от данных - под полем возникает ошибка красным цветом "Неверный формат", "Поле обязательно для заполнения", всплывающее окно в правом верхнем углу "Ошибка! Банк отказал в проведении операции."):*
1. Пустое поле 
2. Номер карты содержит количество цифр менее 16
3. Номер карты не содержится в базе данных банка, например "7777000000000001"

**Поле "Месяц"**

Данное поле принимает номер месяца в формате двух знаков, от 01 до 12, можно ввести только цифры.

После выполнения предусловий заполнить остальные поля валидными данными: Номер карты - 1111 1111 1111 1111, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123 и нажать кнопку "Продолжить"

*Невалидные данные для поля "Месяц" (в этом случае возникают ошибки в зависимости от данных - под полем возникает ошибка красным цветом "Неверный формат", "Поле обязательно для заполнения", "Неверно указан срок действия карты"):*
1. Пустое поле
2. Поле содержит одну цифру (например, 1)
3. Поле содержит двузначное число более 12 (например, 20)
4. Поле содержит нулевое значение (например, 00)

**Поле "Год"**

Данное поле принимает только цифры в формате двух последних цифр

После выполнения предусловий заполнить остальные поля валидными данными: Номер карты - 1111 1111 1111 1111, Месяц - 08, Владелец - Volkov Oleg, CVC/CVV - 123 и нажать кнопку "Продолжить"

*Невалидные данные для поля "Год" (в этом случае возникают ошибки в зависимости от данных - под полем возникает ошибка красным цветом "Неверный формат", "Поле обязательно для заполнения", "Неверно указан срок действия карты", "Истёк срок действия карты"):*
1. Пустое поле
2. Поле содержит одну цифру (например, 1)
3. Поле содержит год ранее текущего (например, 22)
4. Поле содержит нулевое значение (например, 28)
5. Поле содержит год намного позднее текущего (например, 40)

**Поле "Владелец"**
Данное поле принимает на вход фамилию и имя на английском языке.

После выполнения предусловий заполнить остальные поля валидными данными: Номер карты - 1111 1111 1111 1111, Месяц - 08, Год - 24, CVC/CVV - 123 и нажать кнопку "Продолжить"

*Невалидные данные для поля "Владелец" (в этом случае возникают ошибки в зависимости от данных - под полем возникает ошибка красным цветом "Неверный формат", "Поле обязательно для заполнения"):*
1. Пустое поле
2. Поле содержит одно слово на английском языке (например, Volkov)
3. Поле содержит три слова на английском языке (например, Volkov Oleg Semenovich)
4. Поле содержит русские буквы (например, Волков Олег)
5. Поле содержит цифры (например, 9925 8237)
6. Поле содержит спецсимволы (например, !@#)


**Поле "CVC/CVV"**

Данное поле принимает на вход только 3 цифры.

После выполнения предусловий заполнить остальные поля валидными данными: Номер карты - 1111 1111 1111 1111, Месяц - 08, Год - 24, Владелец - Volkov Oleg и нажать кнопку "Продолжить"

*Невалидные данные для поля "CVC/CVV" (в этом случае возникают ошибки в зависимости от данных - под полем возникает ошибка красным цветом "Неверный формат", "Поле обязательно для заполнения"):*
1. Пустое поле
2. Поле содержит одну цифру (например, 3)
3. Поле содержит две цифры (например, 08)
4. Поле содержит три нуля (765)

## Тестирование API

Необходимо проверить через API банковские карты и их статусы в БД. 

Данные для карты со статусом APPROVED: Номер карты - 1111 1111 1111 1111, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123
Данные для карты со статусом DECLINED: Номер карты - 9999 9999 9999 9999, Месяц - 08, Год - 24, Владелец - Volkov Oleg, CVC/CVV - 123

Перечень тестируемых сценариев:
1. При оплате по карте 1111 1111 1111 1111 (обращение к http://localhost:8080/api/v1/pay) ответ сервера - код 200 OK, статус карты APPROVED
2. При оплате по карте 9999 9999 9999 9999 (обращение к http://localhost:8080/api/v1/pay) ответ сервера - код 200 OK, статус карты DECLINED
3. При отправке заявки на кредит по карте 1111 1111 1111 1111 (обращение к http://localhost:8080/api/v1/credit) ответ сервера - код 200 OK, статус карты APPROVED
4. При отправке заявки на кредит по карте 9999 9999 9999 9999 (обращение к http://localhost:8080/api/v1/credit) ответ сервера - код 200 OK, статус карты DECLINED

## 2. Перечень используемых инструментов с обоснованием выбора

- **Java 11**

Язык программирования на котором будет написан проект. По статистике Java является одним из самых популярных языков программирования в мире, это широко распространенный и универсальный язык, на котором написано огромное множество сайтов, приложений и даже софта (для умных домов, например). 

- **IntelliJ IDEA**

Многофункциональная среда разработки, подходящая как новичку, так и профессионалу. IDEA — это мощнейший редактор кода, содержащий в себе много различных встроенных инструментов, интеграцию с системами контроля версий, "умное" автодополнение кода, возможность разработки на различных языках программирования и много другое.

- **Docker**

Через Docker мы будем использовать те приложения, установка и использование которых "в натуральном виде" может повлечь за собой некоторые риски в процессе автоматизациии требует определенных навыков. Через Docker мы развертываем **СУБД MySQL и PostgreSQL**, т.к. заявлено, что сервис покупки туров поддерживает именно эти две СУБД, а также **Node.js** для того, что запускать симуляцию сервисов банка, написанных с помощью Node.js.

- **Gradle**

Системой сборки проекта будет Gradle (в качестве альтернативного варианта можно использовать Maven). 
Причины: быстрота сборки (пример cравнения с Maven [здесь](https://gradle.org/maven-vs-gradle/)), гибкость самой системы, производительность, UX (сравнивая build.gradle и pom.xml я отдаю предпочтение build.gradle за простоту и минимум кода).

- **JUnit5**

Тестовым фреймворком в нашем случае будет JUnit, т.к. это один из наиболее популярный тестовых фреймворков на данный момент и обладает всем нужным функционалом и аннотациями.

- **Selenide**

Фреймворк для тестирования веб-приложений на основе Selenium WebDriver. Его плюсы, в основном, в удобстве — веб-драйвер "из коробки", сокращается время написания тестов и количество строк кода.

- **Lombok**

Lombok — это полезный плагин, аннотации которого позволят опять-таки сократить время написания кода и количество строк кода за счет автоматически генерируемых конструкторов, getter'ов/setter'ов и т.п.

- **Faker**

Плагин, позволяющий генерировать тестовые данные — имя, пароль и т.п. 
Позволит решить проблему, когда необходимо где-то брать тестовые данные, чтобы не хардкодить их в методы.

- **Allure Report**

Для просмотра расширенного отчета о прохождении тестов будем использовать Allure, т.к. в нем заложен значительно больший функционал по сравнению со стандартным отчетом Gradle.

- **Git**

Любому современному проекту будет необходима система контроля версий и Git — это как раз то, что нужно. 
В Git можно откатиться к предыдущему билду, можно вести параллельную разработку через систему веток, есть интеграция с IDEA.

## 3. Перечень и описание возможных рисков при автоматизации

- Технические сложности с настройкой Docker-compose.yml и SUT — возможные проблемы с "поднятием" БД, SUT не запускается и т.п.;

- Проблемы с запуском приложения, подключением БД;

- Изменение структуры страницы (html, css) - недоступность css-селекторов для проверки;

- Некорректность тестовых данных при работе с Faker.

## 4. Интервальная оценка с учётом рисков (в часах)

- Разработка плана тестирования — 8 часов;
- Подготовка необходимых инструментов, написание кода автотестов, рефакторинг кода - 60 часов;
- Подготовка отчетной документации, баг-репортов - 12 часов
- Запас на непредвиденные обстоятельства - 18 часов.

## 5. План сдачи работ

- Готовность автотестов - 10 рабочих дней после утверждения плана и разрешения вопросов;
- Результат работы автотестов - документы по итогам тестирования (отчет по итогам тестирования + баг-репорты) - 3 рабочих дня;
- Подготовка отчёта по автоматизации - 3 рабочих для после проведения всех работ.