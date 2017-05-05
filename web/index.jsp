<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" type="text/css" href="resources/css/base.css">
    <script src="resources/js/leftPanel.js"></script>
</head>
<body>

<jsp:include page="frag/leftPanel.jsp"/>

<main>
    <div id="indexPanel">
        <c:forEach var="topic" items="${topics}">
            <a class="topic" href="Controller?action=topic&topic=${topic.name}">
                <div class="img_topic"></div>
                <p><c:out value="${topic.name}"/></p>
            </a>
        </c:forEach>
    </div>
</main>

</body>
</html>