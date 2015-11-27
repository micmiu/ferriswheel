<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<table id="demotb_dg-list">
	</table>
	<div id="demotb_tb" style="padding: 5px; height: auto">
		<div>
			<form id="demotb_query-form" method="post">
				<fmt:message key="demo.blog.gd.col.title" />
				: <input style="width: 80px" name="title"> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'"
					onclick="MM_utils.formQuery({form_id:'#demotb_query-form',dg_id:'#demotb_dg-list'})"><fmt:message
						key="global.text.query" /></a> <a href="javascript:void(0)"
					class="easyui-linkbutton" data-options="iconCls:'icon-redo'"
					onclick="MM_utils.formReset({form_id:'#demotb_query-form'});"><fmt:message
						key="global.text.reset" /></a>
			</form>
		</div>
		<div style="margin-bottom: 5px">
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onclick="MM_utils.baseWinAdd({win_url:'crud.do?method=showForm'})"><fmt:message
						key="global.text.create" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true"
					onclick="MM_utils.baseWinEdit({win_url:'crud.do?method=showForm'});"><fmt:message
						key="global.text.update" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="demo_common:read">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="MM_utils.baseGDDel('#dg-list','crud.do?method=batchDel')"><fmt:message
						key="global.text.delete" /></a>
			</shiro:hasPermission>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="MM_utils.baseView({win_url:'crud.do?method=getViewData'})"><fmt:message
					key="global.text.read" /></a>
		</div>

	</div>
</body>
<script type="text/javascript">
	$('#demotb_dg-list').datagrid({
		title : '',
		url : 'crud.do?method=pageQuery',
		toolbar : '#demotb_tb',
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
