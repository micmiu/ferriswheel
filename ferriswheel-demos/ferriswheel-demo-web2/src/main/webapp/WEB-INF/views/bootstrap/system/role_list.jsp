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
        },
        callback:{
            onCheck: permNodeCheck
        }
    };

    var template = "<div style='margin-left:15px;height: 400px'><div> <fmt:message key="system.role.roleName" /> <sup>*</sup>:</div><div> {roleName} </div>";
    template += "<div> <fmt:message key="system.role.nodes" /><sup>*</sup>: </div><div style='overflow:auto'>{nodes} </div>";
    template += "<hr style='width:100%;'/>";
    template += "<div class='height:auto; margin-bottom: 0'> {sData} {cData}  </div></div>";

    $("#role_list").jqGrid({
        ajaxGridOptions: {type: "POST"},
        url: '<c:url value="/system/role.do?method=pageQuery"/>',
        editurl: '<c:url value="/system/role.do"/>',
        datatype: "json",
        autowidth: true,
        height: '90%',
        autowidth: true,
        colModel: [
            {label: 'ID', name: 'id', width: 50,editable: false},
            {label: '<fmt:message key="system.role.roleName" />', name: 'roleName', width: 50,
                editable: true,editrules: {required: true}},
            {label: '<fmt:message key="system.role.nodes" />', name: 'permissionNames', width: 500},
            {label: '<fmt:message key="system.role.nodes" />', name: 'nodes', width: 100,
                editable: true, editrules: {edithidden: true, custom:true,  custom_func: checkPermNodes}, hidden:true,
                editoptions: {
                    dataInit: function (element) {
                        $(element).hide();
                        var ele_div = $('<div style="height:auto;scroll:auto"></div>');
                        var ele_tree= $('<ul id="ztree_nodes" class="ztree"></ul>')
                        //console.log(ele_tree);
                        $(element).after(ele_div.append(ele_tree));
                        var rowid = $(element).attr('rowid');
                        if(rowid == '_empty'){
                            rowid="";
                        }
                        var zNodes;
                        $.ajax({
                            async: false,
                            cache: false,
                            type: 'POST',
                            dataType: "json",
                            url: "<c:url value='/system/role.do?method=getPermTree'/>"+'&id=' + rowid,
                            error: function () {//请求失败处理函数
                                alert('请求失败');
                            },
                            success: function (data) {
                                //console.log(data);
                                zNodes = data;
                            }
                        });
                        zTreeObj = $.fn.zTree.init(ele_tree, setting, zNodes);
                        //$('#test_demo').append(' <ul id="ztree_demo3" class="ztree"></ul>');
                        //zTreeObj3 = $.fn.zTree.init($("#ztree_demo3"), setting, zNodes);

                        //console.log(zTreeObj3);
                        //console.log(zTreeObj);
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

    function permNodeCheck(e,treeId,treeNode){
        var zTree = $.fn.zTree.getZTreeObj(treeId);
        var checkedNodes = zTree.getCheckedNodes();
        var nodestr="";
        $.each(checkedNodes, function(i, item){
            if(i==0){
                nodestr+= item['id'];
            }else{
                nodestr+= ","+item['id'];
            }
        });
        $('#nodes').attr('value',nodestr);
        //console.log("oncheck:"+$('#nodes').val());
    }

    function checkPermNodes(cellvalue, cellname) {
        var zTree = $.fn.zTree.getZTreeObj("ztree_nodes");
        var checkedNodes = zTree.getCheckedNodes();
        if (checkedNodes.length ==0 ) {
            var msg = cellname+": <fmt:message key="global.msg.required" />";
            console.log(msg);
            return [false, msg];
        }
        return [true, ''];
    }

    function createPermNodeElement(value, editOptions) {

        var div =$("<div style='margin-bottom:5px;margin-top:-10px;'></div>");
        var label = $("<label>nodes</label>");
        var nodes = $("input",{type: "hidden",value:"",name:"nodes", id: "nodes"});
        var ulztree = $("<ul id='ztree_nodes' class='ztree'></ul>");
        div.append(label).append(nodes).append(ulztree);

        return div;
    }

    // The javascript executed specified by JQGridColumn.EditTypeCustomGetValue when EditType = EditType.Custom
    // One parameter passed - the custom element created in JQGridColumn.EditTypeCustomCreateElement
    function getPermNodeValue(elem, oper, value) {
        if (oper === "set") {
            var radioButton = $(elem).find("input:radio[value='" + value + "']");
            if (radioButton.length > 0) {
                radioButton.prop("checked", true);
            }
        }

        if (oper === "get") {
            return $(elem).find("input:radio:checked").val();
        }
    }


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
