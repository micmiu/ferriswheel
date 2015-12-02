<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<head>
    <title><fmt:message key='module.system.user'/></title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="user_list"></table>
        <div id="p_user_list"></div>
    </div>
</div>
<script type="text/javascript">
    $("#user_list").jqGrid({
        url:'<c:url value="/system/user.do?method=pageQuery"/>',
        mtype:  'POST',
        datatype: "json",
        width: 800,
        autowidth: true,
        colNames:['ID','<fmt:message key="system.user.loginName" />', '<fmt:message key="system.user.name" />', '<fmt:message key="system.user.email" />','<fmt:message key="system.user.other" />','<fmt:message key="system.role.roleName" />'],
        colModel:[
            {name:'id',index:'id', width:55},
            {name:'loginName',index:'loginName', width:90},
            {name:'name',index:'name', width:100},
            {name:'email',index:'email', width:80},
            {name:'other',index:'ohter', width:80},
            {name:'roleName',index:'roleName', width:80}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#p_user_list',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption:"<fmt:message key='module.system.user' />"
    });
    $("#user_list").jqGrid('navGrid','#p_user_list',{edit:false,add:false,del:false});
</script>
