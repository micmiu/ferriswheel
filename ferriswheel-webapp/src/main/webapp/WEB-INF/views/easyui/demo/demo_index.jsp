<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script>
	
</script>
</head>

<body>
	<div id="demo-lt" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',title:'<fmt:message key="demo.lt.title" />',split:true"
			style="width: 200px;">
			<ul id="demo-lt-ul" class="easyui-tree">
				<li><span><fmt:message key="demo.lt.title.base" /></span>
					<ul>
						<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-tab-form','<fmt:message key="demo.lt.title.base.form" />','<c:url value="/demo/easyui/index.do?method=showForm"/>')"><fmt:message key="demo.lt.title.base.form" /></a></span></li>
						<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-upload-file','<fmt:message key="demo.lt.title.base.upload" />','<c:url value="/demo/FileUpload.do?method=showForm"/>')"><fmt:message key="demo.lt.title.base.upload" /></a></span></li>
						<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-uploadify','<fmt:message key="demo.lt.title.base.uploadify" />','<c:url value="/demo/FileUpload.do?method=showUploadifyForm"/>')"><fmt:message key="demo.lt.title.base.uploadify" /></a></span></li>
					</ul></li>
				<li><span><fmt:message key="demo.lt.title.dg" /></span>
					<ul>
						<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-tab-dg-base','<fmt:message key="demo.lt.title.dg.base" />','<c:url value="/demo/easyui/datagrid.do?method=dg4base"/>')"><fmt:message key="demo.lt.title.dg.base" /></a></span></li>
								<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-tab-dg-tb','<fmt:message key="demo.lt.title.dg.tb" />','<c:url value="/demo/easyui/datagrid.do?method=dg4tb"/>')"><fmt:message key="demo.lt.title.dg.tb" /></a></span></li>
								<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-tab-dg-export','<fmt:message key="demo.lt.title.dg.export" />','<c:url value="/demo/easyui/datagrid.do?method=dg4export"/>')"><fmt:message key="demo.lt.title.dg.export" /></a></span></li>
					</ul></li>
				<li><span><fmt:message key="demo.lt.title.i18n" /></span>
					<ul>
						<li><span><a href="javascript:void(0)"
								onclick="openTab4Demo('demo-tab-i18n-en','<fmt:message key="demo.lt.title.i18n.base" />','<c:url value="/demo/i18n/index.do"/>')"><fmt:message key="demo.lt.title.i18n.base" /></a></span></li>
					</ul></li>
			</ul>
		</div>
		<div data-options="region:'center',title:''">
			<div id="demo-lt-tabs" class="easyui-tabs" data-options="fit:true">
				<div id="demo-tab-index" title="welcome" style="padding: 20px;">wellcome
					to demos</div>
			</div>
				<div id="form-win"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var tabs_id = "#demo-lt-tabs";
	$(tabs_id).tabs({
		onBeforeClose : function(title) {
			return confirm('<fmt:message key="global.text.close" /> ' + title + '?');
		}
	});

	function openTab4Demo(tabId, titleName, tabURL) {
		if ($(tabs_id).tabs('exists', titleName)) {
			$(tabs_id).tabs('select', titleName);
			var tab = $(tabs_id).tabs('getSelected');
			tab.panel('refresh');
		} else {
			$(tabs_id).tabs('add', {
				id : tabId,
				title : titleName,
				href : tabURL,
				//content:'<iframe name="if_'+tabId+ '" scrolling="auto" frameborder="0" src="'+tabURL+'" style="width:100%;height:100%;"></iframe>', 
				closable : true,
				closed : true
			});
			//window.open(tabURL,"if_"+tabId);  
		}
	}
</script>
</html>
