<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<script type="text/javascript">
	$("#input-form").validate({
		rules : {
			radioVal : "required",
			checkBoxVals : "required"
		},
		messages : {
			radioVal : "<fmt:message key="demo.form.radioVal.valid" />",
			checkBoxVals : "<fmt:message key="demo.form.checkBoxVals.valid" />"
		},
		errorContainer : "#messageBox",
		errorPlacement : function(error, element) {
			if (element.is(":checkbox") || element.is(":radio"))
				error.appendTo(element.parent());
			else
				error.insertAfter(element);
		}
	});
</script>
</head>
<body>
	<form:form id="input-form" modelAttribute="easyui"
		action="${ctx}/demo/easyui/index.do?method=create" method="post">
		<input type="hidden" name="id" value="${easyui.id}" />
		<fieldset class="prepend-top">

			<legend><fmt:message key="demo.form.title" /></legend>

			<div id="messageBox" class="error-msg" style="display: none"><fmt:message key="global.msg.form.valid.error" /></div>

			<div class="field">
				<label for="textVal" class="field"><fmt:message key="demo.form.textVal" />:</label> <input type="text"
					id="textVal" name="textVal" size="20" value="${easyui.textVal}"
					class="required" />
			</div>
			<div class="field">
				<label for="email" class="field"><fmt:message key="demo.form.email" />:</label> <input type="text"
					id="email" name="email" size="20" value="${easyui.email}"
					class="required email" />
			</div>
			<div class="field">
				<label for="blogUrl" class="field"><fmt:message key="demo.form.blogUrl" />:</label> <input type="text"
					id="blogUrl" name="blogUrl" size="20" value="${easyui.blogUrl}"
					class="url" />
			</div>
			<div class="field">
				<label for="passwordVal" class="field"><fmt:message key="demo.form.password" />:</label> <input
					type="password" id="passwordVal" name="passwordVal" size="20"
					value="" class="required" minlength="6" />
			</div>
			<div class="field">
				<label for="re-password" class="field"><fmt:message key="demo.form.re-password" />:</label> <input
					type="text" id="re-password" name="re-password" size="20" value=""
					equalTo="#passwordVal" />
			</div>
			<div class="field">
				<label for="radioVal" class="field"><fmt:message key="demo.form.radioVal" />:</label> <input type="radio"
					name="radioVal" value="male"><fmt:message key="demo.form.radio.male" /> | <input type="radio"
					name="radioVal" value="female"><fmt:message key="demo.form.radio.female" />
			</div>
			<div class="field">
				<label for="dateVal" class="field"><fmt:message key="demo.form.dateVal" />:</label> <input type="text"
					id="dateVal" name="dateVal" size="20" value="${easyui.dateVal}"
					class="Wdate required date" onFocus="WdatePicker({readOnly:true})" />
			</div>
			<div class="field">
				<label for="selectStaticVal" class="field"><fmt:message key="demo.form.selectStaticVal" />:</label> <select
					class="easyui-combobox" id="selectStaticVal" name="selectStaticVal"
					style="width: 200px;">
				</select>
			</div>
			<div class="field">
				<label for="selectRemoteVal" class="field"><fmt:message key="demo.form.selectRemoteVal" />:</label> <select
					class="easyui-combobox" id="selectRemoteVal" name="selectRemoteVal"
					style="width: 200px;"></select>
			</div>
			<div class="field">
				<label for="province" class="field"><fmt:message key="demo.form.select.sub" />:</label> <select
					class="easyui-combobox" id="province" name="province"
					style="width: 200px;"></select> <select class="easyui-combobox"
					id="city" name="city" style="width: 200px;"></select>
			</div>

			<div class="field">
				<label for="checkBoxVals" class="field"><fmt:message key="demo.form.checkBoxVals" />:</label> <input
					type="checkbox" name="checkBoxVals" value="java" />JAVA <input
					type="checkbox" name="checkBoxVals" value="ruby" />Ruby <input
					type="checkbox" name="checkBoxVals" value="groovy" />Groovy
			</div>

			<div class="field">
				<input type="button" name="btn_submit" value="<fmt:message key="global.text.ok" />"
					onclick="formSubmit('#input-form')" /><input type="button"
					name="btn_cancel" value="<fmt:message key="global.text.cancel" />"
					onclick="cancelTabForm('#demo-lt-tabs')" />
			</div>
		</fieldset>

	</form:form>
</body>
<script type="text/javascript">
	$('#selectStaticVal').combobox({
		valueField : 'value',
		textField : 'label',
		data : [ {
			value : 'arch',
			label : '架构师'
		}, {
			value : 'soft',
			label : '软件工程师'
		}, {
			value : 'test',
			label : '测试人员'
		} ]
	});
	$('#selectRemoteVal').combobox({
		url : '<c:url value="/system/constant.do?method=getSelectList"/>',
		valueField : 'value',
		textField : 'name'
	});
	function formSubmit(_form_id) {
		var actionUrl = $(_form_id).attr("action");
		if (!$(_form_id).valid()) {
			return;
		}
		$.post(actionUrl, $(_form_id).serializeArray(), function(msg) {
			$.messager.alert('<fmt:message key="global.text.tips" />', msg, 'info');
		});
	}

	function cancelTabForm(_tabs_id) {
		var tab = $(_tabs_id).tabs('getSelected');
		var title = tab.panel("options").title
		$(_tabs_id).tabs('close', title);
	}
</script>
</html>
