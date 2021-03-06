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
    <title>管理用户登陆信息</title>
    <link rel="stylesheet" href="<%=basePath%>/js/layui/css/layui.css" media="all">
</head>
<body>
<%--搜索框--%>
<div class="demoTable">
    查询用户：
    <div class="layui-inline">
        <input class="layui-input" name="id" id="query_edit" placeholder="请输入用户账号或者姓名" autocomplete="off">
    </div>
    <button class="layui-btn" id="query_button" data-type="select_student" >搜索</button>
</div>
<%--Layui前端table框架,显示登陆教师所有的用户信息--%>
<table class="layui-hide" id="student_info" lay-filter="student_info"></table>
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

        //渲染table表格
        table.render({
            elem: '#student_info'
            //请求后台
            ,url:'/QueryAllUserInfoServlet'//返回Layui所要的json数据，为该老师所教的所有用户
            //表格头部工具，左上角为添加用户、修改用户、删除用户。右上角为一些小功能
            ,toolbar: 'default'
            ,title: '用户信息表'
            ,totalRow: true
            ,cols: [[
                //配置每一列所需要展示的元素,格式给JSON格式,JSONUtil里面提供了List->JSON工具类
                {type: 'checkbox',align:'center', fixed: 'left'}
                ,{field:'uId', title:'用户账号'}
                ,{field:'uName', title:'用户姓名'}
                ,{field:'uPassword', title:'用户密码'}
                ,{fixed: 'right', title:'操作', toolbar: '#table_bar', width:150}
            ]]
            ,id: 'testReload'
            ,page: true

        });
        //渲染table表格 end

        //监听头工具栏事件，表格左上方
        table.on('toolbar(student_info)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    layer.open({
                        type:2
                        ,title:"添加用户信息"
                        // closeBtn: false,
                        ,shift: 1
                        ,area: ['425px', '370px']
                        ,shadeClose: true
                        // ,btn: ['新增', '取消']
                        ,btnAlign: 'c'
                        ,content: '<%=basePath%>/teacher/addUser.jsp'
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
                            ,title:"修改用户信息"
                            // closeBtn: false,
                            ,shift: 1
                            ,area: ['425px', '370px']
                            ,shadeClose: true
                            // ,btn: ['新增', '取消']
                            // ,btnAlign: 'c'
                            ,content: '<%=basePath%>/teacher/editUser.jsp'
                            ,success:function (layero,index) {
                                //获取弹出层的body标签的所有东西
                                var body = layui.layer.getChildFrame('body', index);
                                //渲染弹出层
                                body.find("#u_id").val(data[0].uId);
                                body.find("#u_name").val(data[0].uName);
                                body.find("#u_password").val(data[0].uPassword);
                            }
                        });
                    }
                    break;
                case 'delete':
                    if(data.length === 0){
                        layer.msg('请选择一行*_*');
                    } else {//根据用户编号删除所选中的所有用户
                        var u_id = "(";
                        for (var i=0;i<data.length;i++){
                            u_id  = u_id + data[i].uId+",";
                        }
                        // 构建数据(x,x,x,x)
                        u_id = u_id.substring(0,u_id.length-1)+")";
                        layer.confirm('是否确认删除？', function(index){
                            //请求后台删除，ajax异步请求后台
                            $.ajax({
                                url: "/DeleteUserByIdServlet"
                                ,type:'post'
                                ,data:{
                                    "u_ids":u_id
                                }
                                ,dataType: "json"
                                ,success: function (data) {
                                    if(data>0){
                                        layer.msg("删除成功^_^");
                                        // location.reload();
                                        table.reload('testReload');
                                    }
                                    else{
                                        layer.msg("删除失败，请联系管理员>_<");
                                    }
                                }
                            });

                        });
                    }
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(student_info)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event;//获得 lay-event 对应的值
            //删除操作
            if(layEvent === 'del'){

                layer.confirm('是否确认删除？', function(index){
                    layer.close(index);
                    //向服务端发送删除指令  (id)
                    var u_id = "("+data.uId+")";
                    $.ajax({
                        url: "/DeleteUserByIdServlet"
                        ,type:'post'
                        ,data:{
                            "u_ids":u_id
                        }
                        ,dataType: "json"
                        ,success: function (data) {
                            if(data>0){
                                layer.msg("删除成功^_^");
                                obj.del(); //删除对应行（tr）的DOM结构
                            }
                        }
                    });
                });
            }
            //编辑操作
            else if(layEvent === 'edit'){
                // layer.msg('编辑操作');
                layer.open({
                    type:2
                    ,title:"修改用户信息"
                    // closeBtn: false,
                    ,shift: 1
                    ,area: ['425px', '370px']
                    ,shadeClose: true
                    // ,btn: ['新增', '取消']
                    // ,btnAlign: 'c'
                    ,content: '<%=basePath%>/teacher/editUser.jsp'
                    ,success:function (layero,index) {
                        //获取弹出层的body标签的所有东西
                        var body = layui.layer.getChildFrame('body', index);
                        //渲染弹出层
                        body.find("#u_id").val(data.uId);
                        body.find("#u_name").val(data.uName);
                        body.find("#u_password").val(data.uPassword);
                    }
                });

            }
        });

        //查询用户
        var $=layui.$;//获取jquery标志
        $("#query_button").click(function () {
            //获取query_edit编辑框里面的内容
            var str =$("#query_edit").val();
            // console.log(str);
            //不为null或者“”的时候
            if (str!=null||str!="") {
                table.render({
                    elem: '#student_info'
                    //请求后台
                    , url: '/QueryAdminByIdOrNameServlet?str=' + str
                    , toolbar: 'default'
                    , title: '用户信息表'
                    , totalRow: true
                    , cols: [[
                        //配置每一列所需要展示的元素,格式给JSON格式,JSONUtil里面提供了List->JSON工具类
                        {type: 'checkbox',align:'center', fixed: 'left'}
                        ,{field:'uId', title:'用户账号'}
                        ,{field:'uName', title:'用户姓名'}
                        ,{field:'uPassword', title:'用户密码'}
                        ,{fixed: 'right', title:'操作', toolbar: '#table_bar', width:150}
                    ]]
                    , id: 'testReload'
                    , page: true

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
