<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript">
	var paras = {dg_id:'#export_dg-list',form_id:'#export_query-form',export_form_id:'#export_export-form'};
</script>
</head>
<body>
	<table id="export_dg-list">
	</table>
	<div id="export_tb" style="padding: 5px; height: auto">
		<div>
			<form id="export_query-form" method="post">
				<fmt:message key="demo.blog.gd.col.title" />
				: <input style="width: 80px" name="title"> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'"
					onclick="MM_utils.formQuery({dg_id:'#export_dg-list',form_id:'#export_query-form'})"><fmt:message
						key="global.text.query" /></a>
			</form>
			<form id="export_export-form" method="post"></form>
		</div>
		<div style="margin-bottom: 5px">
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onclick="MM_utils.baseWinAdd({dg_id:'#export_dg-list',win_url:'crud.do?method=showForm'})"><fmt:message
						key="global.text.create" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true"
					onclick="MM_utils.baseWinEdit({dg_id:'#export_dg-list',win_url:'crud.do?method=showForm'});"><fmt:message
						key="global.text.update" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="MM_utils.baseGDDel('#export_dg-list','crud.do?method=batchDel')"><fmt:message
						key="global.text.delete" /></a>
			</shiro:hasPermission>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="MM_utils.baseView({dg_id:'#export_dg-list',win_url:'crud.do?method=getViewData'})"><fmt:message
					key="global.text.read" /> </a> <a href="javascript:void(0)"
				id="export_mb" class="easyui-menubutton"
				data-options="iconCls:'icon-excel',plain:true"><fmt:message
					key="global.text.export" /></a>
		</div>
		<div id="export_mm" style="width: 50px;">
			<div data-options="iconCls:'icon-excel'"
				onclick="MM_utils.baseExport({dg_id:'#export_dg-list',form_id:'#export_query-form',actionURL:'crud.do?method=export&exportType=POI'})">POI</div>
			<div data-options="iconCls:'icon-excel'"
				onclick="MM_utils.baseExport({dg_id:'#export_dg-list',form_id:'#export_query-form',actionURL:'crud.do?method=export&exportType=JXL'})">JXL</div>
			<div data-options="iconCls:'icon-csv'"
				onclick="MM_utils.baseExport({dg_id:'#export_dg-list',form_id:'#export_query-form',actionURL:'crud.do?method=export&exportType=CSV'})">CSV</div>
			<div data-options="iconCls:'icon-pdf'"
				onclick="MM_utils.baseExport({dg_id:'#export_dg-list',form_id:'#export_query-form',actionURL:'crud.do?method=export&exportType=PDF'})">PDF</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$('#export_mb').menubutton({
	    iconCls: 'icon-export',
	    menu: '#export_mm'
	});
	$('#export_dg-list').datagrid({
		title : '',
		url : 'crud.do?method=pageQuery',
		toolbar : '#export_tb',
		fit : true,
		rownumbers : true,
		singleSelect : false,
		iconCls : 'icon-table',
		pagination : true,
		sortName : 'title',
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'title',
			title : '<fmt:message key="demo.blog.gd.col.title" />',
			width : 100
		}, {
			field : 'category',
			title : '<fmt:message key="demo.blog.gd.col.category" />',
			width : 100
		}, {
			field : 'author',
			title : '<fmt:message key="demo.blog.gd.col.author" />',
			width : 100
		}, {
			field : 'url',
			title : '<fmt:message key="demo.blog.gd.col.url" />',
			width : 100
		}, {
			field : 'other',
			title : '<fmt:message key="demo.blog.gd.col.other" />',
			width : 100
		}, {
			field : 'publishDate',
			title : '<fmt:message key="demo.blog.gd.col.publishDate" />',
			width : 100
		}, {
			field : 'creater',
			title : '<fmt:message key="demo.blog.gd.col.creater" />',
			width : 100
		} ] ]
	});
</script>
</html>
