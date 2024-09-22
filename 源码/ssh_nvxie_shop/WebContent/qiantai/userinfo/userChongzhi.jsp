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
		  	                <div class="list_bar">&nbsp;用户充值</div>
						  	    <form action="<%=path %>/userChongzhi.action" name="form1" method="post">
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
												充值金额：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<input type="text" name="money"  value="${sessionScope.user.money }"/>
												
											</td>
											
												
											
										</tr>
										<tr>
											<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
												付款方式：
											</td>
											<td bgcolor="#FFFFFF">
												&nbsp;
												<select name="type" style="width: 260px;">
															 <option value="1">微信</option>
											                  <option value="2">支付宝</option>
											                 <!--  <option value="3">班干部</option> -->
											                  <!-- <option value="4">信息安全</option>
											                  <option value="5">大数据</option>
											                  <option value="6">HTML5</option>
											                  <option value="7">SAP</option>
											                  <option value="8">UI</option>
											                  <option value="9">移动互联网</option> -->
											     </select>
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
