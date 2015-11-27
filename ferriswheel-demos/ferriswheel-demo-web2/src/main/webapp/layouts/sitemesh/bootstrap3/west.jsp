<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<div class="panel-group" id="accordion">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapse1">
                    Quick
                </a>
            </h4>
        </div>
        <div id="collapse1" class="panel-collapse collapse in">
            <div class="panel-body">
                <ul>
                    <li>Email</li>
                    <li>Todo</li>
                    <li>Message</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapse2">
                    About
                </a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse">
            <div class="panel-body">
                <ul>
                    <li>SpringMVC 3.2.0.RELEASE</li>
                    <li>Hibernae 4.1.9.Final</li>
                    <li>Sitemesh 2.4.2</li>
                    <li>shiro 1.2.0</li>
                    <li>Bootstrap 3</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="panel panel-warning">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapse3">
                    Help
                </a>
            </h4>
        </div>
        <div id="collapse3" class="panel-collapse collapse">
            <div class="panel-body">
                <ul>
                    <li><a href="Mailto:sjsky007@gmail.com"><fmt:message key="global.text.mailto"/></a></li>
                    <li><a href="<fmt:message key='global.org.info.url' />" target="_blank"><fmt:message
                            key="global.org.info.name"/></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>