<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter" %>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException" %>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<html>
<body style="width: 99%">
<div>
    <c:choose>
        <c:when test="${shiroLoginFailure eq 'com.micmiu.mvc.ferriswheel.support.shiro.CaptchaException'}">
            <div class="error-msg prepend-top"><fmt:message key="system.login.error.captcha"/>.</div>
        </c:when>
        <c:when test="${shiroLoginFailure eq 'org.apache.shiro.authc.UnknownAccountException'}">
            <div class="error-msg prepend-top"><fmt:message key="system.login.error.unknown"/></div>
        </c:when>
        <c:when test="${shiroLoginFailure eq 'org.apache.shiro.authc.IncorrectCredentialsException'}">
            <div class="error-msg prepend-top"><fmt:message key="system.login.error.incorrect"/></div>
        </c:when>
        <c:when test="${shiroLoginFailure ne null}">
            <div class="error-msg prepend-top"><fmt:message key="system.login.error.failure"/></div>
        </c:when>
    </c:choose>
    <form:form id="loginForm" action="${ctx}/login.do" method="post">
        <fieldset class="prepend-top">
            <legend><fmt:message key="global.text.login" /> </legend>
            <div class="field">
                <label for="username" class="field"><fmt:message key='system.login.username'/>:</label>
                <input type="text" id="username" name="username" size="25" value="${username}" class="required"/>
            </div>
            <div class="field">
                <label for="password" class="field"><fmt:message key='system.login.passwd'/>:</label>
                <input type="password" id="password" name="password" size="25" class="required"/>
            </div>
            <div class="field">
                <label for="captcha" class="field"><fmt:message key='system.login.captcha'/>:</label>
                <input type="text" id="captcha" name="captcha" size="4" maxlength="4" class="required"/>
            </div>
            <div class="field">
                <label for="img_captcha" class="field"></label><img title="<fmt:message key='global.text.refresh' />" id="img_captcha"
                     onclick="javascript:refreshCaptcha();" src="servlet/captchaCode">(<a
                    href="javascript:void(0)" onclick="javascript:refreshCaptcha()"><fmt:message
                    key='global.text.refresh'/></a>)
            </div>
        </fieldset>
        <div>
            <input type="checkbox" id="rememberMe" name="rememberMe"/> <label
                for="rememberMe"><fmt:message key='global.text.remember'/></label> <span
                style="padding-left: 10px;"><input
                id="submit" class="button" type="submit" value="<fmt:message key='global.text.login' />"/></span>
        </div>
        <div>
            (管理员<b>admin/admin</b>, 普通用户<b>user/user</b>)
        </div>
    </form:form>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#loginForm").validate();
    });
    var _captcha_id = "#img_captcha";
    function refreshCaptcha() {
        $(_captcha_id).attr("src", "servlet/captchaCode?t=" + Math.random());
    }
</script>
</html>
