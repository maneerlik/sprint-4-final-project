<!-- PROJECT LOGO -->
<a name="readme-top"></a>
<div align="center">
   <h3 align="center">Test Scooter</h3>

   <p align="center">
    Учебный проект по автоматизации UI тестирования сервиса аренды самоката.
    <br/>
    <br/>
   </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#tests">Tests</a></li>
    <li><a href="#tech-stack">Tech Stack</a></li>
  </ol>
</details>

## About The Project

Необходимо написать автотесты для учебного сервиса «Яндекс.Самокат» (https://qa-scooter.praktikum-services.ru/). Его разработали специально для студентов.

<b>Основные тестовые сценарии:</b>
1. Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
2. Заказ самоката. Весь флоу позитивного сценария. Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
   Из чего состоит позитивный сценарий:
   Нажать кнопку «Заказать». На странице две кнопки заказа.
   Заполнить форму заказа.
   Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.

<b>Дополнительные тестовые сценарии:</b>
1. Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
2. Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
3. Проверить ошибки для всех полей формы заказа.
4. Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.

Нужно написать тесты с разными данными: минимум два набора. Какие именно данные использовать - на твоё усмотрение.

## Usage

Для выбора браузера, в котором необходимо запустить тесты, в параметрах запуска (Environment variable) передать наименование браузера в формате var=value (н.п. `browser=chrome` или `browser=firefox`).

## Tests
* `ClickOrderButtonsTest` - тестирование кнопок заказа
* `ClickScooterLogoTest` - тестирование логотипа 'Самокат'
* `ClickYandexLogoTest` - тестирование логотипа 'Яндекс'
* `FrequentlyAskedQuestionsTest` - тестирование FAQ
* `IncorrectFillingCustomerInfoTest` - тестирование валидации полей формы заказа
* `CheckErrorNotFoundTrackTest` - тестирование трека несуществующего заказа
* `PlaceAnOrderPositiveTest` - тестирование позитивного флоу заказа

## Tech Stack

[![Java11][java]][javadoc-url]
[![Selenium][selenium]][selenium-url]
[![JUnit4][junit]][junit-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[javadoc-url]: https://docs.oracle.com/en/java/javase/11/docs/api/index.html
[java]: https://img.shields.io/badge/Java_11-FF2D20?style=for-the-badge&logo=oracle&logoColor=white
[selenium-url]: https://www.selenium.dev/documentation/
[selenium]: https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[junit-url]: https://junit.org/junit4/
[junit]: https://img.shields.io/badge/JUnit_4-20232A?style=for-the-badge