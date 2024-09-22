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
	        
	        function dingNoTejiaAdd()
           {
                 var url="<%=path %>/qiantai/ding/dingAllNoTejiaAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function dingNoTejiaDel(goodsId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/dingNoTejiaDelQian.action?goodsId="+goodsId;
               }
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
		  	                <div class="list_bar">&nbsp;定制信息</div>
						  	<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align="center" bgcolor="#FAFAF1" height="22">
					                  <td>名称</td>
					                  <td>材质</td>
					                  <td>数量</td>
					                  <td>描述</td>
					                  <td>图示</td>
					                  <td>操作</td>
					                  <td>姓名</td>
					              </tr>
								  <s:iterator value="#request.dingList" id="ding">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td><s:property value="#ding.goodsName"/></td>
									  <td><s:property value="#ding.goodsYanse"/></td>
									  <td><s:property value="#ding.goodsKucun"/></td>
									  <td><s:property value="#ding.goodsMiaoshu"/></td>
									  <td><a href="<%=path %>/<s:property value="#ding.goodsPic"/>"> <img src="<%=path %>/<s:property value="#ding.goodsPic"/>" width="60" height="60" border="0"/> </a></td>
									  <td>
									  <a href="#" onclick="dingNoTejiaDel(<s:property value="#ding.goodsId"/>)" class="pn-loperator">删除</a>
									  <%-- <a href="<%=path %>/dingDetail.action?goodsId=<s:property value="#ding.goodsId"/>"><img alt="" src="<%=path %>/images/icon_buy.gif" border=0/></a> --%>
									  </td>
									  <td><s:property value="#ding.xingming"/></td>
								  </tr>
								  </s:iterator>
		        			</table>
		        			<%--<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
							  <tr>
							    <td>
							        <input type="button" value="添加" style="width: 80px;" onclick="dingNoTejiaAdd()" />
							    </td>
							  </tr>
						    </table>--%>
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
