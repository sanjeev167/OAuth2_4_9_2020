<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="/" class="navbar-brand"><b>Practice</b>OnNet [Doctor]</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/"><i class="fa fa-home"></i></a></li>          
            <li><a href="/pvt/user/bulletinpage"><i class="fa fa-dashboard"></i></a></li>           
            <li><a href="/pvt/user/db"><i class="fa fa-user"></i></a></li> 	             
          </ul>
          
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu pull-right">
          <ul class="nav navbar-nav">
           <!-- This will be used when there is a multiple Oauth login options have been integrated.
           
           <li><a href="/login">Login</a></li> 
           <li><a href="/ssologout">Logout</a></li> 
            -->  
            <!-- This is used as we have configured sso for authentication and authorization -->  
          <li><a href="http://localhost:7777/sso/client/register">Join</a></li>
           <li><a href="#" id="logoutLinkId">Logout</a></li>
          </ul>
        </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
    <div style="display: none;">
		<form action="/logout" method="post" id="logoutFormId">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <input type="submit" value="Logout">
		</form>
	</div>


	<script
		src="<%request.getContextPath();%>/resources/assets/bower_components/jquery/dist/jquery.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
	
	
	$(document).ready(function(){		
		$("#logoutLinkId").click(function(){	
			$( "#logoutFormId" ).submit();					
		  });
		
		});
	
	
	
	</script>
  </header>
  