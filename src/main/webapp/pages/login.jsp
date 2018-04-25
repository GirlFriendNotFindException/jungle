<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>



		<script>
		
		
			$(document).ready(function() {
				//打开会员登录 
				$("#Login_start_").click(function() {
					$("#regist_container").hide();
					$("#_close").show();
					$(".loginAndregist").show();
					$("#_start").css({
						left: '350px',
						height: '520px',
						width: '400px'
					})
						$("#login_container").show();
						$("#_close").css({
							height: '40px',
							width: '40px'
						});
					});
				
				//打开会员注册
				$("#Regist_start_").click(function() {
					$("#login_container").hide();
					$("#_close").show();
					$(".loginAndregist").show();
					$("#_start").css({
						left: '350px',
						height: '520px',
						width: '400px'
					})
						$("#regist_container").show();
						$("#_close").css({
							height: '40px',
							width: '40px'
						});
					
				});
				
				//关闭
				$("#_close").click(function() {
					
					$("#_close").css({
						height: '0px',
						width: '0px'
					})
						$("#_close").hide();
						$("#login_container").hide();
						$("#regist_container").hide();
						$("#_start").css({
							left: '0px',
							height: '0px',
							width: '0px'
						});
						$(".loginAndregist").hide();
					
				});
				//去 注册
				$("#toRegist").click(function(){
					$("#login_container").hide();
					$("#regist_container").show();
				});
				//去 登录
				$("#toLogin").click(function(){
					$("#regist_container").hide();
					$("#login_container").show();
				});
				
				/*登录事件*/
				$("#login_btn").click(function(){
					var username=$("#login_number").val();
					var password=$("#login_password").val();
					var param={"username":username, "password":password};
					var arr=[];
					arr.push(param);
					sendRequest("/jungle/login/login.action", JSON.stringify(arr), function(data){
						if(data==null | data==undefined |  data.usertype==null)  return;
							$(".loginAndregist").hide();
							param['usertype']=data.usertype;
							param['state']="true";
							localStorage.setItem('user', JSON.stringify(param));
							
							$("#Login_start_").html(param['username']+"&emsp;|&emsp;");
							$("#Regist_start_").html(param['usertype']==1?'管理员':'普通用户');
							$('#Regist_start_').unbind('click');
					});
				});
				
				setloginItem();
			
			/* 注册事件 */
				$("#regist_btn").click(function(){
					var userdata=getFormData("registform");
					sendRequest("/jungle/regist/regist.action", JSON.stringify(userdata), function(data){
						alert(data);
					});
				});
			});
			
		</script>
		
		
		
		
		<script type="text/javascript">
		var clock = '';
		var nums = 30;
		var btn;
		function sendCode(thisBtn) {
			btn = thisBtn;
			btn.disabled = true; //将按钮置为不可点击
			btn.value = '重新获取（'+nums+'）';
			clock = setInterval(doLoop, 1000); //一秒执行一次
		}

		function doLoop() {
			nums--;
			if (nums > 0) {
				btn.value = '重新获取（'+nums+'）';
			} else {
				clearInterval(clock); //清除js定时器
				btn.disabled = false;
				btn.value = '点击发送验证码';
				nums = 10; //重置时间
			}
		}
		
		$(document).ready(function(){
			$("#login_QQ").click(function(){
				alert("暂停使用！");
			});
			$("#login_WB").click(function(){
				alert("暂停使用！");
			});
		});
		
		function setloginItem(){
			var user=localStorage.getItem('user');
			if(user!=null  && user!=undefined  ){
				var userobj=$.parseJSON( user ); 
				$("#Login_start_").html(userobj['username']+"&emsp;|&emsp;");
				$("#Regist_start_").html(userobj['usertype']==1?'管理员':'普通用户');
				$('#Regist_start_').unbind('click');
			}
		}
	</script>
	
		<!-- <a id="Login_start_" class="btn btn-danger" style="width:100px;height:40px;border-radius: 0;">登陆</a>
		<a id="Regist_start_" class="btn btn-success" style="width:100px;height:40px;border-radius: 0;">注册</a> -->

		<!-- 会员登录  -->
		<!--<div id='Login_start' style="position: absolute;" >-->
		<div id='_start'>
			<div id='_close' style="display: none;">
				<span class="glyphicon glyphicon-remove"></span>
			</div>
			<br /> 
			<!--登录框-->
			<div id="login_container">
				<div id="lab1">
					<span id="lab_login">会员登录</span>
					<span id="lab_toRegist">
						&emsp;还没有账号&nbsp;
						<span id='toRegist' style="color: #EB9316;cursor: pointer;">立即注册</span>
					</span>
				</div>
				<div style="width:330px;">
					<span id="lab_type1">手机号/账号登陆</span>
				</div>
				
				
				
				<div id="form_container1">
					<br />
					<input type="text" class="form-control" placeholder="手机号/用户名" id="login_number" value="admin" />
					<input type="password" class="form-control" placeholder="密码" id="login_password" />
					<input type="button" value="登录" class="btn btn-success" id="login_btn" />
					<span id="rememberOrfindPwd">
						<span>
							<input id="remember" type="checkbox" style="margin-bottom: -1.5px;"/>
						</span>
					<span style="color:#000000">
							记住密码&emsp;&emsp;&emsp;&emsp;
						</span>
					<span style="color:#000000">
							忘记密码
						</span>
					</span>
				</div>
				
				
				
				

				<div style="display:block;width:330px;height：40px;">
					<span id="lab_type2">使用第三方直接登陆</span>
				</div>
				<div style="width:330px;height:100px;border-bottom: 1px solid #FFFFFF;">
					<br />
					<button id="login_QQ" type="button" class="btn btn-info">
						<img src="../img/qq32.png" style="width:20px;margin-top:-4px;" />&emsp;QQ登录
					</button>
					<button id="login_WB" type="button" class="btn btn-danger">
						<img src="../img/sina32.png" style="width:20px;margin-top:-4px;" />&emsp;微博登录
					</button>
				</div>
			</div>
			<!-- 会员注册 -->
			<div id='regist_container' style="display: none;">
				<div id="lab1">
					<span id="lab_login">会员注册</span>
					<span id="lab_toLogin">
						&emsp;已有账号&nbsp;
						<span id='toLogin' style="color: #EB9316;cursor: pointer;">立即登录</span>
					</span>
				</div>
				<div id="form_container2" style="padding-top: 25px;">
					<form id="registform">
					<input type="text" class="form-control" value="admin"  placeholder="用户名" id="regist_account" name="username"/>
					<input type="password" class="form-control" placeholder="密码" id="regist_password1"  name="password"/>
					<input type="password" class="form-control" placeholder="确认密码" id="regist_password2" name="regist_password2"/>
					<input type="text" class="form-control" placeholder="手机号" id="regist_phone" name="phone" />
					<input type="text" class="form-control" placeholder="验证码" id="regist_vcode" />
					<!--<button id="getVCode" type="button" class="btn btn-success" >获取验证码</button>-->
					<input id="getVCode" type="button" class="btn btn-success" value="点击发送验证码" onclick="sendCode(this)" />
					</form>
				</div>
				<input type="button" value="注册" class="btn btn-success" id="regist_btn" />
			</div>
		</div>

