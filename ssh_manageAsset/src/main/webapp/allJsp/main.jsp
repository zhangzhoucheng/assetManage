<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<!-- 导入css样式 -->
   <link href="../css/main.css">
   <!-- 导入js函数 -->
   <script type="text/javascript" src="../js/main.js"></script>
   <!-- 导入jquery架包 -->
   <script type=" text/javascript" src="../js/jquery-3.2.1.js"></script>
	<style>
		/*百分比布局*/
		body{
			width: 100%;
			height: 100%;
			margin: 0 auto;
		}
		#external{
			width: 80%;
			height: 100%;
			margin: 0 auto;
		}
		#top{
			width: 100%;
			height: 15%;
			background-color:greenyellow;
			
		}
		#mid{
			width: 100%;
			height: 75%;
			
		}
		#mid_left{
			width: 24%;
			height: 100%;
			float: left;
		}
		#mid_left_top{
			width: 100%;
			height: 40%;
			background-color: azure;
		}
		#mid_left_top div{
			font-size: 1.5vw;
		}
		#mid_left_mid{
			width: 100%;
			height: 30%;
			
		}
		#mid_left_down{
			width: 100%;
			height: 30%;
			background-color: aquamarine;
		}
		#mid_right{
			width: 76%;
			height: 100%;
			float: left;
		}
		
		#down{
			width: 100%;
			height: 10%;
			background-color: deepskyblue;
		}
		
	</style>
	<script>
		$(document).ready(function(){
			
		  //获取浏览器高度，从而完成百分比，宽度默认会去适应浏览器宽，
		  var browserHeight=$(window).height();
		  $("body").height(""+browserHeight+"px");
		})
		//当窗口改变时候会自适应
		$(window).resize(function(){
			 var browserHeight=$(window).height();
		  $("body").height(""+browserHeight+"px");
		  
		  /*
	         * 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active
	         * （实现左侧菜单中的标签点击后变化的效果）
	         */

	            $('#mid_left_top div a').click(function (e) {
	                //e.preventDefault();    加上这句则导航的<a>标签会失效
	                $('#mid_left_top div a').removeClass('active');
	                $(this).addClass('active');
	            });
	       
		})
		
		/* 用于点击后显示页面操作 ，即在右侧div显示jsp页面 */
		function showAtRight(url) {
            var xmlHttp;
            
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlHttp=new XMLHttpRequest();    //创建 XMLHttpRequest对象
            }
            else {
                // code for IE6, IE5
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
        
            xmlHttp.onreadystatechange=function() {        
                //onreadystatechange — 当readystate变化时调用后面的方法
                
                if (xmlHttp.readyState == 4) {
                    //xmlHttp.readyState == 4    ——    finished downloading response
                    
                    if (xmlHttp.status == 200) {
                        //xmlHttp.status == 200        ——    服务器反馈正常            
                        
                        document.getElementById("mid_right").innerHTML=xmlHttp.responseText;    //重设页面中id="mid_right"的div里的内容
                        executeScript(xmlHttp.responseText);    //执行从服务器返回的页面内容里包含的JavaScript函数
                    }
                    //错误状态处理
                    else if (xmlHttp.status == 404){
                        alert("出错了☹   （错误代码：404 Not Found），……！"); 
                        /* 对404的处理 */
                        return;
                    }
                    else if (xmlHttp.status == 403) {  
                        alert("出错了☹   （错误代码：403 Forbidden），……"); 
                        /* 对403的处理  */ 
                        return;
                    }
                    else {
                        alert("出错了☹   （错误代码：" + request.status + "），……"); 
                        /* 对出现了其他错误代码所示错误的处理   */
                        return;
                    }   
                } 
                    
              }
            
            //把请求发送到服务器上的指定文件（url指向的文件）进行处理
            xmlHttp.open("GET", url, true);        //true表示异步处理
            xmlHttp.send();
        }        
	</script>
	<body >
		
		<div id="external">
			
			<div id="top">
				理财小精灵
			</div>
			
			<div id="mid">
				<div id="mid_left">
					
					<div id="mid_left_top">
						<div id="mid_left_top_menu_i1">
							<a href="###" onclick="showAtRight('manageMoneyNews.jsp')">理财资讯</a>
						</div>
						<div id="mid_left_top_menu_i2">
							<a href="###" onclick="showAtRight('costQuery.jsp')">费用查询</a>
						</div>
						<div id="mid_left_top_menu_i3">
							<a href="###" onclick="showAtRight('addRecord.jsp')">费用记录</a>
						</div>
						<div id="mid_left_top_menu_i4">
							<a href="###" onclick="showAtRight('MoneyUseAnalyse.jsp')">费用分析</a>
						</div>
					</div>
					
					<div id="mid_left_mid">
						<!--留白用户灵活控制布局-->
					</div>
					<div id="mid_left_down">
						<!--放小图片-->
					</div>
						
				</div>
				<div id="mid_right">
					<!--用于加载点击菜单栏所对应的页面,如下是初始页面-->
					<jsp:include page="manageMoneyNews.jsp"></jsp:include>
				</div>
			</div>
			
			<div id="down">
				
			</div>
			
		</div>
		
	</body>
</html>
