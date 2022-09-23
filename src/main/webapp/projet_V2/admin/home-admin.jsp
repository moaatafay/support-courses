<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
    <div class="scrollbar-inner">
      <!-- Brand -->
      <div class="sidenav-header  align-items-center">
        <a class="navbar-brand" href="javascript:void(0)">
          <h1 class="text-primary">E-Learning</h1>
        </a>
      </div>
      <div class="navbar-inner">
        <!-- Collapse -->
        <div class="collapse navbar-collapse" id="sidenav-collapse-main">
          <!-- Nav items -->
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" href="../admin/home-admin.jsp">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Home</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../admin/students-admin.jsp">
                <i class="ni ni-books text-orange"></i>
                <span class="nav-link-text">Etudiants</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../admin/profs-admin.jsp">
                <i class="fas fa-calendar-check text-success"></i>
                <span class="nav-link-text">Professeurs</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../admin/offres-admin.jsp">
                <i class="ni ni-single-02 text-danger"></i>
                <span class="nav-link-text">Offres</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="../admin/offres-effect-admin.jsp">
                <i class="ni ni-paper-diploma text-info"></i>
                <span class="nav-link-text">Offres effectués</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          
          <!-- Navbar links -->
          <ul class="navbar-nav align-items-center  ml-md-auto ">
            <li class="nav-item d-xl-none">
              <!-- Sidenav toggler -->
              <div class="pr-3 sidenav-toggler sidenav-toggler-dark" data-action="sidenav-pin" data-target="#sidenav-main">
                <div class="sidenav-toggler-inner">
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                  <i class="sidenav-toggler-line"></i>
                </div>
              </div>
            </li>
            
            
          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image placeholder" src="../assets/img/theme/team-4.jpg">
                  </span>
                  <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold">Admin</span>
                  </div>
                </div>
              </a>
              <div class="dropdown-menu  dropdown-menu-right">
                <div class="dropdown-header noti-title">
                  <h6 class="text-overflow m-0">Bienvenue!</h6>
                </div>
                <div class="dropdown-divider"></div>
                <form action="logout" method="GET">
                <button type="submit" class="dropdown-item">
                  <i class="ni ni-user-run"></i>
                  <span>Logout</span>
                </button>
                </form>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header -->
    <!-- Header -->
    <div class="header bg-secondary pb-3">
      <div class="container-fluid">
        <div class="header-body">
          
          <h1 class="text-primary my-5 fs-1 text-center pb-4">Bienvenue Admin !</h1>
          
        </div>
      </div>
      <div class="container" style=" max-width: 1183px; ">
      
        <div class="section-title">
          <h2>E-Learning</h2>
          <p>Consultez l'ensemble des données de votre projet E-Learning</p>
        </div> 
        <div class="row">
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">Total Offres</h5>
                      <span class="h2 font-weight-bold mb-0">${count_tables[2]}</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-red text-white rounded-circle shadow">
                        <i class="ni ni-active-40"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">Total Profs</h5>
                      <span class="h2 font-weight-bold mb-0">${count_tables[0]}</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-orange text-white rounded-circle shadow">
                        <i class="ni ni-chart-pie-35"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">Total Students</h5>
                      <span class="h2 font-weight-bold mb-0">${count_tables[1]}<span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                        <i class="ni ni-money-coins"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">offre accepte</h5>
                      <span class="h2 font-weight-bold mb-0">${count_tables[3]}</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-info text-white rounded-circle shadow">
                        <i class="ni ni-chart-bar-32"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div> 
      </div>
      
    </div>
    <!-- Page content -->
    <div class="container" >
      <div class="row">
        <div class="col-md-6">
          <div class="card card-admin mb-3 p-0">
            <img src="../assets/img/students-admin.jpg" class="card-img-top" alt="..." style="width: 100%;height: 70%;">
            <div class="card-body section-title text-center">
              <a href="students-admin.jsp" class="">
                <h2 class="">Etudiants</h2>
                Consultez les étudiants
              </a>
            </div>
          </div>
        </div>

        <div class="col-md-6">
          <div class="card card-admin mb-3 p-0">
            <img src="../assets/img/teacher-admin.webp" class="card-img-top" alt="..." style="width: 100%; height: 70%;">
            <div class="card-body section-title text-center">
              <a href="profs-admin.jsp" class="">
                <h2 class="">Professeurs</h2>
                Consultez les Professeurs
              </a>
            </div>
          </div>
        </div>

      </div>

      <div class="row">
        <div class="col-md-6">
          <div class="card card-admin mb-3 p-0">
            <img src="../assets/img/offres-admin.jpg" class="card-img-top" alt="..." style="width: 100%;height: 70%;">
            <div class="card-body section-title text-center">
              <a href="offres-admin.jsp" class="">
                <h2 class="">Offres</h2>
                Consultez les offres des professeurs
              </a>
            </div>
          </div>
        </div>

        <div class="col-md-6">
          <div class="card card-admin mb-3 p-0">
            <img src="../assets/img/offres-effectues.jpg" class="card-img-top" alt="..." style="width: 100%;height: 70%;">
            <div class="card-body section-title text-center">
              <a href="offres-effect-admin.jsp" class="">
                <h2 class="">offres effectués</h2>
                Consultez les offres effectués
              </a>
            </div>
          </div>
      </div>

      </div>
    </div>
  </div>
  <!-- Argon Scripts -->
  <!-- Core -->
  <script src="../assets/vendor/jquery/dist/jquery.min.js"></script>
  <script src="../assets/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="../assets/vendor/js-cookie/js.cookie.js"></script>
  <script src="../assets/vendor/jquery.scrollbar/jquery.scrollbar.min.js"></script>
  <script src="../assets/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js"></script>
  <!-- Optional JS -->
  <script src="../assets/vendor/chart.js/dist/Chart.min.js"></script>
  <script src="../assets/vendor/chart.js/dist/Chart.extension.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.2.0"></script>
</body>

</html>