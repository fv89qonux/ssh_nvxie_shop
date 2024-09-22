<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<script src="<%=path %>/js/jQuery1.7.2.js" type="text/javascript"></script>
	<script src="<%=path %>/js/metinfo_ui.js" type="text/javascript"></script>
	
	<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
    <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
    
	<script type="text/javascript">
	        function reg()
	        {
	                var url="<%=path %>/qiantai/userinfo/userReg.jsp";
	               /*  var n="";
	                var w="480px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s); */
				    window.location.href=url;
	        }
	        /* function login()
	        {
	           if(document.userLogin.loginname.value=="")
	           {
	               alert("请输入用户名");
	               return;
	           }
	           if(document.userLogin.userPw.value=="")
	           {
	               alert("请输入密码");
	               return;
	           }
	           document.userLogin.submit();
	        } */
	        function login()
	        {
	           if(document.userLogin.loginname.value=="")
	           {
	               alert("请输入账号");
	               return;
	           }
	           if(document.userLogin.loginpw.value=="")
	           {
	               alert("请输入密码");
	               return;
	           }
	           //document.getElementById("indicator").style.display="block";
	           loginService.login(document.userLogin.loginname.value,document.userLogin.loginpw.value,1,callback);
	        }
	        
	        function callback(data)
			{
			    //document.getElementById("indicator").style.display="none";
			    
			    if(data=="no")
			    {
			        alert("账号或密码错误");
			        var url="<%=path %>/qiantai/default.jsp";
			        window.location.href=url;
			    }
			    if(data!="no")//返回的data就是用户的id
			    {
					alert("登录成功");
			    	<s:if test="#session.userType==2">
				    	var url="<%=path %>/qiantai/default.jsp";
				        window.location.href=url;
	               </s:if>
					var url="<%=path %>/qiantai/default.jsp";
					window.location.href=url;
	               <%-- <s:else  >
		               var url="<%=path %>/userLogout.action";
				        window.location.href=url;
	               <s:else  > --%>
			        //
			        
			    }
			}
	</script>
  </head>
  
  <body>
       <s:if test="#session.user==null">
			<form action="<%=path %>/userLogin.action" name="userLogin" method="post">
			      <table cellspacing="0" cellpadding="0" width="98%" align="center" border="0">
			          <tr>
			            <td align="center" colspan="2" height="10"></td>
			          </tr>
			          <tr>
			            <td align="right" width="31%" height="30" style="font-size: 11px;">用户名：</td>
			            <td align="left" width="69%"><input class="input" id="loginname" title="用户名不能为空" size="14" name="loginname" type="text" /></td>
			          </tr>
			          <tr>
			            <td align="right" height="30" style="font-size: 11px;">密　码：</td>
			            <td align="left"><input class="input" id="loginpw" type="password" size="14" name="loginpw"/></td>
			          </tr>
			          <tr>
			            <td align="center" colspan="2" height="10"><font color="red"><s:property value="#request.error"/></font></td>
			          </tr>
			          <tr>
			            <td align="center" colspan="2" height="30">
			               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			               <input type="button" value="登  录" onclick="login()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
						   &nbsp;
						   <input type="button" value="注  册" onclick="reg()" style="border:#ccc 1px solid; background-color:#FFFFFF; font-size:12px; padding-top:3px;" />
			            </td>
			          </tr>
			      </table>
		    </form>
		    </s:if>
		    <s:else  >
		        <br/>
			     <a href="<%=path %>/admin/index.jsp">个人中心：<s:property value="#session.user.loginname"/></a> &nbsp;&nbsp;&nbsp;&nbsp;
			    <a href="<%=path %>/userLogout.action">安全退出</a> &nbsp;&nbsp;&nbsp;&nbsp;
			    <br/><br/><br/>
			</s:else>
  </body>
</html>
