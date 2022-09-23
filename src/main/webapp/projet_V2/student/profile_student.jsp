<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
  <jsp:include page="links.jsp"/>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
   <jsp:include page="header_student.jsp"/>
    <!-- Header -->
    <!-- Header -->
    <div class="header bg-primary py-1">
      <div class="container-fluid mt--2">
        <div class="header-body">
          
          <h1 class="text-white my-5 fs-1 text-center">Bonjour ${student.name} !</h1>
    
         
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid">
      <a href="edit_profile.jsp" class="btn py-2 px-3 btn-success float-right mt--3">Edit Profile</a>

      <div class="row justify-content-md-center">
        <div class="col-lg-8 ml-7">
          <div class="card card-profile">
            <img src="../assets/img/theme/img-1-1000x600.jpg" alt="Image placeholder" class="card-img-top">
            <div class="row justify-content-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                  <a href="#">
                    <img src="${student.img}" class="rounded-circle">
                  </a>
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
                  ${student.name} ${student.family_name}
                </h5>
                
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${student.email}
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${student.city}
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i>${student.bio}
                </div>
              </div>
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
    </div>
  </div>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="../assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../assets/vendor/js-cookie/js.cookie.js"></script>
  <script src="../assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="../assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.2.0"></script>
</body>
</html>