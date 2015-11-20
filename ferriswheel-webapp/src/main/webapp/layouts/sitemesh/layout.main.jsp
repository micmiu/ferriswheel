<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/taglibs/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="header.jsp"%>
<body>
	<jsp:include page="top.jsp" />

	<div class="container-fluid">
		<div class="row">
            <!-- left menu starts -->
            <div class="col-xs-3">
                <jsp:include page="west.jsp" />
            </div>
            <!-- left menu ends -->
            <noscript>
                <div class="alert alert-warning">
                    <h4 class="alert-heading">Warning!</h4>
                    <p>
                        You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
                                            target="_blank">JavaScript</a> enabled to use this site.
                    </p>
                </div>
            </noscript>
            <!-- content starts -->
            <div id="content" class="col-xs-9">
                <div>
                    <ol class="breadcrumb">
                        <li><a href="<c:url value='/index.do'/>"><fmt:message
                                key="global.text.index" /></a></li>
                        <li><a href="#"> <sitemesh:title /></a></li>
                    </ol>
                </div>
                <sitemesh:body />
            </div>
            <!-- content ends -->
		</div>
		<!--/fluid-row-->
		<hr />
		<jsp:include page="footer.jsp" />
	</div>
	<!--/.fluid-container-->
	<!--/fluid-row-->
	<!-- external javascript  -->
	<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>