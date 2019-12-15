<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2019/12/11
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath(); //  path = "/travel"
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; // basePath="http://localhost:8080/travel/"
%>
<html>
<head>
    <title>修改用户</title>
    <link rel="stylesheet" href="<%=basePath%>/js/layui/css/layui.css" media="all">
</head>
<body>
<div id="add-student" style="margin-top: 20px">
    <form class="layui-form  "  id="add-form"  action="" >
        <div class="layui-form-item center" >
            <label class="layui-form-label" style="width: 100px" >用户编号:</label>
            <div class="layui-input-block">
                <input type="text" id="u_id" name="u_id" disabled required style="width: 240px"  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">用户姓名</label>
            <div class="layui-input-block">
                <input type="text" id="u_name" name="u_name" required  style="width: 240px" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">用户密码</label>
            <div class="layui-input-block">
                <input type="text" id="u_password" name="u_password" required  style="width: 240px" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block "style="text-align: center;width: 200px;" >
                <button class="layui-btn" lay-submit lay-filter="save" >提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" id="closeBtn" >重置</button>
            </div>
        </div>
    </form>
</div>
<script src="<%=basePath%>/js/layui/layui.js"></script>
<script>
    layui.use(['upload','element'], function(){
        var $ = layui.jquery
            ,upload = layui.upload
            ,element = layui.element;

    });
    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.jquery;
        //提交按钮被点击
        form.on('submit(save)', function(data){
            var loading = layer.load(0,{shade:false});

            //提交数据到后台处理，使用jquery的ajax提交  data.field是页面所填的数据
            $.post('/UpdateAdminServlet',data.field,function(data){
                if(data > 0){
                    // layer.close(loading);
                    //消息提示
                    parent.layer.msg("修改成功^_^");
                    //关闭弹出层
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                    //刷新表格，重新载入数据
                    parent.layui.table.reload('testReload');
                }else{
                    //消息提示
                    parent.layer.msg("修改失败>_<");
                    //关闭弹出层
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
