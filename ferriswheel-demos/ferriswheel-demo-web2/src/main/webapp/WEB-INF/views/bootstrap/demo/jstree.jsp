<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title>jstree Demo</title>

    <!-- jstree-->
    <script type="text/css" rel="stylesheet"src="<c:url value='/static/plugins/jstree/3.2.1/css/default/style.min.css'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/jstree/3.2.1/js/jstree.min.js'/>"></script>
</head>

<div id="jstree_demo_div">
</div>
<script language="JavaScript">
    $(function () {
        $('#jstree_demo_div').jstree({
            'core': {
                'data': [
                    {"id": "ajson1", "parent": "#", "text": "Simple root node"},
                    {"id": "ajson2", "parent": "#", "text": "Root node 2"},
                    {"id": "ajson3", "parent": "ajson2", "text": "Child 1"},
                    {"id": "ajson4", "parent": "ajson2", "text": "Child 2"},
                ]
            }
        });
    });
</script>