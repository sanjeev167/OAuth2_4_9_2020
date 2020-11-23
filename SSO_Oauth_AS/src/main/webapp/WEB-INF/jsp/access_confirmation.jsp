<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ page
	import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page
	import="org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>

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

		<div id="content">

			<div class=" register-box"
				style="padding-top: 2px; width: 100%; margin: 0 30% auto">



				<div class="register-box-body"
					style="width: 47%; float: left; min-height: 400px; border-radius: 15px; margin-left: 10px;">
					<div class="register-logo" style="font-size: 20px">
						<a href="#"><b style="color: blue">Practice</b><b
							style="color: red">On</b><b style="color: blue">Net</b></a><br>[<b>OAuth2-Approval</b>]

					</div>

					
						<b style="color:red; font-size:16px ">
						<c:out value="${logedInUser}" />
						</b>  => 
						<b>
						<c:out value="${client.clientId}"/></b> wants to access your protected resources.<br>
						<br>
						<!-- checkbox -->
						<div>
						<form id="confirmationForm" name="confirmationForm" action="/sso/oauth/authorize" method="post">
				               <input name="user_oauth_approval" value="true" type="hidden" />

							<div class="form-group" style="text-align: left">
							<c:set var="count" value="0" scope="page" />
							<c:forEach items="${client.getScope()}" var="scope">
							   <c:set var="count" value="${count + 1}" scope="page"/>
							   [&nbsp<c:out value="${count}"/>.&nbsp] &nbsp;  
							   <c:out value="${scope}"></c:out>&nbsp; &nbsp;&nbsp; &nbsp;
							  <input type="radio" name="scope.${scope}" value="true" checked>&nbsp; &nbsp;Approve</input> &nbsp; &nbsp;
							  <input type="radio" name="scope.${scope}" value="false">&nbsp; &nbsp;Deny</input><br>
							
								
							</c:forEach>
							   &nbsp; <input name="authorize" value="Authorize" type="submit" class="btn btn-sml btn-primary pull-right"/>
								
								
															
								
								
							</div>
						</form>
						</div>
						<!-- Following will be implemented lattter -->
						
						<div style="display:none;">
						<div>
						<hr>
							<h4>Already approved <b style="color:red;">scope-list of other applications</b></h4>
						<hr>	
						</div>
						
						<div >
							<div style="width: 50%;float: left; max-height: 150px;">Client-Application</div>
							<div style="width: 50%; float: left;">
								Permission
								<button type="submit" class="btn btn-sml btn-primary pull-right">Update-Approval</button>
							</div>
						</div>
						<div
							style="width: 50%; float: left; max-height: 100px; overflow: auto;">

							<a href="#"><input type="radio" name="alreadyAssignedApp">
								App-1</a><br> <a href="#"><input type="radio"
								name="alreadyAssignedApp"> App-1</a><br> <a href="#"><input
								type="radio" name="alreadyAssignedApp"> App-1</a><br> <a
								href="#"><input type="radio" name="alreadyAssignedApp">
								App-1</a><br> <a href="#"><input type="radio"
								name="alreadyAssignedApp"> App-1</a><br> <a href="#"><input
								type="radio" name="alreadyAssignedApp"> App-1</a>

						</div>

						<div
							style="width: 50%; float: left; max-height: 100px; overflow: auto;">

							<div class="form-group"
								style="text-align: left; margin-left: 15px;">
								<label> <input type="checkbox" class="flat-red">
									Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br> <label> <input type="checkbox"
									class="flat-red"> Scope-1
								</label><br>
							</div>
						</div>
					 </div>
				</div>

			</div>
			<!-- /.register-box -->
		</div>

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