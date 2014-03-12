<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Captcha image test</title>
</head>
<body>
<table>
<tr>
<td style="width:100px;">Captcha : </td>
<td style="border:1px solid #CCC;padding:25px;border-radius:5px; box-shadow: 5px 5px 5px 5px #CCCCCC;">
<img src="<%= request.getContextPath() %>/captcha.jpg" />
</td>
</tr>
<tr><td colspan="2" style="padding-top:25px;color:#C00;">* Please refresh this page to get new Captcha image.</td></tr>
</table>
</body>
</html>