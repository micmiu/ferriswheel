<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="header.jsp"%>
<body style="padding-bottom:70px;">
	<div class="container-fluid">
		<div class="row">
			<div id="content" class="col-xs-12">
				<!-- content starts -->
				<sitemesh:body />
				<!-- content ends -->
			</div>
			<!--/#content.span10-->
		</div>
		<!--/fluid-row-->
	</div>
</body>
</html>