<%--
  Created by IntelliJ IDEA.
  User: A
  Date: 2019/12/11
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String path = request.getContextPath(); //  path = "/travel"
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; // basePath="http://localhost:8080/travel/"
%>
<html>
<head>
    <title>学生信息</title>
    <link rel="stylesheet" href="<%=basePath%>/js/layui/css/layui.css" media="all">
</head>
<body>
<%--搜索框--%>
<div class="demoTable">
    搜索ID：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="demoReload" autocomplete="off">
    </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>
<%--Layui前端table框架,显示登陆教师所有的学生信息--%>
<table class="layui-hide" id="student_info" lay-filter="student_info"></table>
<%--表头toolsBar--%>
<script type="text/html" id="student_toolsBar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add_student">+</button>
        <button class="layui-btn layui-btn-sm layui-btn-primary" lay-event="delete_student">-</button>
    </div>
</script>
<%--表内toolsBar--%>
<script type="text/html" id="table_bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="<%=basePath%>/js/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.config({
        version: '1559293953947' //为了更新 js 缓存，可忽略
    });

    layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
        var laydate = layui.laydate //日期
            ,laypage = layui.laypage //分页
            ,layer = layui.layer //弹层
            ,table = layui.table //表格
            ,carousel = layui.carousel //轮播
            ,upload = layui.upload //上传
            ,element = layui.element //元素操作
            ,slider = layui.slider //滑块
            ,$ = layui.jquery

        //监听Tab切换
        element.on('tab(demo)', function(data){
            layer.tips('切换了 '+ data.index +'：'+ this.innerHTML, this, {
                tips: 1
            });
        });

        //执行一个 table 实例
        table.render({
            elem: '#student_info'
            //请求后台
            ,url:'/QueryStudentResultServlet'
            ,toolbar: '#'
            ,title: '学生信息表'
            ,totalRow: true
            ,cols: [[
                //配置每一列所需要展示的元素,格式给JSON格式,JSONUtil里面提供了List->JSON工具类
                {type: 'checkbox', fixed: 'left'}
                ,{field:'s_id', title:'学号',width:80}
                ,{field:'s_name', title:'姓名',width:100}
                ,{field:'s_sex', title:'性别',width:80}
                ,{field:'s_grade', title:'年级',width:80}
                ,{field:'s_class', title:'所在班级'}
                ,{field:'c_name', title:'课程名称'}
                ,{field:'s_department', title:'所在系部'}
                ,{field:'s_result', title:'成绩'}
                ,{fixed: 'right', title:'操作', toolbar: '#table_bar', width:150}
            ]]
            ,page: true

        });

        //监听头工具栏事件
        table.on('toolbar(student_info)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        type:2
                        ,title:"添加耳机商品"
                        // closeBtn: false,
                        ,shift: 1
                        ,area: ['425px', '700px']
                        ,shadeClose: true
                        // ,btn: ['新增', '取消']
                        ,btnAlign: 'c'
                        ,content: '<%=basePath%>/teacher/addStudentInfo.jsp'
                    });
                    break;
                case 'update':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else if(data.length > 1){
                        layer.msg('只能同时编辑一个');
                    } else {
                        // layer.alert('编辑 [ejbh]：'+ checkStatus.data[0].ejbh);
                        layer.open({
                            type:2
                            ,title:"修改耳机商品信息"
                            // closeBtn: false,
                            ,shift: 1
                            ,area: ['425px', '800px']
                            ,shadeClose: true
                            // ,btn: ['新增', '取消']
                            // ,btnAlign: 'c'
                            ,content: 'editHeadSet.html'
                            ,success:function (layero,index) {
                                var body = layui.layer.getChildFrame('body', index);//获取弹出层的body标签的所有东西
                                //渲染弹出层
                                body.find("#ejbh").val(data[0].ejbh);
                                body.find("#ejmc").val(data[0].ejmc);
                                body.find("#ejjg").val(data[0].ejjg);
                                body.find("#ejjs").val(data[0].ejjs);
                                body.find("#ejxq").val(data[0].ejxq);
                                body.find("#ejbb").val(data[0].ejbb);
                                body.find("#ejtp").val(data[0].ejtp);
                                body.find("#ejkc").val(data[0].ejkc);

                            }
                        });
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行');
                    } else {//根据耳机的编号去删除对应的数据，后期可以加入误删操作
                        layer.confirm('是否确认删除？', function(index){
                            var length = data.length;
                            while (length--){
                                $.ajax({
                                    url: "HeadSetAction_deleteHeadSetByEJBH.action"
                                    ,async: false
                                    ,data: {
                                        "ejbh":data[length].ejbh
                                    }
                                });
                            }
                            location.reload();//删除完成以后重新载入页面
                        });
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event//获得 lay-event 对应的值
            if(layEvent === 'detail'){
                layer.msg('查看操作');
                layer.alert(JSON.stringify(data));
            } else if(layEvent === 'del'){
                layer.confirm('是否确认删除？', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url: "HeadSetAction_deleteHeadSetByEJBH.action"
                        ,type:'post'
                        ,data:{
                            "ejbh":data.ejbh
                        }
                        ,dataType: "json"
                        ,success: function (data) {
                            alert("success");
                        }
                    });
                });
            } else if(layEvent === 'edit'){
                // layer.msg('编辑操作');
                layer.open({
                    type:2
                    ,title:"修改耳机商品信息"
                    // closeBtn: false,
                    ,shift: 1
                    ,area: ['425px', '800px']
                    ,shadeClose: true
                    // ,btn: ['新增', '取消']
                    // ,btnAlign: 'c'
                    ,content: 'editHeadSet.html'
                    ,success:function (layero,index) {
                        var body = layui.layer.getChildFrame('body', index);//获取弹出层的body标签的所有东西
                        //渲染弹出层
                        body.find("#ejbh").val(data.ejbh);
                        body.find("#ejmc").val(data.ejmc);
                        body.find("#ejjg").val(data.ejjg);
                        body.find("#ejjs").val(data.ejjs);
                        body.find("#ejxq").val(data.ejxq);
                        body.find("#ejbb").val(data.ejbb);
                        body.find("#ejtp").val(data.ejtp);
                        body.find("#ejkc").val(data.ejkc);

                    }
                });

            }
        });

        //分页
        laypage.render({
            elem: 'pageDemo' //分页容器的id
            ,count: 100 //总页数
            ,skin: '#1E9FFF' //自定义选中色值
            //,skip: true //开启跳页
            ,jump: function(obj, first){
                if(!first){
                    layer.msg('第'+ obj.curr +'页', {offset: 'b'});
                }
            }
        });
    });
</script>
</body>
</html>
