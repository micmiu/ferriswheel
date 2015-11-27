<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<div id="east-p" class="easyui-panel"
     data-options="fit:true,border:false">
    <table id="pg-view" class="easyui-propertygrid"
           data-options="fit:true,border:false,showGroup:true,nowrap:false,columns: mycolumns,scrollbarSize:0"></table>
</div>
<script type="text/javascript">
    var mycolumns = [[{
        field: 'name',
        title: '<fmt:message key="easyui.ppgrid.filed.name" />',
        width: 100,
        sortable: true
    }, {
        field: 'value',
        title: '<fmt:message key="easyui.ppgrid.filed.value" />',
        width: 100,
        resizable: false
    }]];
</script>