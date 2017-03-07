<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- basthpath获取根目录 ，所有的路径都是从你项目名的根目录查询的-->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- HTML5的文档 -->
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>提交美食页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css">
  </head>
  
  <body>
    <s:form action="food/food_AddFood" method="post">
      <s:textfield name="food.FoodName" label="名称"></s:textfield>
       <s:textfield name="food.UintPrice" label="价格"></s:textfield>
       <s:submit value="提交"></s:submit>
    </s:form>
    <br>
  </body>
</html>
