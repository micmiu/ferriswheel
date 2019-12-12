<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <%@ include file="datatables.header.jsp"%>
    <title><fmt:message key='module.datatables'/> - Query</title>
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
            <tfoot>
            <tr>
                <th width="20%"><input type="text" name="title"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.title' />"
                           class="search_init"/></th>
                <th width="10%"><input type="text" name="category"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.category' />"
                           class="search_init"/></th>
                <th width="10%"><input type="text" name="author"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.author' />"
                           class="search_init"/></th>
                <th width="45%"><input type="text" name="url"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.url' />"
                           class="search_init"/></th>
                <th width="15%"></th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>

<script type="text/javascript">
    var blogurl = "<c:url value='/demo/datatables/blog.do'/>";
    var oTable;
    var aoColumns_def = [{
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
    var asInitVals = new Array();
    $(document).ready(function () {
        var dt_oSettings = {
            "bRetrieve": true,
            "bProcessing": true,
            "bServerSide": true,
            "bAutoWidth": false,
            "searching": false,
            "fnServerParams": function (aoData) {
                $("tfoot input.search_val").each(function () {
                    aoData.push({"name": this.name, "value": this.value});
                });
            },
            "sAjaxSource": blogurl + "?method=pageQuery",
            "aoColumns": aoColumns_def
        };
        oTable = $('#blog_list').dataTable(dt_oSettings);

        $("tfoot input").keyup(function () {
            oTable.fnFilter(this.value, $("tfoot input").index(this));
        });

        $("tfoot input").each(function (i) {
            asInitVals[i] = this.value;
        });

        $("tfoot input").focus(function () {
            if (this.className == "search_init") {
                this.className = "search_val";
                this.value = "";
            }
        });

        $("tfoot input").blur(function (i) {
            if (this.value == "") {
                this.className = "search_init";
                this.value = asInitVals[$("tfoot input").index(this)];
            }
        });
    });
</script>