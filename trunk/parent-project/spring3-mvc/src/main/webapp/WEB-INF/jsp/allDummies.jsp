<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <div id="content">
            <c:choose>
            	<c:when test="${requestScope.dummies != null}">
            		<table>
            			<tr><th>Nombre</th></tr>
            		<c:forEach var="dummy" items="${dummies}">	
            			<tr><td><c:out value="${dummy.name}" /><td></tr>
            		</c:forEach>
            		</table>
            	</c:when>
            	<c:otherwise>No hay elementos</c:otherwise>
            </c:choose>
            <form action="newDummy">
            	<input type="submit" value="Nuevo dummy">
            </form>
        </div>
    </body>
</html>