<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false" %>
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
		function pinglunAdd(xinwenId)
		{
			<c:if test="${sessionScope.user ==null}">
			alert("请先登录");
			</c:if>
			<c:if test="${sessionScope.user !=null}">
			var strUrl = "<%=path %>/qiantai/pinglun/pinglunAdd.jsp?xinwenId="+xinwenId;
			var ret = window.showModalDialog(strUrl,"","dialogWidth:700px; dialogHeight:400px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");
			window.location.reload();
			</c:if>
		}

		function down1(fujianPath,fujianYuashiMing)
		{
			var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
			url=encodeURI(url);
			url=encodeURI(url);
			window.open(url,"_self");
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
				<div class="list_bar">&nbsp;详情</div>
				<p style="margin-top: 8px;">标题：${requestScope.xinwen.biaoti }</p><br/>

				<c:if test="${requestScope.xinwen.type ==1}">
					<p><img src="<%=path %>/${requestScope.xinwen.fujian }" alt="" width="642" height="350"/></p>
				</c:if>
				<c:if test="${requestScope.xinwen.type ==2}">
					<p>
						<object id="player" height="400" width="650" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6">
							<param NAME="AutoStart" VALUE="-1">
							<!--是否自动播放-->
							<param NAME="Balance" VALUE="0">
							<!--调整左右声道平衡,同上面旧播放器代码-->
							<param name="enabled" value="-1">
							<!--播放器是否可人为控制-->
							<param NAME="EnableContextMenu" VALUE="-1">
							<!--是否启用上下文菜单-->
							<param NAME="url" VALUE="<%=path %>/${requestScope.xinwen.fujian }">
							<!--播放的文件地址-->
							<param NAME="PlayCount" VALUE="1">
							<!--播放次数控制,为整数-->
							<param name="rate" value="1">
							<!--播放速率控制,1为正常,允许小数,1.0-2.0-->
							<param name="currentPosition" value="0">
							<!--控件设置:当前位置-->
							<param name="currentMarker" value="0">
							<!--控件设置:当前标记-->
							<param name="defaultFrame" value="">
							<!--显示默认框架-->
							<param name="invokeURLs" value="0">
							<!--脚本命令设置:是否调用URL-->
							<param name="baseURL" value="">
							<!--脚本命令设置:被调用的URL-->
							<param name="stretchToFit" value="-1">
							<!--是否按比例伸展-->
							<param name="volume" value="50">
							<!--默认声音大小0%-100%,50则为50%-->
							<param name="mute" value="0">
							<!--是否静音-->
							<param name="uiMode" value="mini">
							<!--播放器显示模式:Full显示全部;mini最简化;None不显示播放控制,只显示视频窗口;invisible全部不显示-->
							<param name="windowlessVideo" value="0">
							<!--如果是0可以允许全屏,否则只能在窗口中查看-->
							<param name="fullScreen" value="0">
							<!--开始播放是否自动全屏-->
							<param name="enableErrorDialogs" value="-1">
							<!--是否启用错误提示报告-->
							<param name="SAMIStyle" value>
							<!--SAMI样式-->
							<param name="SAMILang" value>
							<!--SAMI语言-->
							<param name="SAMIFilename" value>
							<!--字幕ID-->
						</object></p>

				</c:if>
				<c:if test="${requestScope.xinwen.type ==3}">
					<p>
						<object id="player" height="280" width="420" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6">
							<param NAME="AutoStart" VALUE="-1">
							<!--是否自动播放-->
							<param NAME="Balance" VALUE="0">
							<!--调整左右声道平衡,同上面旧播放器代码-->
							<param name="enabled" value="-1">
							<!--播放器是否可人为控制-->
							<param NAME="EnableContextMenu" VALUE="-1">
							<!--是否启用上下文菜单-->
							<param NAME="url" VALUE="<%=path %>/${requestScope.xinwen.fujian}">
							<!--播放的文件地址-->
							<param NAME="PlayCount" VALUE="1">
							<!--播放次数控制,为整数-->
							<param name="rate" value="1">
							<!--播放速率控制,1为正常,允许小数,1.0-2.0-->
							<param name="currentPosition" value="0">
							<!--控件设置:当前位置-->
							<param name="currentMarker" value="0">
							<!--控件设置:当前标记-->
							<param name="defaultFrame" value="">
							<!--显示默认框架-->
							<param name="invokeURLs" value="0">
							<!--脚本命令设置:是否调用URL-->
							<param name="baseURL" value="">
							<!--脚本命令设置:被调用的URL-->
							<param name="stretchToFit" value="0">
							<!--是否按比例伸展-->
							<param name="volume" value="50">
							<!--默认声音大小0%-100%,50则为50%-->
							<param name="mute" value="0">
							<!--是否静音-->
							<param name="uiMode" value="mini">
							<!--播放器显示模式:Full显示全部;mini最简化;None不显示播放控制,只显示视频窗口;invisible全部不显示-->
							<param name="windowlessVideo" value="0">
							<!--如果是0可以允许全屏,否则只能在窗口中查看-->
							<param name="fullScreen" value="0">
							<!--开始播放是否自动全屏-->
							<param name="enableErrorDialogs" value="-1">
							<!--是否启用错误提示报告-->
							<param name="SAMIStyle" value>
							<!--SAMI样式-->
							<param name="SAMILang" value>
							<!--SAMI语言-->
							<param name="SAMIFilename" value>
							<!--字幕ID-->
						</object>
					</p>
				</c:if>
				<%-- <p><img src="<%=path %>/${requestScope.xinwen.fujian }" alt="" width="642" height="350"/></p> --%>
				<%-- <p>
                <object id="player" height="400" width="650" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6">
                           <param NAME="AutoStart" VALUE="-1">
                           <!--是否自动播放-->
                           <param NAME="Balance" VALUE="0">
                           <!--调整左右声道平衡,同上面旧播放器代码-->
                           <param name="enabled" value="-1">
                           <!--播放器是否可人为控制-->
                           <param NAME="EnableContextMenu" VALUE="-1">
                           <!--是否启用上下文菜单-->
                           <param NAME="url" VALUE="<%=path %>/${requestScope.xinwen.fujian }">
                           <!--播放的文件地址-->
                           <param NAME="PlayCount" VALUE="1">
                           <!--播放次数控制,为整数-->
                           <param name="rate" value="1">
                           <!--播放速率控制,1为正常,允许小数,1.0-2.0-->
                           <param name="currentPosition" value="0">
                           <!--控件设置:当前位置-->
                           <param name="currentMarker" value="0">
                           <!--控件设置:当前标记-->
                           <param name="defaultFrame" value="">
                           <!--显示默认框架-->
                           <param name="invokeURLs" value="0">
                           <!--脚本命令设置:是否调用URL-->
                           <param name="baseURL" value="">
                           <!--脚本命令设置:被调用的URL-->
                           <param name="stretchToFit" value="-1">
                           <!--是否按比例伸展-->
                           <param name="volume" value="50">
                           <!--默认声音大小0%-100%,50则为50%-->
                           <param name="mute" value="0">
                           <!--是否静音-->
                           <param name="uiMode" value="mini">
                           <!--播放器显示模式:Full显示全部;mini最简化;None不显示播放控制,只显示视频窗口;invisible全部不显示-->
                           <param name="windowlessVideo" value="0">
                           <!--如果是0可以允许全屏,否则只能在窗口中查看-->
                           <param name="fullScreen" value="0">
                           <!--开始播放是否自动全屏-->
                           <param name="enableErrorDialogs" value="-1">
                           <!--是否启用错误提示报告-->
                           <param name="SAMIStyle" value>
                           <!--SAMI样式-->
                           <param name="SAMILang" value>
                           <!--SAMI语言-->
                           <param name="SAMIFilename" value>
                           <!--字幕ID-->
                           </object>
                <img src="<%=path %>/${requestScope.xinwen.fujian }" alt="" width="642" height="350"/></p> --%>
				<p>信息内容：<c:out value="${requestScope.xinwen.neirong }" escapeXml="false"></c:out></p>
				<p>发布时间：${requestScope.xinwen.shijian }</p>
				<p>附件：${requestScope.shipin.fujian }
					&nbsp;&nbsp;&nbsp;
					<a href="#" onclick="down1('${requestScope.xinwen.fujian }','${requestScope.xinwen.fujian }')" style="color: red">下载</a>
				<hr/>
				</p>


				<c:forEach items="${requestScope.tupianList}" var="tupian" varStatus="ss">
					<p><img src="<%=path %>/${tupian.fujian }" alt="" width="688" height="300"/></p>
					<p><c:out value="${tupian.jieshao }" escapeXml="false"></c:out></p>
					<br/>
				</c:forEach>
				<%--<p style="margin-top: 13px;">
					<c:forEach items="${requestScope.pinglunList}" var="pinglun" varStatus="s">
				<div class="c1-bline" style="padding:7px 0px;">
					<div class="f-left" style="margin-left: 1px;">
						<img src="<%=path %>/images/head-mark4.gif" align="middle" class="img-vm" border="0"/>${pinglun.neirong}
					</div>
					<div class="f-right" style="margin-right: 10px;">${pinglun.shijian}</div><div class="clear"></div>
				</div>
				</c:forEach>
				</p>--%>

				<div class="list_bar">&nbsp;评论 </div>
				<table border="0" cellpadding="6">
					<p style="margin-top: 13px;">
						<c:forEach items="${requestScope.pinglunList}" var="pinglun" varStatus="s">
					<div class="c1-bline" style="padding:7px 0px;">
						<div class="f-left" style="margin-left: 1px;">
							<img src="<%=path %>/images/head-mark4.gif" align="middle" class="img-vm" border="0"/>${pinglun.neirong}
						</div>
						<div class="f-right" style="margin-right: 10px;">${pinglun.shijian}</div><div class="clear"></div>
					</div>
					</c:forEach>
					</p>
					<p style="margin-top: 8px;"><input type="button" value="我要评论" onclick="pinglunAdd(${requestScope.xinwen.id })" style="width: 100px;"/></p>

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
