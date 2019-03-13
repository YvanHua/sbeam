<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: huayifan
  Date: 2019/1/5
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<head>
    <title>游戏评价</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="utf-8"/>
    <style>
        body
        {
            background-attachment: fixed;
            background-image : url(/css/back.jpg);
            background-repeat : no-repeat;

        }

    </style>
    <style>

        .header{

            background-color: lightgrey;
            width: 800px;
            height: auto;
            border: 10px solid lightblue;
            padding: 10px;
            margin: 10px;
        }
        .header img
        {
            float: left;
        }
        .header p{
            display: block;
            width: auto;
            line-height: 14px;
            padding-left: 20px;
        }

        .header p a{
            text-align: left;
            text-decoration: underline;
            color: red;
            font-size: 12px;
        }

        .header photo{
            float:left;
            width:20%;
        }
        .header intro{
            float:right;
            width:80%;
        }
        box{
            background-color: lightgrey;
            width: 1200px;
            height: 400px;
            border: 10px solid black;
            padding: 25px;
            margin: 25px;
        }

    </style>
</head>
<body style=" background-attachment: fixed;background-image : url(/sbeam/css/back.jpg);">
<div class="header">
    收藏成功！<br>
    如需取消收藏，请返回个人中心-收藏夹中取消收藏。
    <a href="/sbeam/game/showgames.jsp">返回个人中心</a>
</div>
</body>
</html>
