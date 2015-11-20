<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<div class="easyui-accordion" style="width: 200px; height: auto;">
    <shiro:user>
        <div title="<fmt:message key="global.text.menu" />" data-options="iconCls:'icon-search'"
             style="padding: 10px;">
            <ul id="menu-tree">
            </ul>
        </div>
    </shiro:user>
    <div title="<fmt:message key="global.text.about" />" data-options="iconCls:'icon-ok'"
         style="overflow: auto; padding: 10px;">

        <h1><fmt:message key="global.text.summary"/></h1>
        <ul>
            <li>SpringMVC 3.2</li>
            <li>Hibernate 4.19</li>
            <li>Tiles 2.2,2</li>
            <li>shiro 1.2.0</li>
            <li>jQuery+easyui</li>
        </ul>
        <p>
            <fmt:message key="global.text.more"/>:<a href="http://www.micmiu.com" target="_blank">micmiu.com</a>
        </p>
    </div>
    <div title="<fmt:message key="global.text.help" />" data-options="iconCls:'icon-help'"
         style="padding: 10px;">
        <p>
            <a href="Mailto:sjsky007@gmail.com"><fmt:message key="global.text.mailto"/></a>
        </p>
    </div>
</div>

<script type="text/javascript">
    $('#menu-tree').tree({
        url: '<c:url value="/system/user.do?method=getUserMenu"/>'
    })
</script>