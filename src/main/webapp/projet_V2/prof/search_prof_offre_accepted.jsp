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
    <nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
          <form class="navbar-search navbar-search-light form-inline mr-sm-3" id="navbar-search-main" method="Get" action="search_servlet">
            <div class="form-group mb-0">
              <div class="input-group input-group-alternative input-group-merge">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-search"></i></span>
                </div>
                <input class="form-control" placeholder="Search" type="text" name="search_offre_accepted">
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
            <li class="nav-item dropdown">
              <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               
                <c:if test = "${notification_prof_size>=1}">
                <i class="ni ni-bell-55" style="color:red;"></i>
                </c:if>
                 <c:if test = "${notification_prof_size<1}">
                <i class="ni ni-bell-55""></i>
                </c:if>
              </a>
              <div class="dropdown-menu dropdown-menu-xl  dropdown-menu-right  py-0 overflow-hidden">
                <!-- Dropdown header -->
                <div class="px-3 py-3">
                  <h6 class="text-sm text-muted m-0">You have <strong class="text-primary">${notification_prof_size}</strong> notifications.</h6>
                </div>
                <!-- List group -->
                <div class="list-group list-group-flush">
                
                
                 <c:if test = "${notification_prof_size>=1}">
                 <c:if test="${notification_prof_size<=3}">
                <c:forEach var="i" begin="0" end="${notification_prof_size-1}" step="1">
                  
                  <a href="#!" class="list-group-item list-group-item-action">
                    <div class="row align-items-center">
                      <div class="col-auto">
                        <!-- Avatar -->
                        <img alt="Image placeholder" src="${notification_prof[i].img}" class="avatar rounded-circle">
                      </div>
                      <div class="col ml--2">
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <h4 class="mb-0 text-sm">${notification_prof[i].name} ${notification_prof[i].family_name}</h4>
                          </div>
                          <div class="text-right text-muted">
                            <small>${notification_prof[i].date}</small>
                          </div>
                        </div>
                        <p class="text-sm mb-0">Je suis intéressé par votre cours :<strong>${notification_prof[i].matiere }</strong></p>
                      </div>
                    </div>
                  </a>
              
                  </c:forEach>
                  </c:if>
                  
                  <c:if test="${notification_prof_size>3}">
                  <c:forEach var="i" begin="0" end="2" step="1">
                  
                  <a href="#!" class="list-group-item list-group-item-action">
                    <div class="row align-items-center">
                      <div class="col-auto">
                        <!-- Avatar -->
                        <img alt="Image placeholder" src="${notification_prof[i].img}" class="avatar rounded-circle">
                      </div>
                      <div class="col ml--2">
                        <div class="d-flex justify-content-between align-items-center">
                          <div>
                            <h4 class="mb-0 text-sm">${notification_prof[i].name} ${notification_prof[i].family_name}</h4>
                          </div>
                          <div class="text-right text-muted">
                            <small>${notification_prof[i].date}</small>
                          </div>
                        </div>
                        <p class="text-sm mb-0">Je suis intéressé par votre cours:<strong>${notification_prof[i].matiere }</strong></p>
                      </div>
                    </div>
                  </a>
              
                  </c:forEach>
                  </c:if>
                  </c:if>
                </div>
                <!-- View all -->
                <a href="#!" class="dropdown-item text-center text-primary font-weight-bold py-3">View all</a>
              </div>
            </li>
            
          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image " src="${prof.img }">
                  </span>
                  <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold">${prof.name} ${prof.family_name}</span>
                  </div>
                </div>
              </a>
              <div class="dropdown-menu  dropdown-menu-right">
                <div class="dropdown-header noti-title">
                  <h6 class="text-overflow m-0">Bienvenue!</h6>
                </div>
                <a href="profile_prof.jsp" class="dropdown-item">
                  <i class="ni ni-single-02"></i>
                  <span>My profile</span>
                </a>
                <div class="dropdown-divider"></div>
                <form action="deconnexionProf" method="post">
                <button type="submit" class="dropdown-item">
                  <i class="ni ni-user-run"></i>
                  <span>Logout</span>
                </button></form>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Header -->
    <!-- Header -->
    <div class="header bg-primary py-1">
      <div class="container-fluid">
        <div class="header-body ">
           
          <div class="row justify-content-center">
                    <h1 class="text-white my-5 fs-1 text-center ">Les offres accepté</h1>
          </div>
           <c:if test="${Annuler_result eq 0}">
          <div class="alert alert-danger" role="alert">
            Offre have been Cancel 
          </div>
          </c:if>
     
        </div>
        </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid">
      <div class="row">
        <div class="col">
          <div class="card">
          
            <!-- Light table -->
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th scope="col" class="sort" data-sort="name">cours</th>
                    <th scope="col" class="sort" data-sort="budget">Budget</th>
                    <th scope="col" class="sort" data-sort="status">Email</th>
                    <th scope="col">Localisation</th>
                    <th scope="col" class="sort" data-sort="completion">datetime</th>
                   <!--   <th scope="col"></th>-->
                  </tr>
                </thead>
                <tbody class="list">
                
                 <c:if test = "${search_prof_offre_accepted_list_size>=1}">
                    <c:forEach var="i" begin="0" end="${search_prof_offre_accepted_list_size-1 }" step="1">
                  
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3">
                          <img alt="Image" src="${search_prof_offre_accepted_list[i].image }">
                        </a>
                        <div class="media-body">
                          <span class="name mb-0 text-sm">${search_prof_offre_accepted_list[i].matiere}</span>
                        </div>
                      </div>
                    </th>
                    <td class="budget">
                      ${search_prof_offre_accepted_list[i].prix} USD
                    </td>
                    <td>
                     <span class="badge badge-dot mr-4">
                       
                        <span class="status">${search_prof_offre_accepted_list[i].email }</span>
                      </span>
                    </td>
                    <td>
                     <span>${search_prof_offre_accepted_list[i].localisation }</span>
                    </td>
                    <td>
                      <div class="d-flex align-items-center">
                         <span class="completion mr-2">${search_prof_offre_accepted_list[i].date }<br>${search_prof_offre_accepted_list[i].start }-->${search_prof_offre_accepted_list[i].finish }</span>
                      </div>
                    </td>
                   <!-- <td class="text-right">
                        <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-check"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <label class="dropdown-itemtitle">offre a été faite ?</label>
                          <form action="done_offre_accepted" method="get">
                          <input type="hidden" name="id_offre_accepted" value="${prof_accept_list[i].id_offre_accepted }">
                          <input type="hidden" name="id_profs" value="${prof.id_profs }">
                          		<button type="submit" class="dropdown-item">Oui</button> 
                          </form>
                          <a class="dropdown-item" href="offre_accepted.jsp">Non</a>
                          
                        </div>
                      </div>
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-trash"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <label class="dropdown-itemtitle">vous etes sur que vous voulez annuler ?</label>
                          <form action="annuler_offre_accepted" method="post">
                          <input type="hidden" name="id_offre_accepted" value="${prof_accept_list[i].id_offre_accepted }">
                          <input type="hidden" name="id_profs" value="${prof.id_profs }">
                          		<button type="submit" class="dropdown-item">Oui</button> 
                          </form>
                          <a class="dropdown-item" href="offre_accepted.jsp">Non</a>
                        </div>
                      </div>
                      
                    </td>-->
                  </tr>
                  </c:forEach>
                  </c:if>
                </tbody>
              </table>
            </div>
            <!-- Card footer -->
            <div class="card-footer py-4">
              <nav aria-label="...">
                <ul class="pagination justify-content-end mb-0">
                  <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">
                      <i class="fas fa-angle-left"></i>
                      <span class="sr-only">Previous</span>
                    </a>
                  </li>
                  <li class="page-item active">
                    <a class="page-link" href="#">1</a>
                  </li>
                  <li class="page-item">
                    <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">
                      <i class="fas fa-angle-right"></i>
                      <span class="sr-only">Next</span>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
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
</body>
</html>