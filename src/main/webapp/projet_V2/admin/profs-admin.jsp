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
              <a class="nav-link active" href="home-admin.jsp">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Home</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="students-admin.jsp">
                <i class="ni ni-books text-orange"></i>
                <span class="nav-link-text">Etudiants</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="profs-admin.jsp">
                <i class="fas fa-calendar-check text-success"></i>
                <span class="nav-link-text">Professeurs</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="offres-admin.jsp">
                <i class="ni ni-single-02 text-danger"></i>
                <span class="nav-link-text">Offres</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="offres-effect-admin.jsp">
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
          <!-- Search form -->
          <form class="navbar-search navbar-search-light form-inline mr-sm-3" id="navbar-search-main" method="GET" action="search_servlet">
            <div class="form-group mb-0">
              <div class="input-group input-group-alternative input-group-merge">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-search"></i></span>
                </div>
                <input class="form-control" placeholder="Search" type="text" name="search_prof">
              </div>
            </div>
            <button type="button" class="close" data-action="search-close" data-target="#navbar-search-main" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </form>
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
            <li class="nav-item d-sm-none">
              <a class="nav-link" href="#" data-action="search-show" data-target="#navbar-search-main">
                <i class="ni ni-zoom-split-in"></i>
              </a>
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
    <div class="container mt-6">
      <div class="section-title">
        <h2>E-Learning</h2>
        <p>Les professeurs</p>
      </div>
      <c:if test = "${delete_success_prof == 1}">
      <div class="delete">
	      	<div class="alert alert-success alert-dismissible fade show" role="alert">
			    <span class="alert-icon"><i class="ni ni-like-2"></i></span>
			    <span class="alert-text"><strong>Success!</strong> La suppression du professeur est bien effectuée!</span>
			    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			        <span aria-hidden="true">&times;</span>
			    </button>
			</div>
			</div>
		</c:if>   
    </div>
    
    <!-- Page content -->
    <div class="container-fluid mt-4">
      <div class="row">
        <div class="col">
          <div class="card">
            <!-- Card header -->
            
            <!-- Light table -->
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th scope="col" class="sort" data-sort="name">Nom complet</th>
                    <th scope="col" class="sort" data-sort="">bio</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">ville</th>
                    <th scope="col">Supprimer professeurs</th>
                  </tr>
                </thead>
                <tbody class="list">
                  
                  
                  <c:if test = "${all_profs_size > 0}">
	                  <c:forEach var="i" begin="0" end="${all_profs_size-1}" step="1">
	                  	<tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3">
                          <img alt="Image placeholder" src="${all_profs[i].getImg()}">
                        </a>
                        <div class="media-body">
                          <span class="name mb-0 text-sm">${all_profs[i].getName()} ${all_profs[i].getFamily_name()}</span>
                        </div>
                      </div>
                    </th>

                    <td class="">
                      ${all_profs[i].getBio()}
                    </td>

                    <td>
                      ${all_profs[i].getEmail()}
                    </td>

                    <td>
                     ${all_profs[i].getCity()}
                    </td>

       
                    
                    <td class="">
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light ml-5" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-trash"></i>
                        </a> 
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <label class="dropdown-itemtitle">vous etes sur que vous voulez suprimer ?</label>
                          <form action="supprimer_servlet" method="get">
                          <input type="hidden" name="prof_to_delete" value="${all_profs[i].getId_profs()}" >
                          <button type="submit" class="dropdown-item oui">Oui</button>
                          </form>
                          <a class="dropdown-item" href="profs-admin.html">Non</a>
                        </div>
                    </div>
                    </td>
                  </tr>
	                  </c:forEach>
                  </c:if>
                </tbody>
              </table>
              <c:if test = "${all_profs_size == 0}">
                    <h1 class="text-center my-4">Aucun professeur à affiché</h1>
               </c:if>
            </div>
            <!-- Card footer -->
            
          </div>
        </div>
      </div>
      
      <!-- Footer -->
      <footer class="footer pt-0 container">
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
  <script>
  const myTimeout = setTimeout(time , 3000);

  function time() {
    document.querySelector(".delete").classList.add("d-none");
		${delete_success_prof=-1}
  }
  </script>
</body>

</html>