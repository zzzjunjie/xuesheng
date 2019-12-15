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
    <title>录入成绩</title>
    <link rel="stylesheet" href="<%=basePath%>/js/layui/css/layui.css" media="all">
</head>
<body>
<div id="add-student" style="margin-top: 20px">
    <form class="layui-form  "  id="add-form"  action="" >
        <div class="layui-form-item center" >
            <label class="layui-form-label" style="width: 100px" >学号:</label>
            <div class="layui-input-block">
                <input type="text" id="xsbh" name="xsbh" required style="width: 240px"  lay-verify="required" placeholder="请输入学号" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">姓名</label>
            <div class="layui-input-block">
                <input type="text" id="xsxm" name="xsxm" required  style="width: 240px" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">性别</label>
            <div class="layui-input-block">
                <input type="text" id="xsxb" name="xsxb" required  style="width: 240px" lay-verify="required" placeholder="请输入性别" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">年级</label>
            <div class="layui-input-block">
                <input type="text" id="xsnj" name="xsnj" required style="width: 240px;" lay-verify="required" placeholder="请输入所在年级" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">所在班级</label>
            <div class="layui-input-block">
                <input name="szbj" id="szbj" required style="width: 240px;" lay-verify="required" placeholder="请输入所在班级" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">学生电话</label>
            <div class="layui-input-block">
                <input type="text" name="xsdh" id="xsdh" required style="width: 240px;" lay-verify="required" placeholder="请输入学生电话" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">所在系部</label>
            <div class="layui-input-block">
                <input type="text" id="szxb" name="szxb" required style="width: 240px;" lay-verify="required" placeholder="请输入学生所在系部" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 100px">家庭住址</label>
            <div class="layui-input-block">
                <textarea type="text" id="jtzz" name="jtzz" required style="width: 240px;" lay-verify="required" placeholder="请输入学生家庭住址" autocomplete="off" class="layui-textarea"></textarea>
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
        form.on('submit(save)', function(data){
            var loading = layer.load(0,{shade:false});
            //提交数据到后台处理
            $.post('/UpdateStudentInfoServlet',data.field,function(data){
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
