<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.system.user'/></title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/ztree/3.5.x/css/zTreeStyle/zTreeStyle.css'/>">
    <script type="text/javascript" src="<c:url value='/static/plugins/ztree/3.5.x/js/jquery.ztree.all-3.5.min.js'/>"></script>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="role_list"></table>
        <div id="role_list_pager"></div>
    </div>
</div>
<script type="text/javascript">
    var zTreeObj;
    var setting = {
        check: {
            enable: true,
            chkboxType: {"Y": "ps", "N": "ps"}
        },
        data: {
            simpleData: {
                enable: true
            }
        }
    };
    var zNodes;
    $.ajax({
        async: false,
        cache: false,
        type: 'POST',
        dataType: "json",
        url: "<c:url value='/system/role.do?method=getPermTree'/>",
        error: function () {//请求失败处理函数
            alert('请求失败');
        },
        success: function (data) {
            //console.log(data);
            zNodes3 = data;
        }
    });

    var template = "<div style='margin-left:15px;'><div> <fmt:message key="system.role.roleName" /> <sup>*</sup>:</div><div> {roleName} </div>";
    template += "<div> <fmt:message key="system.role.nodes" /><sup>*</sup>: </div><div>{nodes} </div>";
    template += "<hr style='width:100%;'/>";
    template += "<div> {sData} {cData}  </div></div>";

    $("#role_list").jqGrid({
        ajaxGridOptions: {type: "POST"},
        url: '<c:url value="/system/role.do?method=pageQuery"/>',
        editurl: '<c:url value="/system/user.do"/>',
        datatype: "json",
        autowidth: true,
        height: '80%',
        autowidth: true,
        colModel: [
            {label: 'ID', name: 'id', width: 50,editable: false},
            {label: '<fmt:message key="system.role.roleName" />', name: 'roleName', width: 50,
                editable: true,editrules: {required: true}},
            {label: '<fmt:message key="system.role.nodes" />', name: 'permissionNames', width: 500},
            {label: '<fmt:message key="system.role.nodes" />', name: 'nodes', width: 100,
                editable: true, editrules: {required: true}, hidden:true,
                editoptions: {
                    dataInit: function (element) {
                        console.log('1111');
                        console.log($(element));
                        zTreeObj = $.fn.zTree.init($("#nodes"), setting, zNodes);
                    }
                }
            }
        ],
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#role_list_pager',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption: "<fmt:message key='module.system.role' />"
    });
    //$("#role_list").jqGrid('navGrid', '#p_role_list', {edit: false, add: false, del: false});
    $("#role_list").navGrid('#role_list_pager',
            { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
            {
                template: template,
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


</script>
