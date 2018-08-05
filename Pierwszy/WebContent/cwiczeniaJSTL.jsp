<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - ćwiczenia</title>
</head>
<body><body bgcolor="gray">
	
<p>${users[0].imie }</p>
	
<!-- jeśli imie = null to wyswietli się wartość domyślna -->
<!-- escapXml - dodaje znaki ucieczkowe -->
<c:out value="${users[0].imie }" default="Brak imienia" escapeXml="true"></c:out>
	<br/>
	<c:forEach items="${users}" var="k" begin="1">
	<p>	${k.imie } ${k.nazwisko } ${k.idUser }</p> 
	</c:forEach>

<c:forTokens items="" delims=""></c:forTokens>

<c:if test="${users[1].imie eq 'Bonifacy' }">
<%-- 	<c:out value="User nr 1 ma na imię Bonifacy"></c:out> --%>
	<p>User nr 1 ma na imię Bonifacy</p>
</c:if>	

<c:set var="nazwiskoUsera" scope="session" value="${users[2].nazwisko }" ></c:set>
${nazwiskoUsera }
<br>
<p> Dotychczasowe imię: ${users[2].imie }</p>
<c:set target="${users[2]}" property="imie" value="Anonim"></c:set>
<p>Obecne imie: ${users[2].imie }</p>
<c:catch var="wyjatek">
<c:set target="${users[2]}" property="pesel" value="569856985"></c:set>
</c:catch>
${wyjatek }

<c:choose>
	<c:when test="${users[1].nazwisko eq 'Kowalski' }">
	<p>Podane nazwisko to: Kowalski.</p>
	</c:when>
	<c:when test="${users[1].nazwisko eq 'Krakowska' }">
	<p>Podane nzwisko to: Krakowska</p>
	</c:when>
	<c:otherwise>
		<p>Żadne z powyższych.</p>
	</c:otherwise>
</c:choose>

<c:url value="/witaj">
	<c:param name="id" value="13"></c:param>
</c:url>

<c:url scope="request" var="zmienna" value="/witaj">
	<c:param name="id" value="23"></c:param>
</c:url>
${zmienna}

<c:import url="formularze" var="strona" scope="request"></c:import>
${strona }
<!-- Funkcje działają tak samo jak te z klasy String -->
<p>Rozmiar tablicy users: ${fn:length(users) }</p>

<fmt:formatNumber value="${kwota}" type="currency" minIntegerDigits="5" maxFractionDigits="6" minFractionDigits="3" currencyCode="PLN"></fmt:formatNumber>
<br/>
<fmt:formatDate value="${data }" type="both" dateStyle="short" timeStyle="long" />
<br/>
<fmt:formatDate value="${data }" type="both" pattern="yyy-MM-dd HH:mm" />

</body>
</html>