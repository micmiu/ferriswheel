<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript">
	var paras = {dg_id:'base_dg-list',form_id:'base_query-form',export_form_id:'base_export-form'};
</script>
</head>
<body>
	<table id="base_dg-list">
	</table>

</body>
<script type="text/javascript">
	$('#base_dg-list').datagrid({
		title : '',
		url : 'crud.do?method=pageQuery',
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
