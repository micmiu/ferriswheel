<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript">
	$(document).ready(function() {
		$("#message").fadeOut(3000);
	});
	$("#input-form").validate({
		errorContainer : "#messageBox"
	});
</script>
</head>
<body>
	<c:if test="${not empty message}">
		<div id="message" class="success">${message}</div>
	</c:if>
	<form:form id="input-form" modelAttribute="fileBean"
		enctype="multipart/form-data"
		action="${ctx}/demo/FileUpload.do?method=uploadify" method="post">
		<fieldset class="prepend-top">

			<legend>
				<fmt:message key="demo.upload.title" />
			</legend>

			<div id="messageBox" class="error-msg" style="display: none">
				<fmt:message key="global.msg.form.valid.error" />
			</div>

			<div class="field">
				<label for="file" class="field"><fmt:message
						key="demo.upload.file" />:</label> <input type="file" id="file"
					name="file" size="20" value="${fileBean.file}" class="required" />
			</div>
			<div class="field">
				<label for="other" class="field"><fmt:message
						key="demo.upload.desc" />:</label> <input type="text" id="other"
					name="other" size="20" value="${fileBean.other}" />
			</div>

			<div class="field">
				<input type="button" name="btn_submit"
					value="<fmt:message key="global.text.ok" />"
					onclick="formSubmit('#input-form')" /><input type="button"
					name="btn_cancel" value="<fmt:message key="global.text.cancel" />"
					onclick="cancelTabForm('#demo-lt-tabs')" />
			</div>
		</fieldset>

	</form:form>
</body>
<script type="text/javascript">
	function formSubmit(_form_id) {
		var actionUrl = $(_form_id).attr("action");
		if (!$(_form_id).valid()) {
			return;
		}
		$(_form_id).submit();
	}

	function cancelTabForm(_tabs_id) {
		var tab = $(_tabs_id).tabs('getSelected');
		var title = tab.panel("options").title
		$(_tabs_id).tabs('close', title);
	}
</script>
</html>
