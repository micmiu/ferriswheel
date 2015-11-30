<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-xs-6 col-md-offset-3">
            <h2>
                <fmt:message key="system.login.header"/>
            </h2>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-6 col-md-offset-3 well">
            <c:choose>
                <c:when
                        test="${shiroLoginFailure eq 'com.micmiu.mvc.ferriswheel.support.shiro.CaptchaException'}">
                    <div class="alert alert-danger">
                        <fmt:message key="system.login.error.captcha"/>
                    </div>
                </c:when>
                <c:when
                        test="${shiroLoginFailure eq 'org.apache.shiro.authc.UnknownAccountException'}">
                    <div class="alert alert-danger">
                        <fmt:message key="system.login.error.unknown"/>
                    </div>
                </c:when>
                <c:when
                        test="${shiroLoginFailure eq 'org.apache.shiro.authc.IncorrectCredentialsException'}">
                    <div class="alert alert-danger">
                        <fmt:message key="system.login.error.incorrect"/>
                    </div>
                </c:when>
                <c:when test="${shiroLoginFailure ne null}">
                    <div class="alert alert-danger">
                        <fmt:message key="system.login.error.failure"/>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info">
                        <fmt:message key="system.login.tips"/>
                    </div>
                </c:otherwise>
            </c:choose>

            <form id="frmlogin" name="frmlogin" class="form-horizontal"
                  action="${ctx }/login.do" method="post">
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label"><fmt:message
                            key='system.login.username'/></label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control required" id="username" name="username"
                               placeholder="<fmt:message key='global.msg.pleaseinput' /><fmt:message key='system.login.username' />">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label"><fmt:message
                            key='system.login.passwd'/></label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control required" id="password" name="password"
                               placeholder="<fmt:message key='global.msg.pleaseinput' /><fmt:message key='system.login.passwd' />">
                    </div>
                </div>
                <div class="form-group">
                    <label for="captcha" class="col-sm-2 control-label"><fmt:message
                            key='system.login.captcha'/></label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control required" id="captcha" name="captcha"
                               placeholder="<fmt:message key='global.msg.pleaseinput' /><fmt:message key='system.login.captcha' />">
                        <img title="<fmt:message key='global.text.refresh' />" align="top" id="img_captcha"
                             onclick="javascript:refreshCaptcha();" src="servlet/captchaCode">
                        (<a href="javascript:;" onclick="javascript:refreshCaptcha()"><fmt:message
                            key='global.text.refresh'/></a>)
                    </div>
                </div>
                <button type="submit" class="btn btn-default" onclick="frmsubmit()">
                    <fmt:message key="global.text.login"/></button>
            </form>
        </div>
    </div>
</div>
<!--/.container-->
<script type="text/javascript">
    var _captcha_id = "img_captcha";
    function refreshCaptcha() {
        var _obj = document.getElementById(_captcha_id);
        _obj.src = "servlet/captchaCode?t=" + Math.random();
    }
    function frmsubmit() {
        console.info($("#frmlogin").valid());
        return $("#frmlogin").valid();
    }
</script>