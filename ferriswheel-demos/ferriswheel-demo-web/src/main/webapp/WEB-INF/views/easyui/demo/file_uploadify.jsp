<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/js/uploadify/uploadify.css'/>" />
<script type="text/javascript"
	src="<c:url value='/js/uploadify/jquery.uploadify.min.js'/>"></script>
<script type="text/javascript">
	var upload_url = '<c:url value="/demo/FileUpload.do"/>'
			+ ';jsessionid=${pageContext.session.id}?method=uploadify';
	//alert(upload_url);
	$(function() {
		$("#file_upload")
				.uploadify(
						{
							swf : '<c:url value="/static/js/uploadify/uploadify.swf"/>',
							uploader : '/hazel-web/demo/FileUpload.do'
									+ ';JSESSIONID=${pageContext.session.id}?method=uploadify',
							auto : false,
							buttonText : '<fmt:message key="demo.upload.select" />',
							fileSizeLimit : '2000KB',
							multi : true,
							debug : false,
							onFallback : function() {
								alert("flash init failed!");
							},
							onUploadStart : function(file) {
								alert("file :" + file.name + " start upload");
								alert(this.settings.uploader);
							},
							onUploadSuccess : function(file, data, response) {
								alert("file:" + file.name + " upload response:"
										+ response + " with data:" + data);
							}
						});
	});
</script>
</head>
<body>
	<p style="display: none">
		<c:url value="/demo/FileUpload.do" />
		;JSESSIONID=${pageContext.session.id}?method=uploadify'<br>
		'${pageContext.session.id}'<br>
		'${pageContext.request.contextPath}'<br>
	</p>
	<input type="file" name="file_upload" id="file_upload" />
	<p>
		<a href="javascript:$('#file_upload').uploadify('upload')"><fmt:message
				key="global.text.ok" /></a>| <a
			href="javascript:$('#file_upload').uploadify('cancel')"><fmt:message
				key="global.text.cancel" /></a>
	</p>
</body>
</html>
