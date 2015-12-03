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
    template += "<div> <fmt:message key='system.user.password' /><sup>*</sup>: </div><div>{password} </div>";
    template += "<div> <fmt:message key='system.user.passwordConfirm' /><sup>*</sup>: </div><div>{passwordConfirm} </div>";
    template += "<div> <fmt:message key='system.user.email' />: </div><div>{email} </div>";
    template += "<div> <fmt:message key='system.user.other' />: </div><div>{other} </div>";
    template += "<div> <fmt:message key='system.role.roleName' /> <sup>*</sup>:</div><div>{roleId} </div>";
    template += "<hr style='width:100%;'/>";
    template += "<div> {sData} {cData}  </div></div>";

    var templateEdit = "<div style='margin-left:15px;'><div> <fmt:message key="system.user.loginName" /> <sup>*</sup>:</div><div> {loginName} </div>";
    templateEdit += "<div> <fmt:message key='system.user.name' />: </div><div>{name} </div>";
    templateEdit += "<div> <fmt:message key='system.user.email' />: </div><div>{email} </div>";
    templateEdit += "<div> <fmt:message key='system.user.other' />: </div><div>{other} </div>";
    templateEdit += "<div> <fmt:message key='system.role.roleName' /> <sup>*</sup>:</div><div>{roleId} </div>";
    templateEdit += "<hr style='width:100%;'/>";
    templateEdit += "<div> {sData} {cData}  </div></div>";
    <c:set var="roleIdValue" value=":"/>
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
            {label: '<fmt:message key="system.user.password" />', name: 'password', width: 100,hidden:true,
                editable: true,editrules: {required: true}, edittype: "password"},
            {label: '<fmt:message key="system.user.passwordConfirm" />', name: 'passwordConfirm', width: 100,hidden:true,
                editable: true,editrules: {edithidden: true, custom:true,  custom_func: customPassCheck}, edittype: "password"},
            {label: '<fmt:message key="system.user.email" />', name: 'email', width: 150, editable: true, editrules: {required:false,email: true}},
            {label: '<fmt:message key="system.user.other" />', name: 'other', width: 200, editable: true},
            {label: '<fmt:message key="system.role.roleName" />',name: 'roleName', width: 100},
            {label: '<fmt:message key="system.role.roleName" />', name: 'roleId',editable: true,hidden:true,
                editrules: {required: true},
                edittype: "select",
                editoptions: {
                    //不设置value,用dataInit会导致bug：select元素生成后id name等属性没有值
                    value: "${roleIdValue}"
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
                template: templateEdit,
                closeAfterEdit: true,
                errorTextFormat: function (data) {
                    return '<fmt:message key="global.msg.error" />: ' + data.responseText
                }
            },
            {
                template: template,
                top: 10,
                left: 300,
                closeAfterAdd: true,
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
    function customPassCheck(cellvalue, cellname) {
        var passCheckVal = $("#password").val();
        if ((cellvalue == "" && passCheckVal == "") ||
                cellvalue == passCheckVal) {
            return [true, ""];
        }
        return [false, '<fmt:message key="system.user.passwd.notmatch" />'];
    }
</script>
