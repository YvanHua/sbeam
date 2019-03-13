<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="com.opensymphony.xwork2.util.*"%> 
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>游戏列表</title>

    <title>Indi</title>
    <s:head theme="xhtml"/>
    <sx:head parseContent="true" extraLocales="utf-8"/>
    <style>
        body
        {
            background-image: url(/css/back.jpg);
            background-size: auto;
        }
    </style>
    <style>

        .header{

            background-color: lightgrey;
            width: 800px;
            height: 300px;
            border: 25px solid green;
            padding: 25px;
            margin: 25px;
        }
        .header img
        {
            float: left;
        }
        .header p{
            display: block;
            width: auto;
            line-height: 14px;
            padding-left: 20px;
        }

        .header p a{
            text-align: left;
            text-decoration: underline;
            color: red;
            font-size: 12px;
        }

        .header photo{
            float:left;
            width:20%;
        }
        .header intro{
            float:right;
            width:80%;
        }
        box{
            background-color: lightgrey;
            width: 1200px;
            height: 400px;
            border: 10px solid black;
            padding: 25px;
            margin: 25px;
        }

    </style>
    <style>
        * {
            margin:0;
            padding:0;
        }

        body {
            font-size:16px;
            font:400 16px/1.62 Georgia,"Xin Gothic","Hiragino Sans GB","Droid Sans Fallback","Microsoft YaHei",sans-serif;font-family: 'PT serif',微軟正黑體,微软雅黑,华文细黑,Microsoft Yahei,Hiragino Sans GB,sans-serif;
            color:#D0CCCC;
            overflow:hidden;
            text-shadow: 0px 0px 1px rgba(24, 22, 22, 0.35);
            background-color: #000;
        }
    </style>


</head>
<body>

<canvas  height="100%" width="100%" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 1;"  id="canvas"></canvas>
<script>
    var canvas,
        ctx,
        width,
        height,
        size,
        lines,
        tick;

    function line() {
        this.path = [];
        this.speed = rand(10, 20);
        this.count = randInt(10, 30);
        this.x = width / 2, +1;
        this.y = height / 2 + 1;
        this.target = {
            x: width / 2,
            y: height / 2
        };
        this.dist = 0;
        this.angle = 0;
        this.hue = tick / 5;
        this.life = 1;
        this.updateAngle();
        this.updateDist();
    }

    line.prototype.step = function(i) {
        this.x += Math.cos(this.angle) * this.speed;
        this.y += Math.sin(this.angle) * this.speed;

        this.updateDist();

        if (this.dist <this.speed) {
            this.x = this.target.x;
            this.y = this.target.y;
            this.changeTarget();
        }

        this.path.push({
            x: this.x,
            y: this.y
        });
        if (this.path.length > this.count) {
            this.path.shift();
        }

        this.life -= 0.001;

        if (this.life <= 0) {
            this.path = null;
            lines.splice(i, 1);
        }
    };

    line.prototype.updateDist = function() {
        var dx = this.target.x - this.x,
            dy = this.target.y - this.y;
        this.dist = Math.sqrt(dx * dx + dy * dy);
    }

    line.prototype.updateAngle = function() {
        var dx = this.target.x - this.x,
            dy = this.target.y - this.y;
        this.angle = Math.atan2(dy, dx);
    }

    line.prototype.changeTarget = function() {
        var randStart = randInt(0, 3);
        switch (randStart) {
            case 0: // up
                this.target.y = this.y - size;
                break;
            case 1: // right
                this.target.x = this.x + size;
                break;
            case 2: // down
                this.target.y = this.y + size;
                break;
            case 3: // left
                this.target.x = this.x - size;
        }
        this.updateAngle();
    };

    line.prototype.draw = function(i) {
        ctx.beginPath();
        var rando = rand(0, 10);
        for (var j = 0, length = this.path.length; j < length; j++) {
            ctx[(j === 0) ? 'moveTo' : 'lineTo'](this.path[j].x + rand(-rando, rando), this.path[j].y + rand(-rando, rando));
        }
        ctx.strokeStyle = 'hsla(' + rand(this.hue, this.hue + 30) + ', 80%, 55%, ' + (this.life / 3) + ')';
        ctx.lineWidth = rand(0.1, 2);
        ctx.stroke();
    };

    function rand(min, max) {
        return Math.random() * (max - min) + min;
    }

    function randInt(min, max) {
        return Math.floor(min + Math.random() * (max - min + 1));
    };

    function init() {
        canvas = document.getElementById('canvas');
        ctx = canvas.getContext('2d');
        size = 30;
        lines = [];
        reset();
        loop();
    }

    function reset() {
        width = Math.ceil(window.innerWidth / 2) * 2;
        height = Math.ceil(window.innerHeight / 2) * 2;
        tick = 0;

        lines.length = 0;
        canvas.width = width;
        canvas.height = height;
    }

    function create() {
        if (tick % 10 === 0) {
            lines.push(new line());
        }
    }

    function step() {
        var i = lines.length;
        while (i--) {
            lines[i].step(i);
        }
    }

    function clear() {
        ctx.globalCompositeOperation = 'destination-out';
        ctx.fillStyle = 'hsla(0, 0%, 0%, 0.1';
        ctx.fillRect(0, 0, width, height);
        ctx.globalCompositeOperation = 'lighter';
    }

    function draw() {
        ctx.save();
        ctx.translate(width / 2, height / 2);
        ctx.rotate(tick * 0.001);
        var scale = 0.8 + Math.cos(tick * 0.02) * 0.2;
        ctx.scale(scale, scale);
        ctx.translate(-width / 2, -height / 2);
        var i = lines.length;
        while (i--) {
            lines[i].draw(i);
        }
        ctx.restore();
    }

    function loop() {
        requestAnimationFrame(loop);
        create();
        step();
        clear();
        draw();
        tick++;
    }

    function onresize() {
        reset();
    }

    window.addEventListener('resize', onresize);

    init();

</script>
<s:iterator value="gamelist">
    <s:set var="td" scope="page" value="dit"/>
    <%
        ValueStack vs = (ValueStack) request.getAttribute("struts.valueStack");
        String t=vs.findString("dir");
        //String filePath = request.getSession().getServletContext().getRealPath("/")+"JSP_Ajax"+"\\";
        //System.out.println("filePath=="+filePath);
        String path =t+"/describe";   // 这边文件目录需改成相对路径
        String realpath= ServletActionContext.getServletContext().getRealPath(t+"/describe/describe.txt");
        File file = new File(realpath);
        FileReader fr = new FileReader(file);  //字符输入流
        BufferedReader br = new BufferedReader(fr);  //使文件可按行读取并具有缓冲功能

        StringBuffer strB = new StringBuffer();   //strB用来存储jsp.txt文件里的内容
        String str = br.readLine();
        while(str!=null){
            strB.append(str).append("<br>");   //将读取的内容放入strB
            str = br.readLine();
        }
        br.close();    //关闭输入流
    %>
    <div class="header">
        <div id="photo"><img src="/sbeam<s:property value="dir"/>/pictures/1.jpg"  width="150px" height="200px"></div>
        <div id="intro"><p>游戏名称<s:property value="name"></s:property></p>
            <p> <%=strB %></p>
        </div>
    </div>
    <br>
</s:iterator>

</body>
</html>
