<%@ page import="java.util.List" %>
<%@ page import="sbeam.po.message.Message" %><%--
  Created by IntelliJ IDEA.
  User: LXY
  Date: 2018/12/26
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>MessagePage</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="utf-8"/>
</head>
<body>
<s:if test="%{#session.messages!=null && #session.messages.size()!=0}">
    <%
        List messages = (List)session.getAttribute("messages");
        int i = 0;
    %>
    <s:iterator value="#session.messages" >
        <%
            out.print(((Message)messages.get(i)).getContent());
            i++;
        %>
        <s:form action="confirmOneMessage" method="POST">
            <s:hidden name="location" value="/customer/playmessage.jsp"/>
            <s:hidden name="message.id" value="%{id}"/>
            <s:submit value="点击已阅"/>
        </s:form>
    </s:iterator>
</s:if>
<s:else>
    <s:text name="无消息！"/>
</s:else>
<br/>
    <a href="/sbeam/customer/loginsuccess.jsp">点击返回</a>
</body>
</html>
