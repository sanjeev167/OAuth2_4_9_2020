<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%
  String contextPath =request.getContextPath();

%>


<header class="main-header">
    <nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="${contextPath}" class="navbar-brand"><b>Practice</b>OnNet <b>[ SSO ]</b></a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="http://localhost:8080/"><i class="fa fa-home"></i></a></li>          
            	             
          </ul>
          
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu pull-right">
          <ul class="nav navbar-nav">
             <li><a href="${contextPath}/admin/login" data-toggle="control-sidebar">
                 <i	class="fa fa-user"></i></a></li>  
          </ul>
        </div>
        <!-- /.navbar-custom-menu -->
      </div>
      <!-- /.container-fluid -->
    </nav>
  </header>
  