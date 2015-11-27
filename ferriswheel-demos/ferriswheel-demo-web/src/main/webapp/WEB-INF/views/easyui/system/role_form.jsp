<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<c:if test="${showFormType eq 'create'}">
		<c:set var="ACTIONURL" value="${ctx}/system/role.do?method=create" />
	</c:if>
	<c:if test="${showFormType eq 'update'}">
		<c:set var="ACTIONURL" value="${ctx}/system/role.do?method=update" />
	</c:if>
	<form:form id="input-form" modelAttribute="role" action="${ACTIONURL}"
		method="post">
		<input type="hidden" id="id" name="id" value="${role.id}" />
		<fieldset class="prepend-top">

			<legend>
				<fmt:message key="system.role.name" />
			</legend>

			<div id="messageBox" class="error-msg" style="display: none">
				<fmt:message key="global.msg.form.valid.error" />
			</div>

			<div>
				<label for="roleName" class="field"><fmt:message
						key="system.role.roleName" />:</label> <input type="text" id="roleName"
					name="roleName" size="20" value="${role.roleName}" class="required" />
			</div>
			<div>
				<label for="nodes" class="field"><fmt:message
						key="system.role.nodes" />:</label> <input type="hidden" id="nodes"
					name="nodes" />
				<ul id="tree-perm"></ul>
			</div>
		</fieldset>
	</form:form>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#roleName").focus();
						$("#input-form")
								.validate(
										{
											rules : {
												roleName : {
													remote : "${ctx}/system/role.do?method=checkRoleName&oldRoleName="
															+ encodeURIComponent('${role.roleName}')
												},
												nodes : "required"
											},
											messages : {
												roleName : {
													remote : "<fmt:message key="system.role.roleName.exit" />"
												},
											},
											errorContainer : "#messageBox",
											errorPlacement : function(error,
													element) {
												if (element.is(":checkbox")) {
													error.appendTo(element
															.parent().next());
												} else
													error.insertAfter(element);
											}
										});
					});
	$('#tree-perm').tree(
			{
				url : '<c:url value="/system/role.do?method=getPermTree"/>'
						+ '&id=' + $('#id').val(),
				animate : true,
				checkbox : true
			})

	function beforeFormSubmit() {
		var nodes = $('#tree-perm').tree('getChecked');
		var s = '';
		for ( var i = 0; i < nodes.length; i++) {
			if (s != '')
				s += ',';
			s += nodes[i].id;
		}
		$("#nodes").val(s);
		return true;

	}
	function getChecked() {
		beforeFormSubmit();
	}
</script>
</html>
