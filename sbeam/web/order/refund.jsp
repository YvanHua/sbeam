<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="sbeam.po.user.Customer" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>退款</title>
</head>

<body>
<s:form action="refund" method="post">
    <s:submit value="退款"/>
</s:form>
<s:form action="no" method="post">
    <s:submit name="submit" value="取消订单"/>
</s:form>
</body>
</html>
