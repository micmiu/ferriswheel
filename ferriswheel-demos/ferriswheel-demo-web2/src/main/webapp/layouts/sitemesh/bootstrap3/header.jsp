<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key="global.project.name"/> - <sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="micmiu.com">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <c:set var="LOCALE" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}" scope="application"/>
    <c:if test="${empty LOCALE}">
        <c:set var="LOCALE" value="zh_CN" scope="application"/>
    </c:if>

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/css/ferriswheel.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/bootstrap/3.2.0/css/bootstrap.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/bootstrap/3.2.0/css/bootstrap-theme.css'/>" >
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jquery-validation/1.9.0/validate.css'/>">

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jqgrid/5.0.1/css/ui.jqgrid-bootstrap.css'/>">
    <!-- jQuery -->
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery/jquery-1.8.0.min.js'/>"></script>
    <!-- bootstrap -->
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap/3.2.0/js/bootstrap.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/jquery.validate.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/messages_${LOCALE}.js' />"></script>
    <!-- jqGrid -->
    <script type="text/javascript" src="<c:url value='/static/plugins/jqgrid/5.0.1/js/i18n/grid.locale-${LOCALE}.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/jqgrid/5.0.1/js/jquery.jqGrid.min.js'/>"></script>

    <script type="text/css" rel="stylesheet" src="<c:url value='/static/plugins/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.css'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap-datepicker/1.5.0/locales/bootstrap-datepicker.${LOCALE}.min.js' />"></script>

    <!-- treeviewer-->
    <script type="text/css" rel="stylesheet" src="<c:url value='/static/plugins/bootstrap-treeview/1.2.0/css/bootstrap-treeview.css'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap-treeview/1.2.0/js/bootstrap-treeview.js'/>"></script>

    <script type="text/javascript">
        $.jgrid.defaults.width = 780;
        $.jgrid.defaults.responsive = true;
        $.jgrid.defaults.styleUI = 'Bootstrap';
        $.fn.datepicker.defaults.language = '${LOCALE}';
    </script>
    <sitemesh:head/>
    <!-- The fav icon
   <link rel="shortcut icon" href="img/favicon.ico">
    -->
</head>

