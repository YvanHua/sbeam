<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <link type="text/css" rel="stylesheet" href="/sbeam/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="/sbeam/css/zzsc.css">

    <style>
        #datouwang{
            z-index: -1;
        }
        #welcome{
            position: absolute;
            left: 500px;
            top : 0px;
            box-shadow:2px 1px 10px 1px;
            background-color:rgba(246,246,247,0.85);
            border-radius:5px;
        }
    </style>

</head>
<body>

<div id="datouwang" class="container"></div>
<div id="welcome">
    <h1 id="point"><font color="#6495ed">登录成功,欢迎您!<s:property  value="#session.user.account"/></font></h1>
    <table class="table table-condensed">
        <tr>
            <td>
                <font color="#6495ed"> 用户编号：<s:property  value="#session.user.id"/></font>
            </td>
        </tr>
        <tr>
            <td>
                <font color="#6495ed"> 电话号码：<s:property  value="#session.user.phone"/></font>
            </td>
        </tr>
        <tr>
            <td>
                <a class="btn btn-info" href="update.jsp" role="button">修改个人信息</a>
            </td>
        </tr>
        <tr>
            <td>
                <s:form action="gamefind" method="post">
                    <button type="submit" class="btn-info">进入游戏商城</button>
                </s:form>
            </td>
        </tr>
        <tr>
            <td>
            <a class="btn btn-info" href="/sbeam/problem/sendmessage.jsp" role="button">发送工单</a>
            </td>
        </tr>
        <tr>
            <td>
                <s:form action="playtickets" method="post">
                    <button type="submit" class="btn-info">查看工单</button>
                </s:form>
            </td>
        </tr>
        <tr>
            <td>
                <s:form action="orderfind" method="post">
                    <button type="submit" class="btn-info">查看订单</button>
                </s:form>
            </td>
        </tr>
        <tr>
            <td>
                <s:form action="collectionlist" method="post">
                    <button type="submit" class="btn-info">我的收藏</button>
                </s:form>
            </td>
        </tr>
        <tr>
            <td>
                <s:form action="getMessages" method="post">
                    <s:hidden name="type" value="0"/>
                    <s:hidden name="id" value="%{#session.user.id}"/>
                    <s:hidden name="location" value="/customer/playmessage.jsp"/>
                    <button type="submit" class="btn-info">查看消息</button>
                </s:form>
            </td>
        </tr>
        <tr>
            <td>
                <a class="btn btn-info" href="/sbeam/customer/login.jsp" role="button">退出账号</a>
            </td>
        </tr>
    </table>
</div>

<script src="/sbeam/js/jquery.min.js"></script>
<script src="/sbeam/js/zzsc.js"></script>
<script type="text/javascript" src="/sbeam/bootstrap-3.3.7-dist/js/bootstrap.js"></script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>