<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
        <div class="foot_pic"></div>
        
        <table width="100%" align="center" border="0" cellspacing="0" cellpadding="0"  bordercolor="#CCCCCC">

      <td align="center" >　Copyright &copy;  Inc. All Rights  Reserved.  版权所有<br>
      <a target="_blank" href="<%=path %>/login.jsp">管理登录</a>
      </td>
  </tr>
      </table>
		<div class="left foot_msg">
			
			
			<br />
			<br />
		</div>
		<div style="clear: both"></div>
  </body>
</html>
