<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>原生态Java生成报表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<style type="text/css">
		table.hovertable{
			font-family: verdana ,arial , sans-serif;
			font-size: 13px;
			color: #333333;
			border-width: 1px;
			border-color: #999999;
			border-collapse: collapse;
		}
		table.hovertable th{
			background-color: #c3dde0;
			border-width: 1px;
			padding: 8px;
			border-style : solid;
			border-color: #a9c6c9;
		}
		
		table.hovertable tr{
			background-color: #d4e3e5;
		}
		
		table.hovertable td{
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #a9c6c9;
		}
	
	</style>
	
  </head>
  
  <body>
  
  
  	<form action="ShowReport" method="post">
  		<input type="submit" value="生成报表">
  	</form>
  	
 
  	
   	<table class="hovertable">
   		<tr>
   			<td colspan="5" align="center">利润表</td>
   		</tr>
   		<tr>
   			<td>序号</td>
   			<td>商品名称</td>
   			<td>卖出数量</td>
   			<td>交易笔数</td>
   			<td>盈利额</td>
   		</tr>
   		<c:set var="totalNum" value="0"></c:set>
		<c:set var="totaltimes" value="0"></c:set>
		<c:set var="total" value="0"></c:set>
   	 	<c:choose>
   	 		<c:when test="${not empty sessionScope.list }">
				<c:forEach items="${sessionScope.list }" var="profit" varStatus="vs">
	   				<tr onmouseover="this.style.backgroundColor='#ffff66'" onmouseout="this.style.backgroundColor='#d4e3e5'">
			   			<td>${vs.count }</td>
			   			<td>${profit.goodsName }</td>
			   			<td>${profit.tradingNum }</td>
			   			<td>${profit.times }</td>
			   			<td>${profit.profit }</td>
			   			<c:set var="totalNum" value="${totalNum+profit.tradingNum }"></c:set>
						<c:set var="totaltimes" value="${totaltimes+profit.times }"></c:set>
						<c:set var="total" value="${total+profit.profit }"></c:set>
			   		</tr>
	   			</c:forEach>
   			</c:when>
   			<c:otherwise>
   				<tr>
			   		<td colspan="5">暂无数据</td>
			   	</tr>
   			</c:otherwise>
   		</c:choose>
   		<tr onmouseover="this.style.backgroundColor='#ffff66'" onmouseout="this.style.backgroundColor='#d4e3e5'">
   			<td colspan="2">合计</td>
   			<td><c:out value="${totalNum }"></c:out></td>
   			<td><c:out value="${totaltimes }"></c:out></td>
   			<td><c:out value="${total }"></c:out></td>
   		</tr>
   	</table>
   	
  
  </body>
</html>
