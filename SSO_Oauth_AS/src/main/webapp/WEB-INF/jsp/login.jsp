<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- iCheck -->

<style type="text/css">
<!--
.error {
	color: red;
	font-weight: bold;
}
-->
</style>

<link rel="stylesheet"
	href="${contextPath}/resources/assets/plugins/iCheck/square/blue.css">

<div class="row">
	<div class="col-sm-12">

		<div class=" register-box"	style="padding-top: 2px;   width: 100%; margin: 0 15% auto ">			
			
		    <div class="register-box-body" style="float:left;width: 30%; min-height: 450px; border-radius: 15px;margin-left: 20%;">
				<div class="register-logo" style="font-size: 20px">
				
				<a href="#"><b style="color:blue">Practice</b><b style="color:red">On</b><b style="color:blue">Net</b></a><br>[<b>OAuth2-Sign-In</b>]
				
				</div>
				<span class="login-box-msg">
					<b style="color: blue;">As a</b> <input type="radio" name=cust_type />&nbsp;Customer&nbsp;
					<input type="radio" name=cust_type />&nbsp;Practicener&nbsp; <input
						type="radio" name=cust_type />&nbsp;Provider&nbsp;
				</span> <span style="color: red; font-weight: bold;">${message}</span>
				<div class="social-auth-links text-center">

					<a href="registerfb" class="btn btn-facebook btn-flat"
						style="height: 30px;"><i class="fa fa-facebook"></i> </a> <a
						href="registergg" class="btn btn-google btn-flat"
						style="height: 30px;"><i class="fa fa-google-plus"></i> </a> <a
						href="registergg" class="btn  btn-twitter btn-flat"
						style="height: 30px;"><i class="fa fa-twitter"></i> </a> <a
						href="registergg" class="btn btn-linkedin btn-flat"
						style="height: 30px;"><i class="fa fa-linkedin"></i> </a> <a
						href="registergg" class="btn  btn-social btn-git btn-flat"
						style="height: 30px;"><i class="fa fa-git"></i> </a>
				</div>
				<p style="text-align: center;">- OR -</p>
				<span style="color: red; font-weight: bold;">${errorMessge}</span>
				<span style="color: red; font-weight: bold;">${expired}</span> <span
					style="color: red; font-weight: bold;">${invalid}</span> <span
					style="color: red; font-weight: bold;">${authenticate}</span> <span
					style="color: red; font-weight: bold;">${logout}</span>

				<form:form action="/sso/client/dologin" method="post">
					<div class="form-group has-feedback">
						<input type="email" class="form-control" name="username" placeholder="Email" />
						<span class="glyphicon glyphicon-envelope form-control-feedback"></span>						
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" name="password" placeholder="Password" />
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>						
					</div>

					<div class="row">					
							<div class="col-xs-8">
								<div class="checkbox icheck">
									<label style="margin-left: 22px;"> <input type="checkbox" name="remember-me">&nbsp;&nbsp;Remember Me</label>
								</div>				
							</div>
							<!-- /.col -->
							<div class="col-xs-4"><button type="submit" class="btn btn-primary btn-block btn-flat">Sign-In</button></div>
							<!-- /.col -->						
					</div>
				</form:form>
               
               
               <div>
                   <a href="fgotpwd">Forget password.</a><br>
                   <a href="register">Sign-Up.</a>
               </div><!-- /.col -->
               <!-- /.form-box -->
			</div>
		
		
		</div>
		<!-- /.register-box -->
	</div>

</div>


<!-- jQuery 3 -->
<script
	src="${contextPath}/resources/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- iCheck -->
<script
	src="${contextPath}/resources/assets/plugins/iCheck/icheck.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('input').iCheck({
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%' /* optional */
		});
	});
</script>


