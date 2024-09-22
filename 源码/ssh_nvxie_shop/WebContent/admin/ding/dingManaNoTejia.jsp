<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
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
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function dingDetailHou(goodsId)
           {
                 var url="<%=path %>/dingDetailHou.action?goodsId="+goodsId;
                 var n="";
                 var w="480px";
                 var h="500px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
				 openWin(url,n,w,h,s);
           }
           
           function dingNoTejiaDel(goodsId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/dingNoTejiaDel.action?goodsId="+goodsId;
               }
           }
           
            function dingNoTejiaEditPre(goodsId)
           {
              
                   window.location.href="<%=path %>/dingNoTejiaEditPre.action?goodsId="+goodsId;
               
           }
           
           function dingNoTejiaAdd()
           {
                 var url="<%=path %>/admin/ding/dingNoTejiaAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function dingShezhiTejia(goodsId)
           {
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/admin/ding/dingShezhiTejia.jsp?goodsId="+goodsId);
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
           }
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }
		   
		   function userXinxi(id)
           {
                 var url="<%=path %>/userXinxi.action?id="+id;
                 var n="";
                 var w="300px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:yes";
			     openWin(url,n,w,h,s);
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			 <tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;定制管理&nbsp;</td>
				</tr>
						  	<table width="99%" border="0" cellpadding="2" cellspacing="1" bgcolor="#FFFFFF" align="center" style="margin-top:8px">
					              <tr align="center" bgcolor="#FAFAF1" height="22">
					                  <td>名称</td>
					                  <td>材质</td>
					                  <td>数量</td>
					                  <td>描述</td>
					                  <td>用户</td>
					                  <td>图示</td>
					                  
					                  <td>操作 </td>
					              </tr>
								  <s:iterator value="#request.dingList" id="ding">
								  <tr align='center' bgcolor="#FFFFFF" height="22">
									  <td><s:property value="#ding.goodsName"/></td>
									  <td><s:property value="#ding.goodsYanse"/></td>
									  <td><s:property value="#ding.goodsKucun"/></td>
									  <td><s:property value="#ding.goodsMiaoshu"/></td>
									   <td>
						<a href="#" onclick="userXinxi(<s:property value="#ding.uid"/>)" style="color: red">查看用户</a>
					</td>
									  <td><a href="<%=path %>/<s:property value="#ding.goodsPic"/>"> <img src="<%=path %>/<s:property value="#ding.goodsPic"/>" width="60" height="60" border="0"/> </a></td>
									  
									  <td>
									  <a href="#" onclick="dingNoTejiaDel(<s:property value="#ding.goodsId"/>)" class="pn-loperator">删除</a>
									  <%-- <a href="<%=path %>/dingDetail.action?goodsId=<s:property value="#ding.goodsId"/>"><img alt="" src="<%=path %>/images/icon_buy.gif" border=0/></a> --%>
									  </td>
								  </tr>
								  </s:iterator>
		        			</table>
			<%-- <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/images/tbg.gif">&nbsp;定制管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="5%">名称</td>
					<td width="5%">厂商</td>
					<td width="5%">经销商</td>
					<td width="5%">编号</td>
					<td width="5%">材质</td>
					<td width="10%">定制描述</td>
					<td width="10%">分类</td>
					<td width="10%">品牌</td>
					<td width="10%">定制图片</td>
					<td width="5%">市场价格</td>
					<td width="10%">特价</td>
					<td width="5%">库存</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.dingList" id="ding" status="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${sta.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ding.goodsName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ding.chubanshe"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ding.zuozhe"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ding.bianhao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ding.goodsYanse"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="dingDetailHou(<s:property value="#ding.goodsId"/>)" class="pn-loperator">定制描述</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#ding.goodsCatelogName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#ding.goodsPinpaiName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <div onmouseover = "over('<%=path %>/<s:property value="#ding.goodsPic"/>')" onmouseout = "out()" style="cursor:hand;">
								查看图片
					   </div>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#ding.goodsShichangjia"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:if test="#ding.goodsIsnottejia=='no'">无特价&nbsp;&nbsp;&nbsp;
					         <a href="#" style="color: red" onclick="dingShezhiTejia(<s:property value="#ding.goodsId"/>)">设为特价</a>
					     </s:if>
					     <s:if test="#ding.goodsIsnottejia=='yes'">
					        <s:property value="#ding.goodsTejia"/>
					     </s:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					     <s:property value="#ding.goodsKucun"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="dingNoTejiaDel(<s:property value="#ding.goodsId"/>)" class="pn-loperator">删除</a>
						<a href="#" onclick="dingNoTejiaEditPre(<s:property value="#ding.goodsId"/>)" class="pn-loperator">修改</a>
					</td>
				</tr>
				</s:iterator>
			</table> --%>
			
			  <!-- <table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        <input type="button" value="添加" style="width: 80px;" onclick="dingNoTejiaAdd()" />
			    </td>
			  </tr>
		    </table> -->
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
			<TABLE id="tipTable" border="0" bgcolor="#ffffee">
				<TR align="center">
					<TD><img id="photo" src="" height="80" width="80"></TD>
				</TR>
			</TABLE>
		</div>
	</body>
</html>
