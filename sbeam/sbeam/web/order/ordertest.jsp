<%--
  Created by IntelliJ IDEA.
  User: huayifan
  Date: 2019/1/5
  Time: 19:40
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
    <form action="orderfind" method="post">
        <s:submit value="查询"></s:submit>
    </form>
</body>
</html>
