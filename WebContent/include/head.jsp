<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/xw.css">
    <div class="layout bg-blue bg-inverse">
      <div class="container height">
        <span class="float-right text-small text-white hidden-l">
			<a class="text-white" href="register.jsp">注册</a><span> | </span><a class="text-white" href="longin.jsp">登入</a>
        </span>
        <a class="text-white" href="#"></a>
      </div>
    </div>
	<!--导航-->
    <div class="qqb-nav padding-little-top padding-little-bottom nav-pills">
    <div class="container padding-top padding-bottom">

      <div class="line">
        <div class="xl12 xs3 xm3 xb2"><button class="button icon-navicon float-right" data-target="#header-demo"></button><img src="images/logo.jpg" alt="宝贝回家"/></div>
        <div class="xl12 xs10 xm10 xb10 nav-navicon" id="header-demo">
          <div class="xs1 xm10 xb10 padding-small">
            <ul class="nav nav-menu nav-inline nav-big">
              <li><a href="index" class="aaa">首页</a></li>
              <li><a href="uploading.jsp" class="aaa"> 寻亲登记</a>
              </li>
             <li><a href="me.jsp" class="aaa">关于我们<span class="arrow"></span></a>
                  <ul class="drop-menu">
					  <li><a href="me.jsp" class="aaa">关于我们</a></li>
					  <li><a href="tickling.jsp" class="aaa">意见反馈</a></li>
                  </ul>
              </li>
			  <li><a href="main.jsp" class="aaa">个人中心</a></li>
			  <li><a href="user?method=out" class="aaa">退出</a></li>
            </ul>
          </div>
          <div class="xs2 xm2 xb2">
            <form id="frm_nav" action="details?method=list" method="post">
              <div class="input-group padding-little-top">
                <input type="text" class="input border-blue" name="name" size="7" placeholder="输入关键词" />
                <span class="addbtn"><button type="submit" class="button bg-blue icon-search"></button></span>
              </div>
            </form>
          </div>
        </div>
      </div>

    </div>

