<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title>ztree Demo</title>

    <!-- ztree -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/ztree/3.5.x/css/zTreeStyle/zTreeStyle.css'/>">
    <script type="text/javascript" src="<c:url value='/static/plugins/ztree/3.5.x/js/jquery.ztree.all-3.5.min.js'/>"></script>
</head>
<div class="row">
    <div class="col-xs-4">
        <ul id="ztree_demo1" class="ztree"></ul>
    </div>
    <div class="col-xs-4">
        <ul id="ztree_demo2" class="ztree"></ul>
    </div>
    <div class="col-xs-4">
        <ul id="ztree_demo3" class="ztree"></ul>
    </div>
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

    var setting2 = {
        check: {
            enable: true,
            chkboxType: { "Y": "ps", "N": "ps" }
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    var zNodes2 = [
        {id: 1, pId: 0, name: "随意勾选 1", open: true},
        {id: 11, pId: 1, name: "随意勾选 1-1", open: true},
        {id: 111, pId: 11, name: "随意勾选 1-1-1"},
        {id: 112, pId: 11, name: "随意勾选 1-1-2"},
        {id: 12, pId: 1, name: "随意勾选 1-2", open: true},
        {id: 121, pId: 12, name: "随意勾选 1-2-1"},
        {id: 122, pId: 12, name: "随意勾选 1-2-2"},
        {id: 2, pId: 0, name: "随意勾选 2", checked: true, open: true},
        {id: 21, pId: 2, name: "随意勾选 2-1"},
        {id: 22, pId: 2, name: "随意勾选 2-2", open: true},
        {id: 221, pId: 22, name: "随意勾选 2-2-1", checked: true},
        {id: 222, pId: 22, name: "随意勾选 2-2-2"},
        {id: 23, pId: 2, name: "随意勾选 2-3"}
    ];

    var setting3 = {
        check: {
            enable: true,
            chkboxType: { "Y": "ps", "N": "ps" }
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };

    var zNodes3;

    $(document).ready(function () {
        zTreeObj = $.fn.zTree.init($("#ztree_demo1"), setting, zNodes);
        zTreeObj2 = $.fn.zTree.init($("#ztree_demo2"), setting2, zNodes2);

        $.ajax({
            async : false,
            cache:false,
            type: 'POST',
            dataType : "json",
            url: "<c:url value='/system/role.do?method=getPermTree'/>",
            error: function () {//请求失败处理函数
                alert('请求失败');
            },
            success:function(data){
                console.log(data);
                zNodes3 = data;
            }
        });
        zTreeObj3 = $.fn.zTree.init($("#ztree_demo3"), setting3, zNodes3);
    });
</SCRIPT>