<%--
  Created by IntelliJ IDEA.
  User: SDUST-132
  Date: 2016/7/4
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>易买网 - 首页</title>
  <link type="text/css" rel="stylesheet" href="css/style.css" />
  <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
  <div id="logo"><img src="images/logo.gif" /></div>
  <div class="help">
    <a href="getShopCar.sc" class="shopping">购物车</a>
    <c:if test="${sessionScope.user==null}">
      <a href="login.jsp">登录</a>
      <a href="register.jsp">注册</a>
    </c:if>
    <c:if test="${sessionScope.user!=null}">
        ${sessionScope.user.euName}
        <a href="getAllComment.comt">留言</a>
    </c:if>
  </div>
  <div class="navbar">
    <ul class="clearfix">
      <li class="current"><a href="#">首页</a></li>
      <li><a href="#">图书</a></li>
      <li><a href="#">百货</a></li>
      <li><a href="#">品牌</a></li>
      <li><a href="#">促销</a></li>
    </ul>
  </div>
</div>
<div id="childNav">
  <div class="wrap">
    <ul class="clearfix">
      <li class="first"><a href="#">音乐</a></li>
      <li><a href="#">影视</a></li>
      <li><a href="#">少儿</a></li>
      <li><a href="#">动漫</a></li>
      <li><a href="#">小说</a></li>
      <li><a href="#">外语</a></li>
      <li><a href="#">数码相机</a></li>
      <li><a href="#">笔记本</a></li>
      <li><a href="#">羽绒服</a></li>
      <li><a href="#">秋冬靴</a></li>
      <li><a href="#">运动鞋</a></li>
      <li><a href="#">美容护肤</a></li>
      <li><a href="#">家纺用品</a></li>
      <li><a href="#">婴幼奶粉</a></li>
      <li><a href="#">饰品</a></li>
      <li class="last"><a href="#">Investor Relations</a></li>
    </ul>
  </div>
</div>
<div id="main" class="wrap">
  <div class="lefter">
    <div class="box">
      <h2>商品分类</h2>
        <dl>
          <c:forEach var="ebprodcate" items="${prodcates}">
            <c:if test="${ ebprodcate.epcParentId==0}">
              <dt>${ebprodcate.epcName}</dt>
              <c:forEach var="ebprodcate1" items="${prodcates}">
                <c:if test="${ebprodcate1.epcParentId==ebprodcate.epcId}">
                  <c:url value="toProductList.pca" var="tolist">
                    <c:param name="id" value="${ebprodcate1.epcId}"></c:param>
                  </c:url>
                  <dd><a href="${tolist}"> ${ebprodcate1.epcName}</a></dd>
                </c:if>
              </c:forEach>
            </c:if>
          </c:forEach>
        </dl>
    </div>
    <div class="spacer"></div>
    <div class="last-view">
      <h2>最近浏览</h2>
      <dl class="clearfix">
        <dt><img src="images/product/0_tiny.gif" /></dt>
        <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
        <dt><img src="images/product/0_tiny.gif" /></dt>
        <dd><a href="product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a></dd>
      </dl>
    </div>

  </div>
  <div class="main">
    <div class="price-off">
      <h2>今日特价</h2>
      <ul class="product clearfix">
        <c:forEach items="${special}" var="eprod">
          <li>
            <dl>
              <c:url value="getAProd.prod" var="aprod">
                <c:param name="id" value="${eprod.epId}"></c:param>
              </c:url>
              <dt>
                <a href="${aprod}" target="_blank"><img src="images/product/1.jpg" /></a>
              </dt>
              <dd class="title">
                <a href="${aprod}" target="_blank">${eprod.epName}</a>
              </dd>
              <dd class="price">${eprod.epPrice}</dd>
            </dl>
          </li>
        </c:forEach>
      </ul>
    </div>
    <div class="side">
      <div class="news-list">
        <h4>最新公告</h4>
        <ul>
          <c:forEach var="news" items="${newsList}">
            <li>
              <c:url value="getANew.new" var="getanew">
                <c:param name="id" value="${news.enId}"></c:param>
              </c:url>
              <a href="${ getanew }" target="_blank">${news.enTitle}</a>
            </li>
          </c:forEach>
        </ul>
      </div>
      <div class="spacer"></div>
      <div class="news-list">
        <h4>新闻动态</h4>
        <ul>
          <c:forEach var="news" items="${newsList}">
            <li>
              <c:url value="getANew.new" var="getanew">
                <c:param name="id" value="${news.enId}"></c:param>
              </c:url>
              <a href="${ getanew }" target="_blank">${news.enTitle}</a>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
    <div class="spacer clear"></div>
    <div class="hot">
      <h2>热卖推荐</h2>
      <ul class="product clearfix">
        <c:forEach items="${hotproducts}" var="prod">
        <li>
          <dl>
            <c:url value="getAProd.prod" var="aprod">
              <c:param name="id" value="${prod.epId}"></c:param>
            </c:url>
            <dt>
              <a href="${aprod}" target="_blank"><img src="images/product/1.jpg" /></a>
            </dt>
            <dd class="title">
              <a href="${aprod}" target="_blank">${prod.epName}</a>
            </dd>
            <dd class="price">${prod.epPrice}</dd>
          </dl>
        </li>
        </c:forEach>
      </ul>
    </div>
  </div>
  <div class="clear"></div>
</div>
<div id="footer">
  Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
