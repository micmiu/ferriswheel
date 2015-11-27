<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <jsp:include page="header.jsp"/>
    <tiles:useAttribute id="tiles_title" name="title"/>
    <title><fmt:message key="${tiles_title}"/></title>
</head>
<body>
<div id="loginWin"
     style="width: 450px; height: 350px; padding-top: 80px; margin-left: auto; margin-right: auto; vertical-align: middle;">
    <div class="easyui-layout" data-options="fit:true">
        <tiles:useAttribute id="tiles_pos" name="position"/>
        <div
                data-options="region:'center',title:'<fmt:message key="${tiles_pos}" />'"
                style="padding: 5px; background: #eee;">
            <jsp:include page="center.jsp"/>
        </div>
        <div data-options="region:'south'" style="height: 20px;">
            <jsp:include page="south.jsp"/>
        </div>
    </div>
</div>
</body>
</html>