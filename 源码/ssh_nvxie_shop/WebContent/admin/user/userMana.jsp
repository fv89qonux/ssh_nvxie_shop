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
		
        <script language="javascript">
           function userDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/userDel.action?id="+id;
               }
           }
           function userShenhe(id)
           {
               if(confirm('您确定审核吗？'))
               {
                   window.location.href="<%=path %>/userShenhe.action?id="+id;
               }
           }
                      function userJinyong(id)
           {
               if(confirm('您确定禁用吗？'))
               {
                   window.location.href="<%=path %>/userJinyong.action?id="+id;
               }
           }
           function chongzhiAdd(id)
           {
               var strUrl = "<%=path %>/admin/user/chongzhiAdd.jsp?id="+id;
               window.location.href=strUrl;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">账号</td>
					<td width="10%">密码</td>
					<td width="5%">姓名</td>
					
					<td width="5%">性别</td>
					<td width="5%">年龄</td>
					<td width="10%">默认地址</td>
					<td width="5%">电话</td>
					<td width="5%">类型</td>
					<td width="5%">类型名</td>
					<td width="5%">状态</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.userList" id="user" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.loginname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.loginpw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.xingming"/>
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.xingbie"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.nianling"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.address"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.dianhua"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.type"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.typename"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.shenhe"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="userDel(<s:property value="#user.id"/>)"/>
						<input type="button" value="审核" onclick="userShenhe(<s:property value="#user.id"/>)"/>
						<input type="button" value="禁用" onclick="userJinyong(<s:property value="#user.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
