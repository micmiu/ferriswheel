<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <%@ include file="datatables.header.jsp"%>
    <title><fmt:message key='module.datatables'/> - blog</title>
</head>
<div class="row">
    <div class="col-xs-12">
        <table id="blog_list" width="100%"
               class="table table-striped table-bordered bootstrap-datatable">
            <thead>
            <tr>
                <th width="15%"><fmt:message key="demo.blog.col.title" /></th>
                <th width="10%"><fmt:message key="demo.blog.col.category" /></th>
                <th width="10%"><fmt:message key="demo.blog.col.author" /></th>
                <th width="30%"><fmt:message key="demo.blog.col.url" /></th>
                <th width="15%"><fmt:message key="demo.blog.col.publishDate" /></th>
                <th width="20%"><fmt:message key="global.text.operation"/> <a class="btn btn-default"
                        href="javascript:ferriswheel.tableShowCreate(crud_paras)">
                    <span class="glyphicon glyphicon-plus"></span></a></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
            <tfoot>
            <tr>
                <th><input type="text" name="title"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.title' />"
                           class="search_init" /></th>
                <th><input type="text" name="category"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.category' />"
                           class="search_init" /></th>
                <th><input type="text" name="author"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.author' />"
                           class="search_init" /></th>
                <th><input type="text" name="url"
                           value="<fmt:message key='global.text.filter' /> <fmt:message key='demo.blog.col.url' />"
                           class="search_init" /></th>
                <th></th>
                <th></th>
            </tr>
            </tfoot>
        </table>
    </div>
</div>
<!-- create -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog"
     aria-labelledby="createModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="createModalLabel">
                    <fmt:message key="demo.blog"/>
                </h3>
            </div>
            <div class="modal-body">
                <jsp:include page="blog_modal_create.jsp" />
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal"><fmt:message
                        key="global.text.close"/></a> <a
                    href="javascript:ferriswheel.tableCreateFormModalOK(crud_paras)"
                    class="btn btn-primary"><fmt:message key="global.text.ok"/></a>
            </div>
        </div>
    </div>
</div>
<!-- /create -->
<!-- update -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
     aria-labelledby="updateModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="updateModalLabel">
                    <fmt:message key="demo.blog"/>
                </h3>
            </div>
            <div class="modal-body">
                <jsp:include page="blog_modal_update.jsp"/>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal"><fmt:message
                        key="global.text.close"/></a> <a
                    href="javascript:ferriswheel.tableUpdateFormModalOK(crud_paras)"
                    class="btn btn-primary"><fmt:message key="global.text.ok"/></a>
            </div>
        </div>
    </div>
</div>
<!-- /update -->
<!-- view -->
<div class="modal fade" id="viewModal" tabindex="-1" role="dialog"
     aria-labelledby="viewModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="viewModalLabel">
                    <fmt:message key="demo.blog"/>
                </h3>
            </div>
            <div class="modal-body">
                <jsp:include page="blog_modal_view.jsp"/>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn" data-dismiss="modal"><fmt:message
                        key="global.text.close"/></a>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    var blogurl = "<c:url value='/demo/datatables/blog.do'/>";
    var oTable;
    var aoColumns_def = [ {
        "mData" : "title"
    }, {
        "mData" : "category"
    }, {
        "mData" : "author"
    }, {
        "mData" : "url"
    }, {
        "mData" : "publishDate"
    }, {
        "mData" : null
    } ];
    var crud_paras = $.extend(true, ferriswheel.def_crud_paras, {
        "baseURL" : blogurl,
        "tableID" : "#blog_list",
        "formID" : "#blog_form"
    })
    var asInitVals = new Array();
    $(document).ready(function() {
        var dt_oSetting={
            "searching": false,
            "ordering": false,
            "bRetrieve": true,
            "bProcessing": true,
            "bServerSide": true,
            "autoWidth": true,
            "fnServerParams": function (aoData) {
                $("tfoot input.search_val").each(function () {
                    aoData.push({"name": this.name, "value": this.value});
                });
            },
            "aoColumnDefs": [{
                "aTargets": [-1],
                "bSortable": false,
                "mRender": function (data, type, full) {
                    var id = full.id;
                    return '<a class="btn" href="javascript:ferriswheel.tableShowView(crud_paras,' + id + ')"><span class="glyphicon glyphicon-eye-open"></span></a>'
                            + '<a class="btn" href="javascript:ferriswheel.tableShowUpdate(crud_paras,' + id + ')"><span class="glyphicon glyphicon-edit"></span></a>'
                            + '<a class="btn" href="javascript:ferriswheel.tableDelete(crud_paras,' + id + ')"><span class="glyphicon glyphicon-remove"></span></i></a>';
                }
            }
            ]
        };

        $.extend(true, dt_oSetting, {
            "sAjaxSource" : blogurl + "?method=pageQuery",
            "aoColumns" : aoColumns_def
        });
        oTable = $(crud_paras['tableID']).dataTable(dt_oSetting);

        $("tfoot input").keyup(function() {
            oTable.fnFilter(this.value, $("tfoot input").index(this));
        });

        $("tfoot input").each(function(i) {
            asInitVals[i] = this.value;
        });

        $("tfoot input").focus(function() {
            if (this.className == "search_init") {
                this.className = "search_val";
                this.value = "";
            }
        });

        $("tfoot input").blur(function(i) {
            if (this.value == "") {
                this.className = "search_init";
                this.value = asInitVals[$("tfoot input").index(this)];
            }
        });
    });

</script>