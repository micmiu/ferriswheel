<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<table id="dg-list" style="height: auto;width: auto">
	</table>
	<div id="tb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<shiro:hasPermission name="role:create">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onclick="MM_utils.baseWinAdd({win_url:'role.do?method=showForm',h:500})"><fmt:message
						key="global.text.create" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="role:update">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true"
					onclick="MM_utils.baseWinEdit({win_url:'role.do?method=showForm',h:500});"><fmt:message
						key="global.text.update" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="role:delete">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="MM_utils.baseGDDel('#dg-list','role.do?method=deleteBatch')"><fmt:message
						key="global.text.delete" /></a>
			</shiro:hasPermission>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="MM_utils.baseView({win_url:'role.do?method=getViewData'})"><fmt:message
					key="global.text.read" /></a>
		</div>
		<div>
			<form id="query-form">
				<fmt:message key="system.role.roleName" />
				: <input style="width: 80px" name="roleName"> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="MM_utils.formQuery()"><fmt:message
						key="global.text.query" /></a>
			</form>
		</div>
	</div>
	<div id="form-win"></div>
</body>
<script type="text/javascript">
	$('#dg-list').datagrid({
		title : '',
		url : 'role.do?method=pageQuery',
		toolbar : '#tb',
		fit : true,
		rownumbers : true,
		singleSelect : false,
		iconCls : 'icon-table',
		pagination : true,
		nowrap : false,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'roleName',
			width : 100,
			title : '<fmt:message key="system.role.name" />'
		}, {
			field : 'permissionNames',
			width : 600,
			title : '<fmt:message key="system.role.nodes" />'
		} ] ]
	});
</script>
</html>
