<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8" isELIgnored="false" %>
	<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
	<link rel="icon" href="img/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="css/common.css" type="text/css"></link>
	<link rel="stylesheet" href="css/login.css" type="text/css"></link>
	<script type="text/javascript" src="script/jquery.js"></script>
	<script type="text/javascript" src="script/common.js"></script>
	<script type="text/javascript">
	
		$(function(){
			//点击更换验证码：
			$("#captchaImage").click(function(){//点击更换验证码

                $(this).attr('src', '/cmfz-admin/manager/getVcode.do?' + Math.floor(Math.random()*100) );
			});

            //  form 表单提交
            $("#loginForm").bind("submit",function(){
                var name=$("#myName").val();
                var pwd=$("#myPwd").val();
                var code=$("#enCode").val();
                if(name==""){
                    alert("用户名不能为空！");
                }
                if(pwd==""){
                    alert("密码不能为空！");
                }
                if(code==""){
                    alert("验证码不能为空！");
                }
                if(name!=""&&pwd!=""&&code!=""){
                    return true;
                }
                return false;
            });

		});



        $(function(){
            //文本框点击事件
            $("#checkname").blur(function(){
                //发送ajax请求
				var manager =$("#checkname").val()
                $.ajax({
                    type:"POST",
                    url:"manager/checkUserName.do",
                    data:{
                        managerName:manager
                    },
                    dataType:"json",
                    error:function(){
                        alert('ajax请求请求错误...')
                    },
                    success:function(data){
                        //清空
                        $("#showRet").empty();
                        if(data.manager=="用户不存在"){
                            //将接收到的数据显示到文本框

                            document.getElementById("nameDiv").innerHTML = "用户不存在";
                            document.getElementById("nameDiv").style.color="red"

                        } else{
                            document.getElementById("nameDiv").innerHTML = "用户已存在"
                            document.getElementById("nameDiv").style.color="green"
                        }
                    },
                })
            })
        });





        function run() {
            var str = "${cookie.checkName.value}";
            var newstr = decodeURI(str);
            document.getElementById("myName").value=newstr;
        }
	</script>
</head>
<body >
	
		<div class="login">
			<form id="loginForm" action="manager/login.do" method="post">
				
				<table>
					<tbody>
						<tr>
							<td width="190" rowspan="2" align="center" valign="bottom">
								<img src="img/header_logo.gif" />
							</td>
							<th>
								用户名:
							</th>
							<td>
								<input type="text"  id="checkname" name="managerName" class="text" value=""  maxlength="20"/><span id="nameDiv" style="display:block"></span>
							</td>
					  </tr>
					  <tr>
							<th>
								密&nbsp;&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="myPwd" name="managerPwd" class="text" value="" maxlength="20" autocomplete="off"/>
							</td>
					  </tr>
					
						<tr>
							<td>&nbsp;</td>
							<th>验证码:</th>
							<td>
								<input type="text" id="enCode" name="vcode" class="text captcha" maxlength="4" autocomplete="off"/>
								<img id="captchaImage" class="captchaImage" src="/cmfz-admin/manager/getVcode.do" title="点击更换验证码" />
							</td>
						</tr>					
					<tr>
						<td>
							&nbsp;
						</td>
						<th>
							&nbsp;
						</th>
						<td>
							<label>
								<input type="checkbox" name="checkName" id="isRememberUsername"  value="true"/> 记住用户名
							</label>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th>&nbsp;</th>
						<td>
							<input type="button" class="homeButton" value="" onclick="location.href='/'"><input type="submit" class="loginButton" value="登录">
						</td>
					</tr>
				</tbody></table>
				<div class="powered">COPYRIGHT © 2008-2017.</div>
				<div class="link">
					<a href="http://www.chimingfowang.com/">持名佛网首页</a> |
					<a href="http://www.chimingbbs.com/">交流论坛</a> |
					<a href="">关于我们</a> |
					<a href="">联系我们</a> |
					<a href="">授权查询</a>
				</div>
			</form>
		</div>
</body>
</html>