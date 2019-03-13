<%--
  Created by IntelliJ IDEA.
  User: huayifan
  Date: 2019/1/4
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<%
    String location="/sbeam/upload/game/虎牙/video/test.mp4";
    %>
<script src="ckplayer.js" type="text/javascript" ></script>
<div class="m" >
    <div id="video" style="width:30%;height:20%;"></div>
  <script type="text/javascript">
            var url="<%=location%>";
        var videoObject = {
        container: '#video',//“#”代表容器的ID，“.”或“”代表容器的class
        variable: 'player',//该属性必需设置，值等于下面的new chplayer()的对象
        flashplayer:false,//如果强制使用flashplayer则设置成true
        allowFullScreen:false,//是否支持全屏
        video:{
            file:'${ location }',//视频地址
            type:'video/mp4'
        }
    };
        var player=new ckplayer(videoObject);
  </script>
 </div>

</body>
</html>
