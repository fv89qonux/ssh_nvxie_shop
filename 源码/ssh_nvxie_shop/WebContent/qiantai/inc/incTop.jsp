<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head><link rel="stylesheet" type="text/css" href="<%=path %>/css/font.css">

      <script type="text/javascript">
	        function myXinxi()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                var url="<%=path %>/qiantai/userinfo/userXinxi.jsp";
	              /*   var n="";
	                var w="480px";
	                var h="500px";
	                var s="resizable:no;help:no;status:no;scroll:yes";
				    openWin(url,n,w,h,s); */
				     window.location.href=url;
	            </s:else>
	        }
	        function myCart()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myCart.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function myOrder()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var s="<%=path %>/myOrder.action";
	                 window.location.href=s;
	            </s:else>
	        }
	        
	        function liuyanAll()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var url="<%=path %>/liuyanAll.action";
				     window.open(url,"_blank");
	            </s:else>
	        }
	        function dingAll()
	        {
	            <s:if test="#session.user==null">
	                  alert("请先登录");
	            </s:if>
	            
	            <s:else>
	                 var url="<%=path %>/dingManaNoTejiaMyQian.action";
				     window.open(url,"_blank");
	            </s:else>
	        }
			function dingAdd()
			{
				<s:if test="#session.user==null">
				alert("请先登录");
				</s:if>

				<s:else>
				var url="<%=path %>/qiantai/ding/dingAllNoTejiaAdd.jsp";
				window.open(url,"_blank");
				</s:else>
			}
      </script>
  </head>
  
  <body>
       <table width="1040" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td   align="center">
<img width="980" height="100" src=" <%=path %>/images/banner4.jpg ">
	</td>
      </tr>
    </table>
    <table width="980" border="0" align="center" cellpadding="0" cellspacing="0" >

  <tr>
	  <td width="980" height="48"  style="background-color:#2196F3">&nbsp;&nbsp;&nbsp;&nbsp;
	    <a href="<%=path %>/qiantai/default.jsp" style="color:#fff;font-size:14px;font-weight:bold">本站首页</a>&nbsp; &nbsp;|&nbsp;
	    <a href="<%=path %>/goodsAllNoTejia.action" style="color:#fff;font-size:14px;font-weight:bold">最新产品</a>&nbsp;|&nbsp;
	    <a href="<%=path %>/goodsAllYesTejia.action" style="color:#fff;font-size:14px;font-weight:bold">特价区域</a>&nbsp;|&nbsp;
		  <a href="<%=path %>/xinwenManaQian.action" style="color:#fff;font-size:14px;font-weight:bold">在线新闻</a>&nbsp;|&nbsp;
		  <a href="#" onclick="myCart()" style="color:#fff;font-size:14px;font-weight:bold">我的购物车</a>&nbsp;|&nbsp;
	    <a href="#" onclick="myOrder()" style="color:#fff;font-size:14px;font-weight:bold">我的订单</a>&nbsp;|&nbsp;
	    <a href="#" onclick="myXinxi()" style="color:#fff;font-size:14px;font-weight:bold">我的信息</a>&nbsp;|&nbsp;
	    <a onclick="liuyanAll()" href="#" style="color:#fff;font-size:14px;font-weight:bold">我要留言</a>&nbsp;|&nbsp;
	    <a onclick="dingAll()" href="#" style="color:#fff;font-size:14px;font-weight:bold">我的定制</a>&nbsp;|&nbsp;
		  <a onclick="dingAdd()" href="#" style="color:#fff;font-size:14px;font-weight:bold">我要定制</a>
    </td>
	
      	    </td>
  </tr>

</table>
		<form id="searchForm" action="<%=path %>/goodSearch.action" method="post">
			<div class="topsearch">
				<div class="title"></div>
				<div id="page_search_left">
					<input class="inputText" id="goodsName" size="16" onkeypress="if(event.keyCode==13){searchFormSubmit();return false;}" name="goodsName" type="text" />
				</div>
				<div id="page_search_btn">
					<input type="submit" value="搜索">
				</div>
				<div id="page_search_right">
					<script>
						<!--var day="";
						var month="";
						var ampm="";
						var ampmhour="";
						var myweekday="";
						var year="";
						mydate=new Date();
						myweekday=mydate.getDay();
						mymonth=mydate.getMonth()+1;
						myday= mydate.getDate();
						year= mydate.getFullYear();
						if(myweekday == 0)
						weekday=" 星期日 ";
						else if(myweekday == 1)
						weekday=" 星期一 ";
						else if(myweekday == 2)
						weekday=" 星期二 ";
						else if(myweekday == 3)
						weekday=" 星期三 ";
						else if(myweekday == 4)
						weekday=" 星期四 ";
						else if(myweekday == 5)
						weekday=" 星期五 ";
						else if(myweekday == 6)
						weekday=" 星期六 ";
						document.write(year+"年"+mymonth+"月"+myday+"日 "+weekday);
						//-->
					</script>
				</div>
				<div style="clear: both"></div>
			</div>
		</form>
  </body>
</html>
