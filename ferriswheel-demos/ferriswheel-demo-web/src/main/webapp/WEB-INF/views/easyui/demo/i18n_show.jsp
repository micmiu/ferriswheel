<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<html>
<head>
</head>
<body>
<p>jstl tag:
    <fmt:message key="demo.i18n.title"></fmt:message>
</p>
---------------------------------------------------------
<p>spring tag:
    <spring:message code="demo.i18n.title"></spring:message>
</p>
</body>

</html>
