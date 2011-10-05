<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <div id="content">
            <form name="addDummy" action="addDummy" method="post">
            	<label>Nombre</label>
            	<input type="hidden" name="id" id="id" />
            	<input type="text" name="name" id="name" />
            	<input type="submit" value="Guardar">
            </form>
        </div>
    </body>
</html>