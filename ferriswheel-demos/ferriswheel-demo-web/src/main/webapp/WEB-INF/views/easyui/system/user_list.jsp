<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<table id="dg-list">
	</table>
	<div id="tb" style="padding: 5px; height: auto">
		<div>
			<form id="query-form">
				<fmt:message key="system.user.loginName" />
				: <input style="width: 80px" name="loginName">
				<fmt:message key="system.user.name" />
				: <input style="width: 80px" name="name"> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="MM_utils.formQuery()"><fmt:message
						key="global.text.query" /></a>
			</form>
		</div>
		<div style="margin-bottom: 5px">
			<shiro:hasPermission name="user:create">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true"
					onclick="MM_utils.baseWinAdd({win_url:'user.do?method=showForm'})"><fmt:message
						key="global.text.create" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="user:update">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true"
					onclick="MM_utils.baseWinEdit({win_url:'user.do?method=showForm'});"><fmt:message
						key="global.text.update" /></a>
			</shiro:hasPermission>
			<shiro:hasPermission name="user:delete">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="MM_utils.baseGDDel('#dg-list','user.do?method=deleteBatch')"><fmt:message
						key="global.text.delete" /></a>
			</shiro:hasPermission>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="MM_utils.baseView({win_url:'user.do?method=getViewData'})"><fmt:message
					key="global.text.read" /></a>
		</div>

	</div>
	<div id="form-win"></div>
</body>
<script type="text/javascript">
	$('#dg-list').datagrid({
		title : '',
		url : 'user.do?method=pageQuery',
		toolbar : '#tb',
		fit : true,
		rownumbers : true,
		singleSelect : false,
		iconCls : 'icon-table',
		pagination : true,
		frozenColumns : [ [ {
			field : 'ck',
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'loginName',
			title : '<fmt:message key="system.user.loginName" />',
			width : 100
		}, {
			field : 'name',
			title : '<fmt:message key="system.user.name" />',
			width : 100
		}, {
			field : 'email',
			title : '<fmt:message key="system.user.email" />',
			width : 100
		}, {
			field : 'other',
			title : '<fmt:message key="system.user.other" />',
			width : 100
		}, {
			field : 'roleName',
			title : '<fmt:message key="system.role.roleName" />',
			width : 100
		} ] ]
	});
</script>
</html>
