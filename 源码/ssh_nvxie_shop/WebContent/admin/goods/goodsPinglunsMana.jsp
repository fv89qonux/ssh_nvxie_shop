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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
        <script language="javascript">
           function leibieDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/pinglunsDel.action?id="+id;
               }
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

	<body leftmargin="8" topmargin="8" background='<%=path %>/images/allbg.gif'>
			<table width="70%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/images/tbg.gif">&nbsp;&nbsp;商品评论管理</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">序号</td>
					<td width="40%">评论内容</td>
					<td width="15%">评论人</td>
					<td width="15%">评论时间</td>
					<td width="15%">操作</td>
		        </tr>	
				<s:iterator value="#request.pinglunsList" id="pingluns" status="sta">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#sta.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#pingluns.neirong"/>
					</td>
					</td><td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="userXinxi(<s:property value="#pingluns.uid"/>)" style="color: red">查看用户</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#pingluns.shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="leibieDel(<s:property value="#pingluns.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
