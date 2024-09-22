<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'menu.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/menu.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#940808;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#940808;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#940808;
		}
		
		dl.bitem {
			width:148px;
			margin:0px 0px 5px 4px;
		}
		
		dl.bitem dt {
		  background:url(<%=path %>/images/menu_bg.jpg);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		}
		
		dl.bitem dd {
		  padding:3px 3px 3px 3px;
		  background-color:#fff;
		}
		
		.fllct
		{
			float:left;
			
			width:90px;
		}
		
		.flrct
		{
			padding-top:3px;
			float:left;
		}
		
		div.items
		{
			line-height:22px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 9px;
		}
		
		span.items
		{
			padding:10px 0px 10px 22px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 12px;
		}
		
		ul {
		  padding-top:3px;
		}
		
		li {
		  height:22px;
		}
		
		.sitemu li {
			padding:0px 0px 0px 22px;
			line-height:24px;
			background:url(<%=path %>/images/arr4.gif) no-repeat 10px 9px;
		}
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="<%=path %>/js/menu.js"></script>
	<base target="main" />
  </head>
  
  <body target="main">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">

			<c:if test="${sessionScope.userType==0}">
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items2_1")'><b>管理员</b></dt>
					<dd style='display:block' class='sitem' id='items2_1'>
						<ul class='sitemu'>

							<li><a href='<%=path %>/admin/user/userXinxiSet.jsp' target='main'>个人资料</a> </li>
							<li><a href='<%=path %>/admin/user/userPw.jsp' target='main'>密码修改</a> </li>

						</ul>
					</dd>
				</dl>
				<!-- 1 -->
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items1_1")'><b>用户管理</b></dt>
					<dd style='display:block' class='sitem' id='items1_1'>
						<ul class='sitemu'>

							<li><a href='<%=path %>/userMana.action' target='main'>用户管理</a> </li>


						</ul>
					</dd>
				</dl>
				<!-- 1 -->
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items3_1")'><b>公告管理</b></dt>
					<dd style='display:block' class='sitem' id='items3_1'>
						<ul class='sitemu'>

							<li><a href='<%=path %>/gonggaoMana.action' target='main'>公告管理</a> </li>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items5_1")'><b>商品管理</b></dt>
					<dd style='display:block' class='sitem' id='items5_1'>
						<ul class='sitemu'>
							<li><a href='<%=path %>/catelogMana.action' target='main'>商品类别管理</a> </li>
							<li><a href='<%=path %>/pinpaiMana.action' target='main'>商品品牌管理</a> </li>
							<li><a href='<%=path %>/goodsManaNoTejia.action' target='main'>商品管理</a> </li>
							<li><a href='<%=path %>/admin/goods/goodsNoTejiaAdd.jsp' target='main'>添加商品</a> </li>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->

				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items555_1")'><b>新闻管理</b></dt>
					<dd style='display:block' class='sitem' id='items555_1'>
						<ul class='sitemu'>
							<li><a href='<%=path %>/leibieMana.action' target='main'>分类管理</a> </li>
							<%--<li><a href='<%=path %>/pinpaiMana.action' target='main'>商品品牌管理</a> </li>--%>
							<li><a href='<%=path %>/xinwenMana.action' target='main'>新闻管理</a> </li>
							<%--<li><a href='<%=path %>/admin/goods/goodsNoTejiaAdd.jsp' target='main'>添加商品</a> </li>--%>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->

				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items55_1")'><b>定制管理</b></dt>
					<dd style='display:block' class='sitem' id='items55_1'>
						<ul class='sitemu'>

							<li><a href='<%=path %>/dingManaNoTejia.action' target='main'>定制管理</a> </li>
								<%-- <li><a href='<%=path %>/dingManaNoTejiaMy.action' target='main'>我的定制管理</a> </li>
                                 <li><a href='<%=path %>/admin/ding/dingNoTejiaAdd.jsp' target='main'>添加定制</a> </li> --%>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->

				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items6_1")'><b>订单管理</b></dt>
					<dd style='display:block' class='sitem' id='items6_1'>
						<ul class='sitemu'>
								<%--  <li><a href='<%=path %>/userMana.action' target='main'>会员管理</a> </li> --%>
							<li><a href='<%=path %>/orderMana.action' target='main'>订单管理</a> </li>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items6_1")'><b>财务管理</b></dt>
					<dd style='display:block' class='sitem' id='items6_1'>
						<ul class='sitemu'>
							<li><a href='<%=path %>/goodsKucun.action' target='main'>库存管理</a> </li>
							<li><a href='<%=path %>/caiwuMana.action' target='main'>财务统计</a> </li>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->
				<!-- 1 -->
				<dl class='bitem'>
					<dt onClick='showHide("items99_1")'><b>留言管理</b></dt>
					<dd style='display:block' class='sitem' id='items99_1'>
						<ul class='sitemu'>
							<li><a href='<%=path %>/liuyanMana.action' target='main'>留言管理</a> </li>
						</ul>
					</dd>
				</dl>
				<!-- 1 -->
			</c:if>

			<c:if test="${sessionScope.userType==2}">
				<dl class='bitem'>
					<dt onClick='showHide("items22_1")'><b>用户管理</b></dt>
					<dd style='display:block' class='sitem' id='items22_1'>
						<ul class='sitemu'>

							<li><a href='<%=path %>/admin/user/userXinxiSet.jsp' target='main'>个人资料</a> </li>
							<li><a href='<%=path %>/admin/user/userPw.jsp' target='main'>密码修改</a> </li>
							<%--<li><a href='<%=path %>/admin/user/userBz.jsp' target='main'>个人奖金</a> </li>--%>
						</ul>
					</dd>
				</dl>
			</c:if>

	      <!-- 1 -->
		</td>
	  </tr>
	</table>
  </body>
</html>
