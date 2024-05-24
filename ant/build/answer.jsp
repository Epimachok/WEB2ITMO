<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Answer</title>
    <link rel="stylesheet" href="./css/ansstyle.css" />
    <jsp:useBean id="ansbean" scope="application" class="beans.AnswerBean"/>
</head>
<body>
<table class="resul-table" id="res-tb">
        <tbody>
        <tr>
            <th colspan="4" class="bordered">Результат попадания</th>
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
        <tr>
        <td><%=ansbean.getX()%></td>
        <td><%=ansbean.getY()%></td>
        <td><%=ansbean.getR()%></td>
        <td><%=ansbean.getAns()%></td>
        </tr>
        </tbody>
</table>
<a href="/area">Отправить новый запрос</a>
</body>
</html>
