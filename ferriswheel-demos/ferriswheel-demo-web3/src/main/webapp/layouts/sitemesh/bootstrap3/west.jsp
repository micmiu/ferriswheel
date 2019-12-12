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
                    <fmt:message key="global.text.about"/>
                </a>
            </h4>
        </div>
        <div id="collapse2" class="panel-collapse collapse">
            <div class="panel-body">
                <p>取名源于11.07陪媳妇hazel去苏州看了周杰伦摩天轮《Ferriswheel》演唱会（基本上没几首歌是我听过的......）
                </p>
            </div>
        </div>
    </div>
    <div class="panel panel-warning">
        <div class="panel-heading">
            <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion"
                   href="#collapse3">
                    <fmt:message key="global.text.help"/>
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