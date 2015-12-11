<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <link rel="Bookmark"  type="image/x-icon" href="<c:url value='/static/images/favicon.ico'/>"/>
    <link rel="icon"  type="image/x-icon" href="<c:url value='/static/images/favicon.ico'/>" />
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/static/images/favicon.ico'/>" />

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/css/default.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jquery-validation/1.9.0/validate.css'/>"/>

    <script type="text/javascript" src="<c:url value='/static/plugins/jquery/jquery-1.8.0.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/i18n/jquery.i18n.properties-min-1.0.9.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/jquery.validate.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/My97DatePicker/WdatePicker.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/easyui/1.3.2/jquery.easyui.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/easyui/MM.Ex.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/easyui/MM.utils.js'/>"></script>
    <c:if test="${empty THEME}"><c:set var="THEME" value="default" scope="application"/></c:if>
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/easyui/1.3.2/themes/${THEME}/easyui.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/easyui/1.3.2/themes/icon.css'/>"/>

    <c:set var="LOCALE" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}"/>
    <c:choose>
        <c:when test="${empty LOCALE}">
            <c:set var="LOCALE" value="zh_CN" scope="application"/>
        </c:when>
        <c:otherwise>
            <c:set var="LOCALE" value="${LOCALE}" scope="application"/>
        </c:otherwise>
    </c:choose>
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/messages_${LOCALE}.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/easyui/1.3.2/locale/easyui-lang-${LOCALE}.js'/>"></script>

</head>