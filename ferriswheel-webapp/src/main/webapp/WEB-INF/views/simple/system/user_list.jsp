<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<head>
    <title><fmt:message key='module.menu.user'/></title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="user_list"></table>
        <div id="p_user_list"></div>
    </div>
</div>
<script type="text/javascript">
    $("#user_list").jqGrid({
        ajaxGridOptions : {type:"POST"},
        url:'<c:url value="/system/user.do?method=queryListData4json"/>',
        datatype: "json",
        colNames:['No','userID', 'userName', 'role','createDate'],
        colModel:[
            {name:'id',index:'id', width:55},
            {name:'userID',index:'userID', width:90},
            {name:'userName',index:'userName', width:100},
            {name:'role',index:'role', width:80},
            {name:'createDate',index:'createDate', width:80,align:"right"}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#p_user_list',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption:"User List"
    });
    $("#user_list").jqGrid('navGrid','#p_user_list',{edit:false,add:false,del:false});
</script>
