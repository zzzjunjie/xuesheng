<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Admin"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Language" content="UTF-8">
    <title>学生管理平台</title>
    <link rel="stylesheet" href="../js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/skins/_all-skins.css">
</head>
<body class="hold-transition skin-blue sidebar-mini" style="overflow:hidden;">
<%--加载等待效果--%>
    <div id="ajax-loader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden;">
        <img src="../img/ajax-loader.gif" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;" />
    </div>
<%--加载等待效果 end--%>

    <div class="wrapper">
        <!--头部信息-->
        <header class="main-header">
            <a href="#" target="_blank" class="logo">
                <span class="logo-mini">学生管理</span>
                <span class="logo-lg" >
                  <%--时间--%>
                <div id="logo-time" style="font-size: 25px;color: #FFF;" class="text-center text-warning ">
                </div>
                </span>
            </a>
            <nav class="navbar navbar-static-top" style="background-color: #0C0C0C">
                <a class="sidebar-toggle">
                    <span class="sr-only">切换</span>
                </a><span class="index_top"><strong>学生管理</strong></span>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <%--显示用户头像--%>
                                <img src="http://roderick.cn/touxiang.jpg" class="user-image" alt="User Image">
                                <span class="hidden-xs">
                                    <%--EL表达式获取session与对象的值--%>
                                    ${teacher.tName}
                                </span>
                            </a>

                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <!--左边导航 注：由js渲染-->
        <div class="main-sidebar">
            <div class="sidebar">
                <ul class="sidebar-menu" id="sidebar-menu">
                    <!--<li class="header">导航菜单</li>-->
                </ul>
            </div>
        </div>
        <!--中间内容-->
        <div id="content-wrapper" class="content-wrapper">
            <div class="content-tabs">
                <button class="roll-nav roll-left tabLeft">
                    <i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs menuTabs">
                    <div class="page-tabs-content" style="margin-left: 0px;">
                        <a href="javascript:;" class="menuTab active" data-id="teacher/studentInfo.jsp">查询学生信息</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right tabRight">
                    <i class="fa fa-forward" style="margin-left: 3px;"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown tabClose" data-toggle="dropdown">
                        页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a class="tabReload" href="javascript:;">刷新当前</a></li>
                        <li><a class="tabCloseCurrent" href="javascript:;">关闭当前</a></li>
                        <li><a class="tabCloseAll" href="javascript:;">全部关闭</a></li>
                        <li><a class="tabCloseOther" href="javascript:;">除此之外全部关闭</a></li>
                    </ul>
                </div>
                <button class="roll-nav roll-right fullscreen"><i class="fa fa-arrows-alt"></i></button>
            </div>
            <div class="content-iframe" style="overflow: hidden;">
                <div class="mainContent" id="content-main" style="margin: 10px; margin-bottom: 0px; padding: 0;">
                    <iframe class="LRADMS_iframe" width="100%" height="100%" src="teacher/studentInfo.jsp" frameborder="0" data-id="teacher/studentInfo.jsp"></iframe>
                </div>
            </div>
        </div>
    </div>
    <script src="../js/jquery/jQuery-2.2.0.min.js"></script>
    <script src="../js/bootstrap/js/bootstrap.min.js"></script>
    <script src="../js/index.js"></script>
</body>
</html>
