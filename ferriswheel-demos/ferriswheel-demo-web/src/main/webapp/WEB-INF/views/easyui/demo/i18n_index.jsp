<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<html>
<head>
</head>

<body>
<p>
    Locale：${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}
</p>
---------------------------------------------------------
<p>
    jstl tag:
    <fmt:message key="demo.i18n.title"></fmt:message>
</p>
---------------------------------------------------------
<p>
    spring tag:
    <spring:message code="demo.i18n.title"></spring:message>
</p>
---------------------------------------------------------

</body>

</html>
