<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.jqgrid'/> - base</title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="base_list"></table>
        <div id="base_list_pager"></div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#base_list").jqGrid({
            url: '<c:url value="/demo/jqgrid/blog.do?method=pageQuery"/>',
            mtype:  'POST',
            styleUI: 'Bootstrap',
            datatype: "json",
            height: 250,
            colModel: [
                {label: 'ID', name: 'id', width: 50, align: 'right'},
                {
                    label: '<fmt:message key="demo.blog.col.title" />',
                    name: 'title', width: 100
                },
                {
                    label: '<fmt:message key="demo.blog.col.category" />',
                    name: 'category', width: 50
                },
                {
                    label: '<fmt:message key="demo.blog.col.author" />',
                    name: 'author', width: 80
                },
                {
                    label: '<fmt:message key="demo.blog.col.publishDate" />',
                    name: 'publishDate', width: 100
                },
                {
                    label: '<fmt:message key="demo.blog.col.url" />',
                    name: 'url', width: 400
                }
            ],
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: '#base_list_pager',
            sortname: 'id',
            sortorder: "asc",
            viewrecords: true,
            caption: "<fmt:message key='demo.blog' />"
        });
//        $("#base_list").navGrid('#base_list_pager',
//                { edit: false, add: false, del: false, search: false, refresh: false, view: false, position: "left", cloneToTop: false });

    });
</script>
