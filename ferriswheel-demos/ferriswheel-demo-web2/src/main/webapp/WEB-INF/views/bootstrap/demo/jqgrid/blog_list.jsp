<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.jqgrid'/> - blog</title>
</head>

<div class="row">
    <div class="col-xs-12">
        <table id="blog_list"></table>
        <div id="blog_list_pager"></div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        var template = "<div style='margin-left:15px;'><div> <fmt:message key='demo.blog.col.title' /> <sup>*</sup>:</div><div> {title} </div>";
        template += "<div> <fmt:message key='demo.blog.col.category' />: </div><div>{category} </div>";
        template += "<div> <fmt:message key='demo.blog.col.author' />: </div><div>{author} </div>";
        template += "<div> <fmt:message key='demo.blog.col.publishDate' />: </div><div>{publishDate} </div>";
        template += "<div> <fmt:message key='demo.blog.col.url' />:</div><div> {url} </div>";
        template += "<hr style='width:100%;'/>";
        template += "<div> {sData} {cData}  </div></div>";
        $("#blog_list").jqGrid({
            url: '<c:url value="/demo/jqgrid/blog.do?method=pageQuery"/>',
            editurl: '<c:url value="/demo/jqgrid/blog.do"/>',
            mtype:  'POST',
            styleUI: 'Bootstrap',
            datatype: "json",
            height: 250,
            colModel: [
                {label: 'ID', name: 'id', width: 50, align: 'right'},
                {
                    label: '<fmt:message key="demo.blog.col.title" />',
                    name: 'title', width: 100, editable: true, editrules: {required: true}
                },
                {
                    label: '<fmt:message key="demo.blog.col.category" />',
                    name: 'category', width: 50, editable: true
                },
                {
                    label: '<fmt:message key="demo.blog.col.author" />',
                    name: 'author', width: 80, editable: true
                },
                {
                    label: '<fmt:message key="demo.blog.col.publishDate" />',
                    name: 'publishDate', width: 100, editable: true,
                    editoptions: {
                        dataInit: function (element) {
                            $(element).datepicker({
                                autoclose: true,
                                format: 'yyyy-mm-dd'
                            });
                        }
                    }
                },
                {
                    label: '<fmt:message key="demo.blog.col.url" />',
                    name: 'url', width: 400, sortable: false, editable: true, editrules: {required: true}
                }
            ],
            rowNum: 10,
            rowList: [10, 20, 30],
            pager: '#blog_list_pager',
            sortname: 'id',
            sortorder: "asc",
            viewrecords: true,
            caption: "<fmt:message key='demo.blog' />"
        });
        $("#blog_list").navGrid('#blog_list_pager',
                { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
                {
                    template: template,
                    closeAfterEdit: true,
                    errorTextFormat: function (data) {
                        return '<fmt:message key="global.msg.error" />: ' + data.responseText
                    }
                },
                {
                    template: template,
                    closeAfterAdd: true,
                    serializeEditData: function(data) {
                        return $.param($.extend({}, data, {id: ''}));
                    },
                    errorTextFormat: function (data) {
                        return '<fmt:message key="global.msg.error" />: ' + data.responseText
                    }
                },
                {
                    errorTextFormat: function (data) {
                        return '<fmt:message key="global.msg.error" />: ' + data.responseText
                    }
                });

    });
</script>
