<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.system.user'/></title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="role_list"></table>
        <div id="p_role_list"></div>
    </div>
</div>
<script type="text/javascript">
    $("#role_list").jqGrid({
        ajaxGridOptions: {type: "POST"},
        url: '<c:url value="/system/role.do?method=pageQuery"/>',
        datatype: "json",
        width: 800,
        height: '80%',
        autowidth: true,
        colNames: ['ID', '<fmt:message key="system.role.roleName" />', '<fmt:message key="system.role.nodes" />'],
        colModel: [
            {name: 'id', index: 'id', width: 50},
            {name: 'roleName', index: 'roleName', width: 100},
            {name: 'permissionNames', index: 'permissionNames', width: 550}
        ],
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#p_user_list',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption: "<fmt:message key='module.system.role' />"
    });
    $("#role_list").jqGrid('navGrid', '#p_role_list', {edit: false, add: false, del: false});
</script>
