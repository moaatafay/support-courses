<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
    <!-- Header -->
    <div class="header bg-secondary pb-3">
      <div class="container-fluid">
        <div class="header-body">
          <div class="col-lg-6 col-7 pt-2">
          </div>
          <h1 class="text-primary my-5 fs-1 text-center">Bienvenue ${prof.name} !</h1>
          <div class="row align-items-center py-4">
          </div>
          <!-- Card stats -->
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
    </div>


    <!-- Page content -->
    <div class="container mt-6" >
      <div class="row">
        <!-- ======= Courses Section ======= -->
    <section id="courses" class="courses">
      <div class="container"  data-aos="fade-up">
        <div class="section-title row pl-3">
          <h2>Offres</h2>
          <p class="col-10 p-0">Offres Populaires</p>
          <div class="mb-2 d-flex justify-content-end col-2">
            <a class="btn btn-primary" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="btn btn-primary" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
        </div>
      </div>

        

         <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
          <div class="carousel-inner">
            <div class="carousel-item active">
              <div class="row" data-aos="zoom-in" data-aos-delay="100">
                <c:if test = "${pupilaire_3_offres_size>=1}">
  					<c:forEach var="i" begin="0" end="2" step="1">
  					   <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                  		<div class="course-item">
                  		
                    		<img src="${pupilaire_3_offres[i].imageOffre}" class="img-offre" alt="..."><%--  ${pupilaire_3_offres[i].imageOffre}  --%>
                    			<div class="course-content">
                      				<div class="d-flex justify-content-between align-items-center mb-3">
                        				<h4>${pupilaire_3_offres[i].matiere}</h4>
                        				<p class="price">${pupilaire_3_offres[i].prix} $</p>
                      				</div>
                      					<h3><a href="course-details.html"></a></h3>
                     					 <p>${pupilaire_3_offres[i].infos}.</p>
                     					 <p>${pupilaire_3_offres[i].email}</p>
                     					 <p>${pupilaire_3_offres[i].date}</p>
                      					<div class="trainer d-flex justify-content-between align-items-center">
                        				<div class="trainer-profile d-flex align-items-center">
                        				
                          				<img src="${pupilaire_3_offres[i].img}" class="img-fluid mr-2" alt="">
                          				<span><small>${pupilaire_3_offres[i].name} ${pupilaire_3_offres[i].family_name}</small></span>
                          			    
                        				</div>
                        				<div class="trainer-rank d-flex align-items-center">
                          					<span class="mr-2">${pupilaire_3_offres[i].moyenne}</span><i class="far fa-star"></i>
                        				</div>
                      					</div>
                    			</div>
                    			
                  				</div>
                				</div> <!-- End Course Item-->
               	</c:forEach>
  				</c:if>
              </div>
            </div>
            <div class="carousel-item">
              <div class="row" data-aos="zoom-in" data-aos-delay="100">
                 <c:if test = "${pupilaire_3_offres_size>=1}">
  					<c:forEach var="i" begin="3" end="5" step="1">
  					<div class="col-lg-4 col-md-6 d-flex align-items-stretch">
                  		<div class="course-item">
                    		<img src="${pupilaire_3_offres[i].imageOffre}" class="img-offre" alt="...">  <%--  ${pupilaire_3_offres[i].imageOffre}  --%>
                    			<div class="course-content">
                      				<div class="d-flex justify-content-between align-items-center mb-3">
                        				<h4>${pupilaire_3_offres[i].matiere}</h4>
                        				<p class="price">${pupilaire_3_offres[i].prix} $</p>
                      				</div>
                      					<h3><a href="course-details.html"></a></h3>
                     					 <p>${pupilaire_3_offres[i].infos}.</p>
                     					 <p>${pupilaire_3_offres[i].email}</p>
                     					 <p>${pupilaire_3_offres[i].date}</p>
                      					<div class="trainer d-flex justify-content-between align-items-center">
                        				<div class="trainer-profile d-flex align-items-center">
                        				
                          				<img src="${pupilaire_3_offres[i].img}" class="img-fluid mr-2" alt="">
                          				<span>${pupilaire_3_offres[i].name} ${pupilaire_3_offres[i].family_name}</span>
                          			    
                        				</div>
                        				<div class="trainer-rank d-flex align-items-center">
                          					<span class="mr-2">${pupilaire_3_offres[i].moyenne}</span><i class="far fa-star"></i>
                        				</div>
                      					</div>
                    			</div>
                    			
                  				</div>
                				</div> <!-- End Course Item-->
  					   
               	</c:forEach>
  				</c:if>
              </div>
            </div>
          </div>
          
        </div>
      </div>
    </section>
    <!-- End Courses Section -->
  </div>

      <!-- Footer -->
      <footer class="footer container">
        <div class="row align-items-center justify-content-lg-between">
          <div class="col-lg-6">
            <div class="copyright text-center  text-lg-left  text-muted">
              &copy; 2021 <a href="#" class="font-weight-bold ml-1" target="_blank">E-LEARNING</a>
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
  <!-- Optional JS -->
  <script src="../assets/vendor/chart.js/dist/Chart.min.js"></script>
  <script src="../assets/vendor/chart.js/dist/Chart.extension.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.2.0"></script>
</body>
</html>