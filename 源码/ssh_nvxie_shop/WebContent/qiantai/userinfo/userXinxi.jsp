<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript">
        	function check1()
	    {
	        if(document.form1.loginname.value=="")
	        {
	            alert("请输入账号");
	            return false;
	        }
	        if(document.form1.loginpw.value=="")
	        {
	            alert("请输入密码");
	            return false;
	        }
	        if(document.form1.xingming.value=="")
	        {
	            alert("请输入姓名");
	            return false;
	        }
	        document.form1.submit();
	    }
        
   
    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<!--左边的 -->
			<div class="page_main_msg left">		
		        <div class="left_row">
		            <div class="list pic_news">
		  	                <div class="list_bar">&nbsp;我的信息</div>
						  	    <form action="<%=path %>/userSet.action" name="form1" method="post">
									<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
										<tr>
											<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												用户名：
											</td>
											<td width="80%" bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="loginname" id="loginname" readonly="readonly" value="${sessionScope.user.loginname }"/>
											</td>
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												密 码：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="password" name="loginpw" value="${sessionScope.user.loginpw }"/>
											</td>
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												真实姓名：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="xingming" value="${sessionScope.user.xingming }"/>
											</td>
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												默认地址：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="address" value="${sessionScope.user.address }"/>
											</td>
										</tr>
										
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												联系方式：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="dianhua" value="${sessionScope.user.dianhua }"/>
											</td>
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												年龄：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="nianling" value="${sessionScope.user.nianling }"/>
											</td>
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												余额：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="" readonly="readonly" value="${sessionScope.user.money }"/>
												    <a href="<%=path %>/qiantai/userinfo/userChongzhi.jsp"  >充值</a>
											</td>
											
												
											
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												积分：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="" readonly="readonly" value="${sessionScope.user.jifen }"/>
											</td>
										</tr>
										<%-- <tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												QQ：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="qq" value="${sessionScope.user.qq }"/>
											</td>
										</tr> --%>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9">
												&nbsp;
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="hidden" name="id" value="${sessionScope.user.id }">
												<input type="submit" value="确定"/>
												<!-- <input type="button" value="取消" onclick="closeOpen()"/> -->
											</td>
										</tr>
									</table>
								</form>
		             </div>
		         </div>	
	        </div>
			<!--左边的 -->
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<div class="left_row">
					<div class="list">
						<div class="list_bar">
							用户登录
						</div>
						<div class="list_content">
							<div id="div">
								<jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
                <div class="left_row">
				    <div class="list">
				        <div class="list_bar">商品分类</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										     <s:action name="catelogAll" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
				<div class="left_row">
				    <div class="list">
				        <div class="list_bar">公告</div>
				        <div class="list_content">
				            <div id="div"> 
				                   <div style="overflow:hidden;height:150px;">
							             <div id="roll-orig-1607838439">
										 <s:action name="gonggaoQian5" executeResult="true" flush="true"></s:action>
							             </div>
						                 <div id="roll-copy-1607838439"></div>
				                   </div>
					        </div>
					    </div>
				    </div>
				</div>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
