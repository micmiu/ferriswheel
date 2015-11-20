<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script>
	$(document).ready(function() {
		$("#title").focus();
		$("#input-form").validate({
			errorContainer : "#messageBox",
			errorPlacement : function(error, element) {
				if (element.is(":checkbox"))
					error.appendTo(element.parent().next());
				else
					error.insertAfter(element);
			}
		});
	});
</script>
</head>

<body>
	<c:if test="${showFormType eq 'create'}">
		<c:set var="ACTIONURL" value="${ctx}/demo/easyui/crud.do?method=create" />
	</c:if>
	<c:if test="${showFormType eq 'update'}">
		<c:set var="ACTIONURL" value="${ctx}/demo/easyui/crud.do?method=update" />
	</c:if>
	<form:form id="input-form" modelAttribute="blog" action="${ACTIONURL}"
		method="post">
		<input type="hidden" name="id" value="${blog.id}" />
		<input type="hidden" name="creater" value="${blog.creater}" />
		<fieldset class="prepend-top">

			<legend>
				<fmt:message key="demo.gd.blog" />
			</legend>

			<div id="messageBox" class="error-msg" style="display: none">
				<fmt:message key="global.msg.form.valid.error" />
			</div>
			<div>
				<label for="title" class="field"><fmt:message
						key="demo.blog.gd.col.title" />:</label> <input type="text" id="title"
					name="title" size="20" value="${blog.title}" class="required" />
			</div>
			<div>
				<label for="author" class="field"><fmt:message
						key="demo.blog.gd.col.author" />:</label> <input type="text" id="author"
					name="author" size="20" value="${blog.author}" class="required" />
			</div>
			<div>
				<label for="category" class="field"><fmt:message
						key="demo.blog.gd.col.category" />:</label> <input type="text" id="category"
					name="category" size="20" value="${blog.category}" class="required" />
			</div>
			<div>
				<label for="url" class="field"><fmt:message
						key="demo.blog.gd.col.url" />:</label> <input type="text" id="url" name="url"
					size="20" value="${blog.url}" class="required" />
			</div>
			<div>
				<label for="other" class="field"><fmt:message
						key="demo.blog.gd.col.other" />:</label> <input type="text" id="other"
					name="other" size="20" value="${blog.other}" class="required" />
			</div>
			<div>
				<label for="publishDate" class="field"><fmt:message
						key="demo.blog.gd.col.publishDate" />:</label> <input type="text"
					id="publishDate" name="publishDate" size="20"
					value="${blog.publishDate}" class="Wdate required"
					onFocus="WdatePicker({readOnly:true})" />
			</div>
		</fieldset>

	</form:form>
</body>
<script type="text/javascript">
	
</script>
</html>
