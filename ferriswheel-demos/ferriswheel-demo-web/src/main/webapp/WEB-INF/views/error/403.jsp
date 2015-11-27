<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>403 - 用户权限不足</title>
	<style type=text/css>
		body {FONT-SIZE: 9pt;COLOR: #842b00;LINE-HEIGHT: 16pt;FONT-FAMILY: "Tahoma", "宋体";TEXT-DECORATION: none}
		table {FONT-SIZE: 9pt;COLOR: #842b00;LINE-HEIGHT: 16pt;FONT-FAMILY: "Tahoma", "宋体";TEXT-DECORATION: none}
		tbody {SCROLLBAR-HIGHLIGHT-COLOR: buttonface;SCROLLBAR-SHADOW-COLOR: buttonface;SCROLLBAR-3DLIGHT-COLOR: buttonhighlight;SCROLLBAR-TRACK-COLOR: #eeeeee;BACKGROUND-COLOR: #ffffff}
		td {FONT-SIZE: 9pt;COLOR: #842b00;LINE-HEIGHT: 16pt;FONT-FAMILY: "Tahoma", "宋体";TEXT-DECORATION: none}
		a {FONT-SIZE: 9pt;COLOR: #ff0000;LINE-HEIGHT: 16pt;FONT-FAMILY: "Tahoma", "宋体";TEXT-DECORATION: none}
		a:hover {FONT-SIZE: 9pt;COLOR: #0188d2;LINE-HEIGHT: 16pt;FONT-FAMILY: "Tahoma", "宋体";TEXT-DECORATION: underline}
		H1 { FONT-SIZE: 9pt; FONT-FAMILY: "Tahoma", "宋体"}
	</style>
</head>

<body>
	<div style="padding-top: 80px">
		<table cellspacing="0" width="600" align="center" border="0" cellpadding="0" >
			<tbody>
				<tr>
					<td align="center"><img height=100 src="${ctx}/static/images/404.jpg"
						width="100" border="0" /></td>
					<td>
						<h1>权限不足</h1> 无法操作。

						<p>☉ 请尝试以下操作：</p>
						<ul>
							<li>确保当前用户拥有此操作权限。</li>

							<li>如有疑问请与系统管理员联系。</li>

							<li>单击 <a href="javascript:history.back(1)">后退</a> 按钮尝试返回 或
								<a href="<c:url value=’/‘/>"> 直接返回首页 </a></li>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
