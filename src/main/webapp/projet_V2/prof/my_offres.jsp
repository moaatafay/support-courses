<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <input class="form-control" placeholder="Search" type="text" name="search_offre_created">
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
                <a href="accepter_offre.jsp" class="dropdown-item text-center text-primary font-weight-bold py-3">View all</a>
              </div>
            </li>
            
          </ul>
          <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
              <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                  <span class="avatar avatar-sm rounded-circle">
                    <img src="${prof.img}">
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
      <div class="container-fluid mt--2">
        <div class="header-body ">
           
          <div class="row justify-content-center">
                    <h1 class="text-white my-5 fs-1 text-center ">Mes Offres</h1>
            </div>
           <c:if test="${Drop_offre eq 0}">
           <div id="demo"> 
          <div class="alert alert-danger" role="alert">
            Offre de <strong>${matiereSup}</strong> à été <strong>Supprimer</strong>
          </div></div>
          </c:if>
          <c:if test="${edit_offre eq 0}">
          <div id="demo"> 
          <div class="alert alert-success" role="alert">
           Offre de <strong>${matiereUp}</strong> à été <strong>Modifier</strong>
          </div></div>
          </c:if>
          <c:if test="${Ajout_offre eq 0}">
          <div id="demo"> 
          <div class="alert alert-success" role="alert">
           Offre de <strong>${matiereAjouter}</strong> est bien <strong>Ajouter</strong>
          </div></div>
          </c:if>
          <div class="row justify-content-end mb--4">
                  <a href="add_offre.jsp" class="btn btn-success float-right">Ajouter un offre </a>
          </div>
        </div>
        </div>
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
                    <th scope="col" class="sort" data-sort="name">Titre</th>
                    <th scope="col" class="sort" data-sort="prix">Prix</th>
                    <th scope="col" class="sort" data-sort="rate">rate</th>
                    <th scope="col" class="sort">Date de publication</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody class="list">
               <c:if test = "${all_offres_byID_size>=1}">
                <c:forEach var="i" begin="0" end="${all_offres_byID_size-1 }" step="1">
                  <tr>
                    <th scope="row">
                      <div class="media align-items-center">
                        <a href="#" class="avatar rounded-circle mr-3">
                          <img alt="Image placeholder" src="${all_offres_byID[i].imageOffre}">
                        </a>
                        <div class="media-body">
                          <span class="name mb-0 text-sm">${all_offres_byID[i].matiere }</span>
                        </div>
                      </div>
                    </th>
                    <td class="budget">
                      ${all_offres_byID[i].prix } USD
                    </td>
                    <td>
                      <div class="txt-center">
                      <div class="trainer-rank d-flex align-items-center">
                          <span class="mr-2">${all_offres_byID[i].moyenne}</span><i class="far fa-star"></i>
                      </div>
                      </div>
                    </td>
                    <td>
                      <span class="completion mr-2">
                        ${all_offres_byID[i].date }
                      </span>
                    </td>
                    
                    <td class="text-right">
                      <div class="dropdown">
                       <form action="button_offre_update" method="get">
                        <button class="btn btn-sm btn-icon-only text-light" type="submit" name="update_button"  >
                        <input type="hidden" value="${all_offres_byID[i].id_offre}" name="hidden">
                          <i class="fas fa-pen"></i>
                        </button>
                        </form>
                    </div>
                      <div class="dropdown">
                        <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          <i class="fas fa-trash"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                          <label class="dropdown-itemtitle">vous etes sur que vous voulez suprimer ?</label>
                          <form action="Drop_offre_prof" method="post">
	                          <button type="submit" class="dropdown-item">Oui</button>
	                         <input type="hidden" name="id_profs"  value="${prof.id_profs}"/>
	                          <input type="hidden" name="id_offre"  value="${all_offres_byID[i].id_offre}"/>
	                          <input type="hidden" name="matiere"  value="${all_offres_byID[i].matiere}"/>
                          </form>
                          <a class="dropdown-item" href="my_offres.jsp">Non</a>
                        </div>
                      </div>
                    </td>
                  </tr>
                  </c:forEach>
                  </c:if>
                </tbody>
              </table>
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