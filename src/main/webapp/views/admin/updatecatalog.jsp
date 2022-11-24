<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<div class="mot">
    <form action="<%=request.getContextPath()%>/CatalogServlet" method="post">
        <table>
            <tr>
                <td> Catalog Id</td>
                <td><input type="number" name="catalogId" value="${catalogupdate.catalogId}" readonly></td>
            </tr>
            <tr>
                <td>Catalog Name</td>
                <td><input type="text" name="catalogName" value="${catalogupdate.catalogName}"></td>
            </tr>
            <tr>
                <td>Catalog Status</td>
                <td>
                    <c:choose>
                        <c:when test="${catalogupdate.catalogStatus}">
                            <input type="radio" name="status" id="active" value="true" checked/><lable for="active">hoat dong</lable>
                            <input type="radio" name="status" id="inactive" value="false"/><labale for="inactive">khong hoat dong</labale>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="status" id="active" value="true"/><lable for="active">hoat dong</lable>
                            <input type="radio" name="status" id="inactive" value="false" checked/><lable for="inactive">khong hoat dong</lable>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="update" name="action">
                </td>
            </tr>
        </table>
    </form>
</div>
<style>
    .mot{
        border: 2px solid black;
        padding: 10px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
    }
    td{
        padding: 2px;
    }
    input{
        padding: 5px;
    }
</style>
</body>
</html>
