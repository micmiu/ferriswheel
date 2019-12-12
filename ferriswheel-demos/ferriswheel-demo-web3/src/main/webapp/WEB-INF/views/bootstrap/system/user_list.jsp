<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.system.user'/></title>
</head>
<div class="row">
    <div class="col-xs-12">
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control search-query" name="mulitsearch" data-values="OR_cn_loginName_name_email" placeholder="登录名、用户名、邮箱"/>
            </div>
            <button type="submit" class="btn btn-sm btn-success">查询</button>
            <button type="reset" class="btn btn-sm">重置</button>
        </form>

    </div>
    <div class="col-xs-12">
        <table id="user_list"></table>
        <div id="user_list_pager"></div>
    </div>
</div>

<script type="text/javascript">
    var jqgrid_id = "#user_list";
    var jqgrid_page = "#user_list_pager";
    <c:set var="roleIdValue" value=":"/>
    <c:forEach var="rolevo" items="${roleList}">
    <c:set var="roleIdValue" value="${roleIdValue};${rolevo.id}:${rolevo.roleName}"/>
    </c:forEach>
    console.log("------");
    $(jqgrid_id).jqGrid({
        //caption: "<fmt:message key='module.system.user' />",
        url: '<c:url value="/system/user.do?method=pageQuery"/>',
        editurl: '<c:url value="/system/user.do"/>',
        mtype: 'POST',
        datatype: "json",
        autowidth: true,
        height: 210,
        colModel: [
            {label: 'ID', name: 'id', width: 50, editable: false, search: false},
            {
                label: '<fmt:message key="system.user.loginName" />', name: 'loginName', width: 100,
                editable: true, editrules: {required: true},
                searchoptions: {
                    sopt: ["cn", 'eq', 'ne']
                }
            },
            {
                label: '<fmt:message key="system.user.name" />', name: 'name', width: 100, editable: true,
                searchoptions: {
                    sopt: ["cn", 'eq', 'ne']
                }
            },
            {
                label: '<fmt:message key="system.user.password" />', name: 'password', width: 100, hidden: true,
                editable: true, editrules: {edithidden: true, required: true}, edittype: "password", search: false
            },
            {
                label: '<fmt:message key="system.user.passwordConfirm" />',
                name: 'passwordConfirm',
                width: 100,
                hidden: true,
                editable: true,
                formoptions:{},
                editrules: {edithidden: true, custom: true, custom_func: customPassCheck},
                edittype: "password",
                search: false
            },
            {
                label: '<fmt:message key="system.user.email" />',
                name: 'email', width: 150, editable: true,
                search: true,
                searchoptions: {
                    sopt: ['cn', 'eq', 'ne']
                },
                editrules: {required: false, email: true}
            },
            {label: '<fmt:message key="system.role.roleName" />', name: 'roleName', width: 100, search: false,hidden: true},
            {
                label: '<fmt:message key="system.role.roleName" />', name: 'roleId', editable: true, search: true,
                editrules: {required: true},
                edittype: "select",
                editoptions: {
                    //不设置value,用dataInit会导致bug：select元素生成后id name等属性没有值
                    value: "${roleIdValue}"
                },
                formatter:function(cellvalue, options, cell){
                    return cell['roleName'];
                },
                stype:"select",
                searchoptions:{
                    value:  "${roleIdValue}"
                }
            },
            {
                label: '<fmt:message key="system.user.other" />',
                name: 'other',
                width: 200,
                editable: true,
                search: false
            }
        ],
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#user_list_pager',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc"
    });
    $("#user_list").navGrid('#user_list_pager',
            {
                edit: true,
                add: true,
                del: true,
                search: true,
                refresh: false,
                view: false,
                position: "left",
                cloneToTop: false
            },
            {
                closeAfterEdit: true,
                beforeShowForm: function(form){
                    $(form).find("tr[id='tr_password']").remove();
                    $(form).find("tr[id='tr_passwordConfirm']").remove();
                },
                errorTextFormat: function (data) {
                    return '<fmt:message key="global.msg.error" />: ' + data.responseText
                }
            },
            {
                top: 10,
                left: 300,
                closeAfterAdd: true,
                serializeEditData: function (data) {
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
    $(jqgrid_id).jqGrid('filterToolbar', {searchOperators: true, stringResult: true});
    $("form.navbar-form").bind("submit", function () {
        var filtersObj;
        $(this).find("input[name='mulitsearch']").each(function (i) {
            var val = $.trim($(this).val());
            var groupOp = "OR";
            var op = "cn";
            var rules = [];
            var searchFields = $(this).attr("data-values");
            $.each(searchFields.split("_"), function (i, n) {
                if (i == 0) {
                    groupOp = n;
                } else if (i == 1) {
                    op = n;
                } else {
                    rules.push({"field": n, "op": op, "data": val});
                }
            });
            filtersObj = {"groupOp": groupOp, "rules": rules};
        });
        $(jqgrid_id).jqGrid('setGridParam', {postData: {'filters': JSON.stringify(filtersObj)}}).trigger("reloadGrid");
        return false;
    });
    $("form.navbar-form").bind("reset", function () {
        $(this).find("input[name='mulitsearch']").each(function () {
            $(this).val('');
        });
        $(jqgrid_id).jqGrid('setGridParam', {postData: {'filters': ''}}).trigger("reloadGrid");
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
