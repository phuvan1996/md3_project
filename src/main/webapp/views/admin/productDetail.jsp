<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<div>
    <div><img src="<%=request.getContextPath()%>/images/${pro.productImage}" width="600px" height="600px"/></div>
    <div>
        <c:forEach items="${pro.listImageUrl}" var="link">
            <img src="<%=request.getContextPath()%>/images/${link}" width="200px" height="200px"/>
        </c:forEach>
    </div>
    <p>${pro.title}</p>
    <p>${pro.price}VNĐ</p>
    <p>${pro.description}</p>
</div>
</body>
</html>
