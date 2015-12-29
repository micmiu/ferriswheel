<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title><fmt:message key='module.datatables'/> - blog</title>
    <!-- datatables-->
    <link type="text/css" rel="stylesheet" href="<c:url value='/static/plugins/datatables/1.10.10/css/dataTables.bootstrap.css'/>">
    <script type="text/javascript" src="<c:url value='/static/plugins/datatables/1.10.10/js/jquery.dataTables.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/datatables/1.10.10/js/dataTables.bootstrap.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/datatables/datatables.ext.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/js/ferriswheel.tables.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/datatables/1.10.10/i18n/default.settings-zh_CN.js'/>"></script>

</head>
<div class="row">
    <div class="col-xs-12">
        <table id="blog_list"
               class="table table-striped table-bordered bootstrap-datatable">
            <thead>
            <tr>
                <th width="5%"><input type="checkbox" name="check8" value=""></th>
                <th width="20%"><fmt:message key="demo.blog.col.title" /></th>
                <th width="15%"><fmt:message key="demo.blog.col.category" /></th>
                <th width="10%"><fmt:message key="demo.blog.col.author" /></th>
                <th width="25%"><fmt:message key="demo.blog.col.url" /></th>
                <th width="10%"><fmt:message key="demo.blog.col.publishDate" /></th>
                <th width="15%"><fmt:message key="global.text.operation" /> <a
                        class="btn btn-inverse" title="add"
                        href="javascript:hx.tableShowCreate(crud_paras)"><i
                        class="icon-plus-sign icon-white"></i></a></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
            <tfoot>
            <tr>
                <th></th>
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
<div class="modal hide fade" id="createModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>
            <fmt:message key="demo.gd.blog" />
        </h3>
    </div>
    <div class="modal-body">
        <jsp:include page="blog_modal_create.jsp" />
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal"><fmt:message
                key="global.text.close" /></a> <a
            href="javascript:ferriswheel.tableCreateFormModalOK(crud_paras)"
            class="btn btn-primary"><fmt:message key="global.text.ok" /></a>
    </div>
</div>
<!-- /create -->
<!-- update -->
<div class="modal hide fade" id="updateModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>
            <fmt:message key="demo.gd.blog" />
        </h3>
    </div>
    <div class="modal-body">
        <jsp:include page="blog_modal_update.jsp" />
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal"><fmt:message
                key="global.text.close" /></a> <a
            href="javascript:hx.tableUpdateFormModalOK(crud_paras)"
            class="btn btn-primary"><fmt:message key="global.text.ok" /></a>
    </div>
</div>
<!-- /update -->
<!-- view -->
<div class="modal hide fade" id="viewModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>
            <fmt:message key="demo.gd.blog" />
        </h3>
    </div>
    <div class="modal-body">
        <jsp:include page="blog_modal_view.jsp" />
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal"><fmt:message
                key="global.text.close" /></a>
    </div>
</div>
<script type="text/javascript">
    var blogurl = "<c:url value='/demo/datatables/blog.do'/>";
    var oTable;
    var aoColumns_def = [ {
        "mData" : null
    }, {
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

        var oSetting = $.extend(true, ferriswheel.table_oSettings, {
            "sAjaxSource" : blogurl + "?method=pageQuery",
            "aoColumns" : aoColumns_def
        });
        oTable = $(crud_paras['tableID']).dataTable(oSetting);

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