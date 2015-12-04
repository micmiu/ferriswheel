<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<head>
    <title>Bootstrap-treeview Demo</title>
</head>

<div id="tree"></div>
<script type="text/javascript">
    function getTree() {
        var data=[
            {
                text: "Parent 1",
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