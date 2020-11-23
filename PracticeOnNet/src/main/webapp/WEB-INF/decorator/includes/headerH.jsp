<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="#" class="navbar-brand"><b>Practice</b>OnNet</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/"><i class="fa fa-home"></i></a></li>          
                         
          </ul>
          
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu pull-right">
          <ul class="nav navbar-nav">
           <!-- This will be used when there is a multiple Oauth login options have been integrated.
           
           <li><a href="/login">Login</a></li> 
           
            -->  
            <!-- This is used as we have configured sso for authentication and authorization -->  
           <!-- <li><a href="oauth2/authorization/custom-client">Login</a></li> -->
          </ul>
        </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  