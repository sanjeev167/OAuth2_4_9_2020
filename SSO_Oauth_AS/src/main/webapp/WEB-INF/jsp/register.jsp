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

		<div class=" register-box"
			style="padding-top: 2px; width: 100%; margin: 0 15% auto">



			<div class="register-box-body" style="width: 40%; float: left; min-height: 510px; border-radius: 15px; margin-left: 10px; ">
				<div class="register-logo" style="font-size: 20px">
				
				<a href="#"><b style="color:blue">Practice</b><b style="color:red">On</b><b style="color:blue">Net</b></a><br>[<b>OAuth2-Sign-Up Guide</b>]
				
				</div>
				<ul>
					   <li>Registering as a customer:-- You will get a <b>CUSTOMER-LEVEL</b> access rights on all the products available at <b style="color:orange;">PracticeOnNet.</b> </li>
				      <br>
				       <li>Registering as a Practicener:-- You will get
				           <ul>
				               <li>a <b>CUSTOMER-LEVEL</b> access rights on all the products available at <b style="color:orange;">PracticeOnNet.</b></li>
				                <li>as well as a <b>Practicener-LEVEL</b> access rights for <b>your Practicing</b> at <b style="color:orange;">PracticeOnNet.</b></li>
				           </ul>
				       <br> </li>
				       <li>Registering as a Provider:-- You will get
				           <ul>
				               <li>a <b>CUSTOMER-LEVEL</b> access rights on all the products available at <b style="color:orange;">PracticeOnNet.</b></li>
				                <li>as well as a <b>Provider-LEVEL</b> access rights for <b>your Provided-Services</b> at <b style="color:orange;">PracticeOnNet.</b></li>
				           </ul>
				       </li>
				        <br>
				        <li>
				            <b>Social-media</b> <b style="color:red;">Sign-Up</b> is for a customer only. It is not allowed either to a <b style="color:blue;">Provider/Practicener.</b>
				        </li>
				</ul>
			</div>

			<div class="register-box-body"
				style="width: 30%; float: left; min-height: 500px; border-radius: 15px; margin-left: 10px;">
				<div class="register-logo" style="font-size: 20px">
				
				<a href="#"><b style="color:blue; ">Practice</b><b style="color:red">On</b><b style="color:blue">Net</b></a><br>[<b>OAuth2-Sign-Up</b>]
				
				</div>
				<span class="login-box-msg">
					<b style="color: blue;">As a</b> <input type="radio" name=cust_type />&nbsp;Customer&nbsp;
					<input type="radio" name=cust_type />&nbsp;Practicener&nbsp; <input
						type="radio" name=cust_type />&nbsp;Provider&nbsp;
				</span>
				<span style="color: red; font-weight: bold;">${message}</span>
				<div class="social-auth-links text-center">
					<a href="registerfb" class="btn btn-facebook btn-flat" style="height: 30px;"><i class="fa fa-facebook"></i> </a> 
					<a href="registergg" class="btn btn-google btn-flat" style="height: 30px;"><i class="fa fa-google-plus"></i> </a>
				    <a href="registergg" class="btn  btn-twitter btn-flat" style="height: 30px;"><i class="fa fa-twitter"></i> </a> 
				    <a href="registergg" class="btn btn-linkedin btn-flat" style="height: 30px;"><i class="fa fa-linkedin"></i> </a>
				    <a href="registergg" class="btn  btn-social btn-git btn-flat" style="height: 30px;"><i class="fa fa-git"></i> </a>
				</div>
				<p style="text-align: center;">- OR -</p>
				<form:form action="/sso/client/register" method="post"
					modelAttribute="registrationModal">
					<div class="form-group has-feedback">
						<form:input type="text" class="form-control" path="name"
							placeholder="Full name" />
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="name" cssClass="error" />
					</div>
					<div class="form-group has-feedback">
						<form:input type="text" class="form-control" path="name"
							placeholder="Full name" />
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="name" cssClass="error" />
					</div>
					<div class="form-group has-feedback">
						<form:input type="email" class="form-control" path="userLoginId"
							placeholder="Email" />
						<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
						<form:errors path="userLoginId" cssClass="error" />
					</div>
					<div class="form-group has-feedback">
						<form:input type="password" class="form-control" path="password"
							placeholder="Password" />
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<form:errors path="password" cssClass="error" />
					</div>
					<div class="form-group has-feedback">
						<form:input type="password" class="form-control"
							path="passwordConf" placeholder="Retype password" />
						<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
						<form:errors path="passwordConf" cssClass="error" />
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label style="margin-left: 22px;"> <input
									type="checkbox">&nbsp;&nbsp; I agree to the <a
									href="terms">terms</a>
								</label> <Strong style="color:red;font-weight:red;">OR</strong> <label> <a href="loginPage">Sign-In</a></label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Sign-Up</button>
						</div>
						<!-- /.col -->
					</div>
				</form:form>
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


