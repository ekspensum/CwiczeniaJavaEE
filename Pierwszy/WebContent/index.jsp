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
${uzytkownik.idUser } ${uzytkownik.imie} ${uzytkownik.imie eq 'Adam' } ${uzytkownik.nazwisko }
<p></body><a href="/Pierwszy/witaj">Powitanie</a><br/>
<!-- Akcje -->
<%-- <%@page import="cwiczenia.dispatch.Uzytkownik" %> --%>
<jsp:include page="tresc.jsp">
	<jsp:param value="Tekst do wyświetlenia" name="doWyswietlenia"/>
</jsp:include><br/>
<jsp:useBean id="aktywny" scope="session" class="cwiczenia.dispatch.Uzytkownik">
<%-- 	<jsp:setProperty name="aktywny" property="imie" value="coś tm"/> --%>
</jsp:useBean>
<jsp:getProperty property="imie" name="aktywny"/>
<%-- 	<jsp:setProperty property="imie" value="JakieśImie" name="aktywny"/> --%>
</body>
</html>