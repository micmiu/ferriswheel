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
                    property="name"/>,【 <select id="locale" name="locale" style="width:80px"></select>|
                <select id="theme" name="theme" class="easyui-combobox" style="width: 80px">
                </select> | <a href="${ctx}/logout.do"><fmt:message key="global.text.logout"/> </a> 】 </span>
        </div>
    </div>
</div>

<script type="text/javascript">
    var langs = [{value: 'zh_CN', text: '<fmt:message key="global.text.lang.zh_CN"/>'},
        {value: 'en', text: '<fmt:message key="global.text.lang.en"/>'}];
    var themes = [{value: 'default', text: 'Default'}, {value: 'bootstrap', text: 'Bootstrap'},
        {value: 'black', text: 'Black'}, {value: 'gray', text: 'Gray'}, {value: 'metro', text: 'Metro'}
    ];
    $(function(){
        jQuery.i18n.properties({
            name : 'ferriswheel',
            path : '<c:url value="/static/plugins/i18n/"/>',
            mode : 'map',
            language : '${LOCALE}',
            callback : function() {
                //alert($.i18n.prop('global.text.ok'));
            }
        });
    });
    $('#locale').combobox({
        data: langs,
        editable: false,
        panelHeight: 'auto',
        onChange: changeLang,
        onLoadSuccess: function () {
            $(this).combobox('select', '${LOCALE}');
        }
    });
    $('#theme').combobox({
        data: themes,
        editable: false,
        panelHeight: 'auto',
        onChange: changeTheme,
        onLoadSuccess: function () {
            $(this).combobox('select', '${THEME}');
        }
    });
    function setLangValue(val) {
        $("#locale").val(val);
    }
    function changeLang(lang) {
        if (lang == '${LOCALE}') {
            return;
        }
        $.ajax({
            type: "post",
            url: '<c:url value="/demo/i18n/change.do"/>',
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