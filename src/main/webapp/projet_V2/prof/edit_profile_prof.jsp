<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="E-learning platforme pour la gestion des cours de soutiens.">
  <meta name="author" content="E-LEARNING Team">
  <title>E-Learning platforme</title>
  <!-- Favicon -->
  <link rel="icon" type="image/png" sizes="16x16"  href="../assets/img/brand/favicon-16x16.png">
  <!-- Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet"> 

  <!-- Icons -->
  <link rel="stylesheet" href="../assets/vendor/nucleo/css/nucleo.css" type="text/css">
  <link rel="stylesheet" href="../assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
  <!-- Page plugins -->
  <!-- Argon CSS -->
  <link rel="stylesheet" href="../assets/css/argon.css?v=1.2.0" type="text/css">
  <link rel="stylesheet" href="../assets/css/style.css">

</head>

<body>

  <!-- Sidenav -->
  <jsp:include page="linksprof.jsp"></jsp:include>
  
  
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <jsp:include page="header_prof.jsp"></jsp:include>
    
    <!-- Header -->
    <div class="header bg-primary py-3">
      <div class="container-fluid">
        <div class="header-body">
          
          <h1 class="text-white my-5 fs-1 text-center">Editez votre profile </h1>
          <c:if test="${edit_profile_result eq -1}">
          <div id="demo"> 
          <div class="alert alert-danger" role="alert">
            email already used
          </div></div>
          </c:if>
          <c:if test="${edit_profile_result eq 0}">
          <div id="demo"> 
          <div class="alert alert-success" role="alert">
           data have been changed successfully
          </div></div>
          </c:if>
    
         
        </div>
      </div>
    </div>
    <!-- Header -->
    
    <!-- Page content -->
    <form action="edit_profile_Prof" method="post" enctype="multipart/form-data">
    <div class="container-fluid">
      <div class="row">
        <div class="col-xl-4 order-xl-2">
          <div class="card card-profile">
            <img src="../assets/img/theme/img-1-1000x600.jpg" alt="Image placeholder" class="card-img-top">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                
                    <img src="${prof.img}" class="rounded-circle" style="border-radius:0.5">
                    <label class=dot><input type="file" name="img" value="${prof.img}"><i class="fas fa-camera"></i></label>
                </div>
              </div>
            </div>
            
            <div class="card-body pt-6">
              <div class="row">
                <div class="col">
                  
                </div>
              </div>
              <div class="text-center">
                <h5 class="h3">
                 ${prof.name} ${prof.family_name}
                </h5>
                
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${prof.email}
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${prof.city}
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${prof.bio}
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-8 order-xl-1">
          <div class="card">
            <div class="card-header">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Edit profile <small>les champs vide ne seront pas modifier</small></h3>
                </div>
                
              </div>
            </div>
            <div class="card-body">
              <form action="edit_profile_Prof" method="post">
                <h6 class="heading-small text-muted mb-4">User information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">name</label>
                        <input type="text" name="name" id="input-username" class="form-control" placeholder="${prof.name}" ">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Email address</label>
                        <input type="email" name="email" id="input-email" class="form-control" placeholder="${prof.email}">
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-first-name">family name</label>
                        <input type="text" name="family_name" id="input-first-name" class="form-control" placeholder="${prof.family_name}">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">password</label>
                        <input type="password" name="password" id="input-last-name" class="form-control" placeholder="......." >
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4" />
                <!-- Address -->
                <h6 class="heading-small text-muted mb-4">Contact information</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label class="form-control-label" for="input-address">Address</label>
                        <input name="city" id="input-address" class="form-control" placeholder="${prof.city}" type="text">
                      </div>
                    </div>
                  </div>
                 </div>
                <!-- Description -->
                <h6 class="heading-small text-muted mb-4">About me</h6>
                <div class="pl-lg-4">
                  <div class="form-group">
                    <label class="form-control-label">About Me</label>
                    <textarea name="bio" rows="4" class="form-control" placeholder="${prof.bio}"></textarea>
                  </div>
                </div>
                    </div>
    			<div class="row form-group d-flex justify-content-center mb-0"   >
          		<button type="submit" class="  btn  btn-lg mb-"  style="background-color: #5E72E4; color:#FFFFFF; width: 20%;">edit profile</button>
          		</div>
        		<br>
       			<input type="hidden" name="id_profs" value="${prof.id_profs}">
            </div>
          </div>
        </div>
      </div>
      <!-- Footer -->
      <footer class="footer pt-0">
        <div class="row align-items-center justify-content-lg-between">
          <div class="col-lg-6">
            <div class="copyright text-center  text-lg-left  text-muted">
              &copy; 2021 <a href="" class="font-weight-bold ml-1" target="_blank">E-LEARNING</a>
            </div>
          </div>
        </div>
      </footer>
    </form>
  </div>
 
  <!-- Argon Scripts -->
  <!-- Core -->
  <script type="text/javascript">

	  const myTimeout = setTimeout(myGreeting, 5000);

	  function myGreeting() {
	    //document.getElementById("demo").innerHTML = "";
		  document.getElementById("demo").style.display = "none";
		  ${refuse_result=-1}
		  ${Accept_result=-1}
		  ${Drop_offre=-1}
		  ${edit_offre=-1}
		  ${Ajout_offre=-1}
		  ${edit_profile_result=1}
	  }
	  </script>
  <script src="../assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../assets/vendor/js-cookie/js.cookie.js"></script>
  <script src="../assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="../assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.2.0"></script>
</body>
</html>
