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
<div id="main-layout" class="easyui-layout" fit="true">
    <div data-options="region:'north',split:true" style="height: 50px;">
        <jsp:include page="north.jsp"/>
    </div>
    <div data-options="region:'west',title:'<fmt:message key="global.text.navi" />',split:true"
         style="width: 200px;">
        <jsp:include page="west.jsp"/>
    </div>
    <div data-options="region:'east',split:true,collapsed:true" title="<fmt:message key="global.text.detail" />"
         style="width: 300px;">
        <jsp:include page="east.jsp"/>
    </div>
    <tiles:useAttribute id="tiles_pos" name="position"/>
    <div data-options="region:'center',title:'<fmt:message key="${tiles_pos}" />'"
         style="padding: 5px; background: #eee;">
        <jsp:include page="center.jsp"/>
    </div>
    <div data-options="region:'south'" style="height: 20px;">
        <jsp:include page="south.jsp"/>
    </div>
</div>
</body>
</html>