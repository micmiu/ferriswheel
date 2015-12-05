<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title>ztree Demo</title>

    <!-- treeviewer-->
    <script type="text/css" rel="stylesheet" src="<c:url value='/static/plugins/ztree/3.5.x/css/zTreeStyle/zTreeStyle.css'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/ztree/3.5.x/js/jquery.ztree.all-3.5.js'/>"></script>
</head>

<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
<SCRIPT LANGUAGE="JavaScript">
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {};
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [
        {
            name: "test1", open: true, children: [
            {name: "test1_1"}, {name: "test1_2"}]
        },
        {
            name: "test2", open: true, children: [
            {name: "test2_1"}, {name: "test2_2"}]
        }
    ];
    $(document).ready(function () {
        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</SCRIPT>