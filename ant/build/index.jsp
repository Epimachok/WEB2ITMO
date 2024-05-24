<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <title>Lab 2</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/style.css" />
    <script src="./js/jquery-3.6.0.js" defer></script>
    <script src="./js/index_script.js" defer type="module"></script>
    <script src="./js/canvas.js" defer type="module"></script>
    <jsp:useBean id="tablebean" scope="application" class="beans.Tablebean"/>
</head>

<body>
<div id="header">
    <div class="author-tg">
        <a href="https://t.me/Epimachok">
            <p>@Epimachok</p>
        </a>
        <p>Stukun Dmitry</p>
    </div>
</div>
<div class="content">
    <table name = content-table>
        <tbody>
        <tr class = "author">
            <td>
                <div class="author">
                    <div class="author-block">Выполнил: Стукун Дмитрий Александрович</div>
                    <div class="author-block">s335188</div>
                    <div class="author-block">P32301</div>
                    <div class="author-block">Вариант 3115</div>
                </div>
            </td>
        </tr>
        <tr class="task">
            <td class = "text" colspan="2">
                Разработать веб-приложение на базе сервлетов и JSP, определяющее попадание точки на координатной плоскости в заданную область.

                Приложение должно быть реализовано в соответствии с шаблоном MVC и состоять из следующих элементов:

                ControllerServlet, определяющий тип запроса, и, в зависимости от того, содержит ли запрос информацию о координатах точки и радиусе, делегирующий его обработку одному из перечисленных ниже компонентов. Все запросы внутри приложения должны передаваться этому сервлету (по методу GET или POST в зависимости от варианта задания), остальные сервлеты с веб-страниц напрямую вызываться не должны.
                AreaCheckServlet, осуществляющий проверку попадания точки в область на координатной плоскости и формирующий HTML-страницу с результатами проверки. Должен обрабатывать все запросы, содержащие сведения о координатах точки и радиусе области.
                Страница JSP, формирующая HTML-страницу с веб-формой. Должна обрабатывать все запросы, не содержащие сведений о координатах точки и радиусе области.

                Разработанная страница JSP должна содержать:

                "Шапку", содержащую ФИО студента, номер группы и номер варианта.
                Форму, отправляющую данные на сервер.
                Набор полей для задания координат точки и радиуса области в соответствии с вариантом задания.
                Сценарий на языке JavaScript, осуществляющий валидацию значений, вводимых пользователем в поля формы.
                Интерактивный элемент, содержащий изображение области на координатной плоскости (в соответствии с вариантом задания) и реализующий следующую функциональность:
                Если радиус области установлен, клик курсором мыши по изображению должен обрабатываться JavaScript-функцией, определяющей координаты точки, по которой кликнул пользователь и отправляющей полученные координаты на сервер для проверки факта попадания.
                В противном случае, после клика по картинке должно выводиться сообщение о невозможности определения координат точки.
                После проверки факта попадания точки в область изображение должно быть обновлено с учётом результатов этой проверки (т.е., на нём должна появиться новая точка).
                Таблицу с результатами предыдущих проверок. Список результатов должен браться из контекста приложения, HTTP-сессии или Bean-компонента в зависимости от варианта.

                Страница, возвращаемая AreaCheckServlet, должна содержать:

                Таблицу, содержащую полученные параметры.
                Результат вычислений - факт попадания или непопадания точки в область.
                Ссылку на страницу с веб-формой для формирования нового запроса.

                Разработанное веб-приложение необходимо развернуть на сервере WildFly. Сервер должен быть запущен в standalone-конфигурации, порты должны быть настроены в соответствии с выданным portbase, доступ к http listener'у должен быть открыт для всех IP.

            </td>

        </tr>
        <tr class = "data">
            <td name = surface>
                <canvas id="area" width="300" height="300"></canvas>
                <div name="ODZ">
                    Изменение X: CheckBox {'-3','-2','-1','0','1','2','3','4','5'}<br />
                    Изменение Y: Text {-5 ... 5}<br />
                    Изменение R: Select {1, 2, 3, 4, 5}
                </div>
            </td>
            <td>
                <fieldset id="input-block">
                    <legend>Выбор значений</legend>
                    <div class="x">
                        <label>X</label>
                        <div class="x-checkbox-head" name="x_checkbox" id="x-val">
                            <label for="x-4">-3</label><input type="checkbox" id="x-3" name="x" class="x-checkbox" value="-3" checked="checked">
                            <label for="x-3">-2</label><input type="checkbox" id="x-2" name="x" class="x-checkbox" value="-2">
                            <label for="x-2">-1</label><input type="checkbox" id="x-1" name="x" class="x-checkbox" value="-1">
                            <label for="x-1">0</label><input type="checkbox" id="x0" name="x" class="x-checkbox" value="0">
                            <label for="x0">1</label><input type="checkbox" id="x+1" name="x" class="x-checkbox" value="1">
                            <label for="x+1">2</label><input type="checkbox" id="x+2" name="x" class="x-checkbox" value="2">
                            <label for="x+2">3</label><input type="checkbox" id="x+3" name="x" class="x-checkbox" value="3">
                            <label for="x+3">4</label><input type="checkbox" id="x+4" name="x" class="x-checkbox" value="4">
                            <label for="x+4">5</label><input type="checkbox" id="x+5" name="x" class="x-checkbox" value="5">
                        </div>
                    </div>
                    <div class="y">
                        <label for="y-val">Y</label><input id="y-val" type="text" name="y" autocomplete="off" placeholder="Число от -5 до 5"
                                                           size="25" />
                    </div>
                    <div class="z">
                        <label for="r-val" >R</label>
                        <select name = "r" id = "r-val">
                            <option disabled>R</option>
                            <option value = 1>1</option>
                            <option value = 2>2</option>
                            <option selected value = 3>3</option>
                            <option value = 4>4</option>
                            <option value = 5>5</option>
                        </select>

                    </div>
                </fieldset>
                <button id="submit" name="submit" class="submit">Проверить</button>
            </td>
        </tr>
        <tr>
            <td>
                <table class="resul-table" id="res-tb">
                    <tbody>
                    <tr>
                        <th colspan="4" class="bordered">Результаты попаданий</th>
                    </tr>
                    <tr>
                        <td colspan="3">Координаты</td>
                        <td rowspan="2">Результат</td>
                    </tr>
                    <tr>
                        <td>X</td>
                        <td>Y</td>
                        <td>R</td>
                    </tr>
                    <%for(int i = 0; i<tablebean.getR().size();i++){%>
                    <%String x = "<tr>"+"<td id=\"x"+Integer.toString(i)+"\">"+ tablebean.getX().get(i).toString() +
                            "</td>"+"<td id=\"y"+Integer.toString(i)+"\">"+tablebean.getY().get(i).toString()+
                            "</td>"+"<td id=\"r"+Integer.toString(i)+"\">"+tablebean.getR().get(i).toString()+
                            "</td>"+"<td id=\"a"+Integer.toString(i)+"\">"+tablebean.getAns().get(i)+
                            "</td>"+"</tr>";%>
                    <%=x%>
                    <%}%>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>

</html>