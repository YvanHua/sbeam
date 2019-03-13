<%--
  Created by IntelliJ IDEA.
  User: huayifan
  Date: 2019/1/9
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.opensymphony.xwork2.util.*"%> 
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <title>Indi</title>
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
            height: 250px;
            border: 10px solid lightblue;
            padding: 10px;
            margin: 10px;
        }
        .header2
        {
            background-color: lightgrey;
            width: 200px;
            height: 30px;
            border: 5px solid darkorchid;
            padding: 5px;
            margin: 5px;
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
<body style=" background-attachment: fixed;background-image : url(/sbeam/css/back2.jpg);">
<div class="header2">
    <a href="/sbeam/customer/loginsuccess.jsp">返回个人中心</a>
</div>
<s:iterator value="#session.gamelists">
    <s:set var="td" scope="page" value="dit"/>
    <%
        ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
        String t=vs.findString("dir");
        //String filePath = request.getSession().getServletContext().getRealPath("/")+"JSP_Ajax"+"\\";
        //System.out.println("filePath=="+filePath);
        String path =t+"/describe";   // 这边文件目录需改成相对路径
        String realpath= ServletActionContext.getServletContext().getRealPath(t+"/describe/describe.txt");
        File file = new File(realpath);
        FileReader fr = new FileReader(file);  //字符输入流
        BufferedReader br = new BufferedReader(fr);  //使文件可按行读取并具有缓冲功能

        StringBuffer strB = new StringBuffer();   //strB用来存储jsp.txt文件里的内容
        String str = br.readLine();
        while(str!=null){
            strB.append(str).append("<br>");   //将读取的内容放入strB
            str = br.readLine();
        }
        br.close();    //关闭输入流
    %>
    <div class="header">
        <div id="photo"><img src="/sbeam<s:property value="dir"/>/pictures/1.png"  width="150px" height="200px"></div>
    <div id="intro">游戏名称：<s:property value="name"></s:property><br>
        游戏价格：<s:property value="discountPrice"/>
        <p> 简介：<%=strB %></p>
        <div align="left" style="float:left">
            <form action="findevaluate" method="post">
                <s:hidden name="gid" value="%{id}"></s:hidden>
                <s:submit value="查看评价"></s:submit>
            </form>
        </div>
        <div align="center" style="float:left">
        <form action="toevaluate" method="post">
            <s:hidden name="gid" value="%{id}"></s:hidden>
            <s:submit value="评价"></s:submit>
        </form>
        </div>
        <div align="left" style="float:left">
        <form action="buy" method="post">
            <s:hidden name="gid" value="%{id}"></s:hidden>
            <s:submit value="购买"></s:submit>
        </form></div>
        <div align="center" style="float:left">
        <form action="tocollect" method="post">
            <s:hidden name="gid" value="%{id}"></s:hidden>
            <s:submit value="收藏"></s:submit>
        </form>
        </div>
    </div>
    </div>
    <br>
</s:iterator>
</body>
</html>
