<%--
  Created by IntelliJ IDEA.
  User: huayifan
  Date: 2019/1/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
    <title>Indi</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="utf-8"/>
</head>
<body>
    <s:iterator value="gamelist">
        游戏账号<s:property value="id"></s:property><br>
        <form action="collection" method="post">
            <s:hidden name="gid" value="%{id}"/>
            <s:property value="id"></s:property>
            <s:submit value="提交"></s:submit>
        </form>
    </s:iterator>
</body>
</html>
