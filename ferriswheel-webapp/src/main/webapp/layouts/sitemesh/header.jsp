<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key="global.text.title"/>
        <sitemesh:title/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-store,no-cache,must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="micmiu.com">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/bootstrap/3.2.0/css/bootstrap.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/bootstrap/3.2.0/css/bootstrap-theme.css'/>" >

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jquery-validation/1.9.0/validate.css'/>">

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jquery-ui/1.10.4/css/jquery-ui-1.10.4.custom.min.css'/>">

    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/jqgrid/4.6.0/css/ui.jqgrid.css'/>">

    <!-- jQuery -->
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery/jquery-1.8.0.min.js'/>"></script>

    <!-- bootstrap -->
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap/3.2.0/js/bootstrap.js'/>"></script>

    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/jquery.validate.min.js'/>"></script>

    <!-- jquery-ui -->
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-ui/1.10.4/js/jquery-ui-1.10.4.custom.min.js'/>"></script>

    <!-- jqGrid -->
    <script type="text/javascript" src="<c:url value='/static/plugins/jqgrid/4.6.0/js/jquery.jqGrid.min.js'/>"></script>


    <c:set var="LOCALE" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}"/>
    <c:if test="${empty LOCALE}">
        <c:set var="LOCALE" value="zh_CN"/>
    </c:if>
    <script type="text/javascript" src="<c:url value='/static/plugins/jquery-validation/1.9.0/messages_${LOCALE}.js' />"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/jqgrid/4.6.0/js/i18n/grid.locale-${LOCALE}.js' />"></script>


    <script type="text/javascript">
        $(document).ready(function () {
            $('#lang a[data-value="${LOCALE}"]').find('i').addClass('icon-ok');
            $('#lang a').click(function (e) {
                e.preventDefault();
                current_lang = $(this).attr('data-value');
                //changeLang(current_lang);
            });
            function changeLang(lang) {
                $.ajax({
                    type: "post",
                    url: '',
                    data: "locale=" + lang,
                    async: true,
                    error: function (data, error) {
                        alert("change lang error!");
                    },
                    success: function (data) {
                        window.location.reload();
                    }
                });
            }
        });
    </script>
    <sitemesh:head/>
    <!-- The fav icon
   <link rel="shortcut icon" href="img/favicon.ico">
    -->
</head>

