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
        <p>2015.11.07陪我媳妇hazel去苏州看了周杰伦摩天轮演唱会（基本上没几首歌是我听过的......）<br>
            当时正好要准备一个web的基础开发框架，故给它命名为Ferriswheel。
        </p>
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