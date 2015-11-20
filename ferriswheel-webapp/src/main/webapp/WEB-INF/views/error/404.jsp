<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp"%>

<%
	response.setStatus(200);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>404 - 页面不存在</title>
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
		<table cellspacing="0" width="600" align="center" border="0"
			cellpadding="0">
			<tbody>
				<tr>
					<td align="center"><img height=100 src="${ctx}/static/images/404.jpg"
						width="100" border="0" /></td>
					<td>
						<h1>无法找到该页</h1> HTTP 错误 404：您正在搜索的页面可能已经删除、更名或暂时不可用。

						<p>☉ 请尝试以下操作：</p>
						<ul>
							<li>确保浏览器的地址栏中地址的拼写和格式正确无误。</li>

							<li>如果问题仍存在，请 <a href="Mailto:sjsky007@gmail.com">发送邮件</a>
								与网站管理员联系。
							</li>

							<li>单击 <a href="javascript:history.back(1)">后退</a> 按钮尝试返回 或
								<a href="<c:url value="/"/>"> 直接返回首页 </a>
							</li>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>