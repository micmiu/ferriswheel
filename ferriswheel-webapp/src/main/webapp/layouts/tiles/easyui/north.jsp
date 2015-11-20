<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/static/tags/taglibs.jsp" %>
<div>
    <div id="title">
        <div class="title left">
            <fmt:message key="global.project.title"/>
        </div>
        <div style="float: right;">
			<span class="subtitle right"><fmt:message
                    key="global.msg.hello"/>, ${loninName} <shiro:principal
                    property="name"/>!!【 <select id="locale" name="locale"
                                                 onchange="changeLang(this.value)">
                <option value="zh_CN">
                    <fmt:message key="global.text.lang.zh_CN"/>
                </option>
                <option value="en">
                    <fmt:message key="global.text.lang.en"/>
                </option>
            </select> <a href="${ctx}/logout.do"><fmt:message key="global.text.logout"/> </a> 】 </span>
        </div>
    </div>
</div>

<script type="text/javascript">
    <c:set var="LOCALE" value="${sessionScope['org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE']}"/>
    <c:choose>
    <c:when test="${ empty LOCALE}">
    $("#locale").val("zh_CN");
    </c:when>
    <c:otherwise>
    $("#locale").val("${LOCALE}");
    </c:otherwise>
    </c:choose>

    function setLangValue(val) {
        $("#locale").val(val);
    }
    function changeLang(lang) {
        $.ajax({
            type: "post",
            url: '<c:url value="/demo/i18n/change.do"/>',
            data: "locale=" + lang,
            async: true,
            error: function (data, error) {
                alert("change lang error!");
            },
            success: function (data) {
                window.location.reload();
            }
        });
    }
</script>