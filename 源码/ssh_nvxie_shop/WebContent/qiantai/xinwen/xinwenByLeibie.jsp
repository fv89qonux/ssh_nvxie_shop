<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
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
		function buy1()
		{
			<s:if test="#session.user==null">
			alert("请先登录");
			</s:if>
			<s:else>
			if(document.buy.quantity.value=="")
			{
				alert("请输入购买数量");
				return false;
			}
			document.buy.submit();
			</s:else>
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
				<div class="list_bar">&nbsp;新闻信息</div>
				<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					<c:forEach items="${requestScope.xinwenList}" var="xinwen">
						<div class="c1-bline" style="padding:7px 0px;">
							<div class="f-left">
								<img src="<%=path %>/images/head-mark4.gif" align="middle" class="img-vm" border="0"/>
								<a href="<%=path %>/xinwenDetailQian.action?id=${xinwen.id}">${xinwen.biaoti}</a>
							</div>
							<div class="f-right">${xinwen.shijian}</div>
							<div class="clear"></div>
						</div>
					</c:forEach>
				</table>
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
