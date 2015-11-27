<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
</head>
<body>
	<c:if test="${showFormType eq 'create'}">
		<c:set var="ACTIONURL" value="${ctx}/system/user.do?method=create" />
	</c:if>
	<c:if test="${showFormType eq 'update'}">
		<c:set var="ACTIONURL" value="${ctx}/system/user.do?method=update" />
	</c:if>
	<form:form id="input-form" modelAttribute="user" action="${ACTIONURL}"
		method="post">
		<input type="hidden" name="id" value="${user.id}" />
		<fieldset class="prepend-top">

			<legend>
				<fmt:message key="system.user.title" />
			</legend>

			<div id="messageBox" class="error-msg" style="display: none">
				<fmt:message key="global.msg.form.valid.error" />
			</div>

			<div>
				<label for="loginName" class="field"><fmt:message
						key="system.user.loginName" />:</label> <input type="text" id="loginName"
					name="loginName" size="20" value="${user.loginName}"
					class="required" />
			</div>
			<div>
				<label for="name" class="field"><fmt:message
						key="system.user.name" />:</label> <input type="text" id="name"
					name="name" size="20" value="${user.name}" class="required"
					minlength="3" />
			</div>
			<c:if test="${showFormType eq 'create'}">
			<div>
				<label for="password" class="field"><fmt:message
						key="system.user.password" />:</label> <input type="password"
					id="password" name="password" size="20" value="${user.password}"
					class="required" minlength="3" />
			</div>
			<div>
				<label for="passwordConfirm" class="field"><fmt:message
						key="system.user.passwordConfirm" />:</label> <input type="password"
					id="passwordConfirm" name="passwordConfirm" size="20"
					value="${user.password}" equalTo="#password" />
			</div>
			</c:if>
			<div>
				<label for="email" class="field"><fmt:message
						key="system.user.email" />:</label> <input type="text" id="email"
					name="email" size="40" value="${user.email}" class="email" />
			</div>
			<div>
				<label for="other" class="field"><fmt:message
						key="system.user.other" />:</label>
				<textarea rows="3" cols="30" id="other" name="other"
					style="height: 50px; width: 250px"></textarea>
			</div>
			<div>
				<label for="roleId" class="field"><fmt:message
						key="system.role.name" />:</label>
				<form:select path="roleId" items="${roleList}" itemValue="id"
					itemLabel="roleName" />
			</div>
		</fieldset>

	</form:form>
</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#loginName").focus();
						$("#input-form")
								.validate(
										{
											rules : {
												loginName : {
													remote : "${ctx}/system/user.do?method=checkLoginName&oldLoginName="
															+ encodeURIComponent('${user.loginName}')
												},
												roleId : 'required'
											},
											messages : {
												loginName : {
													remote : "<fmt:message key="system.user.loginName.exit" />"
												},
												passwordConfirm : {
													equalTo : "<fmt:message key="system.user.password.same" />"
												}
											},
											errorContainer : "#messageBox",
											errorPlacement : function(error,
													element) {
												if (element.is(":checkbox"))
													error.appendTo(element
															.parent().next());
												else
													error.insertAfter(element);
											}
										});
					});
</script>
</html>
