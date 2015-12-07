<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title>Bootstrap-treeview Demo</title>

    <!-- treeviewer-->
    <script type="text/css" rel="stylesheet" src="<c:url value='/static/plugins/bootstrap-treeview/1.2.0/css/bootstrap-treeview.css'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/plugins/bootstrap-treeview/1.2.0/js/bootstrap-treeview.js'/>"></script>
</head>

<div id="tree"></div>
<script type="text/javascript">
    function getTree() {
        var data = [
            {
                text: "Parent 1",
                icon: "glyphicon glyphicon-unchecked",
                selectedIcon: "glyphicon glyphicon-check",
                color: "#000000",
                backColor: "#FFFFFF",
                href: "#node-1",
                selectable: true,
                state: {
                    checked: true,
                    disabled: false,
                    expanded: true
                },
                tags: ['available'],
                nodes: [
                    {
                        text: "Child 1",
                        nodes: [
                            {
                                text: "Grandchild 1"
                            },
                            {
                                text: "Grandchild 2"
                            }
                        ]
                    },
                    {
                        text: "Child 2"
                    }
                ]
            },
            {
                text: "Parent 2"
            },
            {
                text: "Parent 3"
            },
            {
                text: "Parent 4"
            },
            {
                text: "Parent 5"
            }
        ];
        return data;
    }

    $('#tree').treeview({data: getTree()});
</script>