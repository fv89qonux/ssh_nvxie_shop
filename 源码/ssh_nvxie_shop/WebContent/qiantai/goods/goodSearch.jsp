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
		  	                <div class="list_bar">&nbsp;特价区</div>
						  	<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align="center" bgcolor="#FAFAF1" height="22">
					                  <td>商品名称</td>
					                  <td>市场价</td>
					                  <td>特价</td>
					                  <td>商品图片</td>
					                  <td>操作</td>
					              </tr>
								  <s:iterator value="#request.goodsList" id="goods">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td><s:property value="#goods.goodsName"/></td>
									  <td>￥<s:property value="#goods.goodsShichangjia"/></td>
									  <td>
									      <s:if test="#goods.goodsShichangjia==#goods.goodsTejia">
									          无特价
									      </s:if>
									      <s:else>
									        <s:property value="#goods.goodsTejia"/>
									      </s:else>
									  </td>
									  <td><a href="<%=path %>/goodsDetail.action?goodsId=<s:property value="#goods.goodsId"/>"> <img src="<%=path %>/<s:property value="#goods.goodsPic"/>" width="60" height="60" border="0"/> </a></td>
									  <td><a href="<%=path %>/goodsDetail.action?goodsId=<s:property value="#goods.goodsId"/>"><img alt="" src="<%=path %>/images/icon_buy.gif" border=0/></a></td>
								  </tr>
								  </s:iterator>
		        			</table>
		             </div>
		         </div>	
		         <!-- 浏览过商品 -->
				<% if(request.getSession().getAttribute("user")!=null&&request.getAttribute("userGoodsList")!=null){%>
				<div class="left_row">
					<div class="list pic_news">
						<div class="list_bar">
							 <span style="float:left">为你推荐</span>
							 <span style="float:right">&nbsp;</span>
						</div>
						<div id="tw" class="list_content">
							<div style="width:100%;overflow:hidden;white-space:nowrap;">
								<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0">
									<tr>
									    <s:iterator value="#request.userGoodsList" id="goods">
										<td>
											<table width="100%" cellpadding="0" cellspacing="0" border="0">
												<tr>
													<td sytle="height:28px;">
														<dl style="width:100%;height:190px;padding-right:10px;">
															<dd style="margin-left:0;">
																<a href="<%=path %>/goodsDetail.action?goodsId=<s:property value="#goods.goodsId"/>">
																   <img width="115" height="140" src="<%=path %>/<s:property value="#goods.goodsPic"/>"/>
																</a>
															</dd>
															<dt>
																<s:property value="#goods.goodsName"/>
															</dt>
															<dt>
																市场价:<s:property value="#goods.goodsShichangjia"/>
															</dt>
														</dl>
													</td>
												</tr>
											</table>
										</td>
										</s:iterator>
									</tr>
								</table>
							</div>
						 </div>
					</div>
				</div> 
				<%} %>
				<!--浏览过商品 -->
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
