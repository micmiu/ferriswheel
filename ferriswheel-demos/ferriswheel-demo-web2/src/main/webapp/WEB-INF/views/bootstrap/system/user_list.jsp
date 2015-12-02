<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.system.user'/></title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="user_list"></table>
        <div id="user_list_pager"></div>
    </div>
</div>

<script type="text/javascript">
    var template = "<div style='margin-left:15px;'><div> <fmt:message key="system.user.loginName" /> <sup>*</sup>:</div><div> {loginName} </div>";
    template += "<div> <fmt:message key='system.user.name' />: </div><div>{name} </div>";
    template += "<div> <fmt:message key='system.user.email' />: </div><div>{email} </div>";
    template += "<div> <fmt:message key='system.user.other' />: </div><div>{other} </div>";
    template += "<div> <fmt:message key='system.role.roleName' /> <sup>*</sup>:</div><div>{roleId} </div>";
    template += "<hr style='width:100%;'/>";
    template += "<div> {sData} {cData}  </div></div>";
    <c:set var="roleIdValue" value="'':选择"/>
    <c:forEach var="rolevo" items="${roleList}">
    <c:set var="roleIdValue" value="${roleIdValue};${rolevo.id}:${rolevo.roleName}"/>
    </c:forEach>
    $("#user_list").jqGrid({
        url: '<c:url value="/system/user.do?method=pageQuery"/>',
        editurl: '<c:url value="/system/user.do"/>',
        mtype: 'POST',
        datatype: "json",
        autowidth: true,
        height: 250,
        colModel: [
            {label: 'ID', name: 'id', width: 50,editable: false},
            {
                label: '<fmt:message key="system.user.loginName" />',
                name: 'loginName',
                width: 100,
                editable: true,
                editrules: {required: true}
            },
            {label: '<fmt:message key="system.user.name" />', name: 'name', width: 100, editable: true},
            {label: '<fmt:message key="system.user.email" />', name: 'email', width: 150, editable: true, editrules: {required:false,email: true}},
            {label: '<fmt:message key="system.user.other" />', name: 'other', width: 200, editable: true},
            {label: '<fmt:message key="system.role.roleName" />',name: 'roleName', width: 100},
            {label: '<fmt:message key="system.role.roleName" />', name: 'roleId',editable: true,hidden:true,
                editrules: {required: true},
                edittype: "select",
                editoptions: {
                    value: ":",//不设置value会导致bug：select元素生成后id name等属性没有值
                    dataInit:function (element) {
                        <c:forEach var="rolevo" items="${roleList}">
                        $(element).append("<option value='${rolevo.id}'>${rolevo.roleName}</option>");
                        </c:forEach>
                    }

                }
            }
        ],
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#user_list_pager',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption: "<fmt:message key='module.system.user' />"
    });
    $("#user_list").navGrid('#user_list_pager',
            { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
            {
                template: template,
                errorTextFormat: function (data) {
                    return '<fmt:message key="global.msg.error" />: ' + data.responseText
                }
            },
            {
                template: template,
                serializeEditData: function(data) {
                    return $.param($.extend({}, data, {id: ''}));
                },
                errorTextFormat: function (data) {
                    return '<fmt:message key="global.msg.error" />: ' + data.responseText
                }
            },
            {
                errorTextFormat: function (data) {
                    return '<fmt:message key="global.msg.error" />: ' + data.responseText
                }
            });
</script>
