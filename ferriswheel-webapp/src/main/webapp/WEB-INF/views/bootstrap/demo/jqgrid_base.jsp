<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<head>
    <title><fmt:message key='module.menu.jqgrid'/></title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="base_list"></table>
        <div id="p_base_list"></div>
    </div>
</div>
<script type="text/javascript">
    $("#base_list").jqGrid({
        ajaxGridOptions : {type:"POST"},
        url:'<c:url value="/demo/jqgriddemo.do?method=queryListData4Json"/>',
        datatype: "json",
        height: 250,
        colNames:['ID', 'title', 'category', 'author', 'publishDate', 'url'],
        colModel:[
            {name:'id',index:'id', width:40, align:'right'},
            {name:'title',index:'title', width:200},
            {name:'category',index:'category', width:100},
            {name:'author',index:'author', width:80},
            {name:'publishDate',index:'publishDate', width:100},
            {name:'url',index:'url', width:300,sortable:false}
        ],
        rowNum:10,
        rowList:[10,20,30],
        pager: '#p_base_list',
        sortname: 'id',
        viewrecords: true,
        sortorder: "desc",
        caption:"Demo List"
    }).navGrid('#p_base_list',{edit:false,add:false,del:false});
</script>
