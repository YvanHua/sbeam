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
    <link rel="stylesheet" href="/sbeam/otherlib/bootstrap.css"/>
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
    <table class="table">
        <tr style="width: 10%">
        <td>订单号</td>
        <td>游戏名</td>
        <td>购买时间</td>
        <td>支付金额</td>
        <td>当前状态</td>
        <td>功能1 </td>
        <td>功能2</td>
        </tr>

    <s:iterator value="orderlist">
        <tr>
        <td><s:property value="id"></s:property></td>
        <td><s:property value="game.name"/> </td>
        <td><s:property value="date"></s:property></td>
        <td><s:property value="pay"></s:property></td>
        <s:if test="state==0">
            <td>未付款</td>
            <td>
                <div align="left" style="float:left">
                <form action="pay" method="post">
                    <input type="submit" value="付款">
                    <s:hidden name="oid" value="%{id}"/>
                    <%--<s:submit value="购买"></s:submit>--%>
                </form>
                </div>
            </td>
            <td>
                <div align="left" style="float:left">
                    <form action="no" method="post">
                        <s:hidden name="oid" value="%{id}"/>
                    <input type="submit" value="取消订单">
                <%--<s:submit value="取消订单"></s:submit>--%>
                    </form>
            </div>
            </td>
        </s:if>
        <s:if test="state==1">
            <td>已退款</td>
            <td> </td>
            <td > </td>
        </s:if>
        <s:if test="state==2">
            <td>已付款</td>
            <td>
                <form action="refund" method="post">
                    <s:hidden name="oid" value="%{id}"/>
                    <input type="submit" value="退款">
                    <%--<s:submit value="退款"></s:submit>--%>
                </form>
            </td>
            <td><form action="download" method="post">
                <s:hidden name="gid" value="%{game.id}"/>
                <input type="submit" value="下载">
                <%--<s:submit value="下载"></s:submit>--%>
            </form></td>
        </s:if>
        </tr>
    </s:iterator>
    </table>
    <a href="/sbeam/customer/loginsuccess.jsp">返回个人主页</a>
</div>
</body>
<script src="/sbeam/otherlib/bootstrap.js"/>
</html>
