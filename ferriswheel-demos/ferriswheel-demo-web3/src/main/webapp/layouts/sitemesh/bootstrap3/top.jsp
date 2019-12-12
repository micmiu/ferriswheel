<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand active" href="<c:url value='/index.do'/>"><fmt:message key="global.text.index"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.system"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="<c:url value='/system/user.do?method=showList'/>"><fmt:message
                                key="menu.system.user"/></a></li>
                        <li><a href="<c:url value='/system/role.do?method=showList'/>"><fmt:message
                                key="menu.system.role"/></a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.demo"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="<c:url value='/demo/bootstrap/index.do'/>"><fmt:message
                                key="menu.demo.common"/></a></li>
                        <li><a href="<c:url value='/demo/jqgrid/blog.do?method=showList'/>"><fmt:message
                                key="menu.demo.crud"/></a></li>
                        <li><a href="<c:url value='/demo/bootstrap/treeview.do'/>"><fmt:message
                                key="menu.demo.treeview"/></a></li>
                        <li><a href="<c:url value='/demo/bootstrap/ztree.do'/>">ztree</a></li>
                        <li><a href="<c:url value='/demo/bootstrap/jstree.do'/>">jstree</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.demo.jqgrid"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="<c:url value='/demo/jqgrid/base.do'/>"><fmt:message
                                key="menu.demo.jqgrid"/>-base</a></li>
                        <li><a href="<c:url value='/demo/jqgrid/list.do'/>"><fmt:message
                                key="menu.demo.jqgrid"/>-list</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.demo.datatables"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="<c:url value='/demo/datatables/base.do'/>"><fmt:message
                                key="menu.demo.datatables"/>-base</a></li>
                        <li><a href="<c:url value='/demo/datatables/query.do'/>"><fmt:message
                                key="menu.demo.datatables"/>-query</a></li>
                        <li><a href="<c:url value='/demo/datatables/blog.do?method=showList'/>"><fmt:message
                                key="menu.demo.datatables"/>-list</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message
                            key="global.msg.hello"/>,<shiro:principal
                            property="name"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#"><fmt:message key="global.text.setting"/></a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value='/logout.do'/>"><fmt:message
                                key="global.text.logout"/></a></li>
                    </ul>
                </li>
                <!-- lang selector starts -->
                <li class="dropdown">
                    <select id="lang" name="lang" class="form-control" onchange="changeLang(this.value)">
                        <option value=""><fmt:message key="global.text.lang"/></option>
                        <option value="zh_CN"><fmt:message key="global.text.lang.zh_CN"/></option>
                        <option value="en"><fmt:message key="global.text.lang.en"/></option>
                    </select>
                    <!--
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <fmt:message key='global.text.lang'/> <span
                            class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" id="lang" role="menu">
                        <li><a data-value="zh_CN" href="#">
                            <fmt:message key="global.text.lang.zh_CN"/></a></li>
                        <li><a data-value="en" href="#">
                            <fmt:message key="global.text.lang.en"/></a></li>
                    </ul>
                    -->
                </li>
                <!-- lang selector ends -->
                <!-- theme selector starts -->
                <li class="dropdown">
                    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#"> <fmt:message
                            key='global.text.theme'/> <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" id="themes">
                        <li><a data-value="classic" href="#"><span class="whitespace"></span>Classic</a></li>
                        <li><a data-value="metro" href="#"><span class="whitespace"></span>Metro</a></li>
                        <li><a data-value="black" href="#"><span class="whitespace"></span>Black</a></li>
                    </ul>
                </li>
                <!-- theme selector ends -->
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<script type="text/javascript">
    $(document).ready(function () {
        $("#lang").val('${LOCALE}');
        $('#themes a[data-value="classic"]').find('span').removeClass('whitespace').addClass('glyphicon glyphicon-ok');
    });
    function changeLang(lang) {
        if (lang == '${LOCALE}') {
            return;
        }
        if (lang == '') {
            $("#lang").val('${LOCALE}');
            return;
        }
        $.ajax({
            type: "post",
            url: '<c:url value="/system/setting/i18n.do"/>',
            data: "locale=" + lang,
            async: true,
            error: function (data, error) {
                alert("<fmt:message key='global.msg.failed'/>");
            },
            success: function (data) {
                window.location.reload();
            }
        });
    }

    function changeTheme(theme) {
        if (theme == '${THEME}') {
            return;
        }
        $.ajax({
            type: "post",
            url: '<c:url value="/system/setting/theme.do"/>',
            data: "theme=" + theme,
            async: true,
            error: function (data, error) {
                alert("<fmt:message key='global.msg.failed'/>");
            },
            success: function (data) {
                window.location.reload();
            }
        });
    }
</script>