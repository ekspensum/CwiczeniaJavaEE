<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pierwszy projekt</title>
</head>
<body><body bgcolor="gray">
<p>HELLO<p/>
<p>Sprawdzenie polskich znaków: ąćęłńż</p>
${param.imie} <br/>
${paramValues.imie[0]} ${paramValues.imie[1]} <br/>
${cookie.nazwaPolaCiastka1.value } <br/>
${cookie.nazwaPolaCiastka2.value } <br/>
${header } <br/>
${headerValues } <br/>
<%-- ${initParam } --%>
<b>${requestScope.nazwa }</b><br/>
<b>Wybrana marka: ${requestScope.wartosc }</b><br/>
${wartosc }
<%-- ${sessionScope }
${applicationScope }
${pageScope }
${pageContext. } --%>
${uzytkownik.idUser } ${uzytkownik.imie } ${uzytkownik.nazwisko }
<p></body><a href="/Pierwszy/witaj">Powitanie</a>
</body>
</html>