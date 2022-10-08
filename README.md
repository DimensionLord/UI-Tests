## Проект тестирования Интернет-банка "Альфы"

### Требования:

- Java 8
- Maven 3.6.3+
- chromedriver, соответсвующий версии Chrome (должен лежать по адресу drivers/chromedriver)

### Команда запуска
mvn clean test

### Генерация отчета
mvn allure:serve

### Параметризация
Управление тестовыми данными происходит через testng.xml


### Описание сценариев

#### Проверка ипотечного калькулятора
- Параметры (все параметры имеют значение по умолчанию):

  - url: адрес страницы с калькулятором
  - programType: тип ипотечной программы
  - minCost: минимальная стоимость объекта
  - maxCost: максимальная стоимость объекта
  - minInitialPercent: минимальный размер первоначального вноса (в процентах от стоимости)
  - maxInitialPercent: максимальный размер первоначального вноса (в процентах от стоимости)
  - minTerm: минимальный срок ипотеки
  - maxTerm: максимальный срок ипотеки

- Шаги
  - Открыть страницу с ипотечным калькулятором
  - Выбрать тип программы (из тестовых данных)
  - Заполнить стоимость объекта (рандомное значение между минимальным и максимальным из тестовых данных)
  - Заполнить сумму первоначального взноса (расчитывается как рандомный процент (в диапазоне от минимального до максимального) от стоимости объекта)
  - Заполнить срок ипотеки (из тестовых данных)
  - Создать график платежей
  - Проверить, что сумма кредита равна разнице между стоимостью объекта и первоначальным взносом
  - Проверить, что срок ипотеки равен введенному ранее

#### Проверка расчета кэшбэка по карте
- Параметры (все параметры имеют значение по умолчанию):

  - url: адрес главной страницы приложения
  - minSum: минимальная размер ежемесячных трат
  - maxSum: максимальный размер ежемесячных трат
  - rate: процентная ставка


- Шаги
  - Открыть главную страницу
  - Перейти к Дебетовым картам
  - Заполнить размер ежемесячных трат (рандомное значение между минимальным и максимальным из тестовых данных)
  - Проверить, что ожидаемый кэшбэк расчитан корректно
  - Проверить, что ставка равна ожидаемой (из тестовых данных)