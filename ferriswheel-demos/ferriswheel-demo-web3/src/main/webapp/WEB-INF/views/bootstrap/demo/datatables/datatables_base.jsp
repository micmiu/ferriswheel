<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <%@ include file="datatables.header.jsp"%>
    <title><fmt:message key='module.datatables'/> - Base</title>
</head>
<div class="row">
    <div class="col-xs-12">
        <table id="blog_list" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th width="20%"><fmt:message key="demo.blog.col.title"/></th>
                <th width="10%"><fmt:message key="demo.blog.col.category"/></th>
                <th width="10%"><fmt:message key="demo.blog.col.author"/></th>
                <th width="45%"><fmt:message key="demo.blog.col.url"/></th>
                <th width="15%"><fmt:message key="demo.blog.col.publishDate"/></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    var blogurl = "<c:url value='/demo/datatables/blog.do'/>";
    var oTable;
    var aoColumns_def = [ {
        "mData": "title"
    }, {
        "mData": "category"
    }, {
        "mData": "author"
    }, {
        "mData": "url"
    }, {
        "mData": "publishDate"
    }];
    var dt_oSettings = {
        "sAjaxSource": blogurl + "?method=pageQuery",
        "aoColumns": aoColumns_def
    };

    var asInitVals = new Array();
    $(document).ready(function () {
        oTable = $('#blog_list').DataTable(dt_oSettings);
    });
    //$('#blog_list').addClass('table table-striped table-bordered');

</script>