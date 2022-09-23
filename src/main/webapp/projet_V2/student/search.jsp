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
  <jsp:include page="links.jsp"/>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <jsp:include page="header_student.jsp"/>
    <!-- Header -->
    <!-- Header -->
    <!-- Page content -->
    <div class="container mt-6" >
      <div class="row">
        <!-- ======= Courses Section ======= -->
    <section id="courses" class="courses">
      
      <div class="container" style="width: 1300px;" data-aos="fade-up">
        <div class="section-title row pl-3">
          <h2>E-Learning</h2>
          <p class="col-10 p-0">Offres</p>
      </div>
      </div>
      <div class="container">
        <div class="row" data-aos="zoom-in" data-aos-delay="100">
           <c:if test = "${search_student_list_size>=1}">
  		    <c:forEach var="i" begin="0" end="${search_student_list_size-1}" step="1"> 
  		    <div class="col-lg-auto col-md-6 d-flex align-items-stretch mb-4">
                  		<div class="course-item">
                    		<img src="${search_student_list[i].imageOffre}" class="img-offre" alt="...">
                    			<div class="course-content">
                      				<div class="d-flex justify-content-between align-items-center mb-3">
                        				<h4>${search_student_list[i].matiere}</h4>
                        				<p class="price">${search_student_list[i].prix} $</p>
                      				</div>
                      					<h3><a href="course-details.html"></a></h3>
                     					 <p>${search_student_list[i].infos}.</p>
                     					 <p>${search_student_list[i].email}</p>
                     					 <p>${search_student_list[i].date}</p>
                      					<div class="trainer d-flex justify-content-between align-items-center">
                        				<div class="trainer-profile d-flex align-items-center">
                        				<form action="show_me_prof_profile" method="post">
                        				<input type="hidden" name="id_offre" value="${search_student_list[i].id_offre}">
                          				<button type="submit" style="border:none;background-color:white;">
                          				<img src="${search_student_list[i].img}" class="img-fluid mr-2" alt="">
                          				<span>${search_student_list[i].name} ${search_student_list[i].family_name}</span>
                          			    </button>
                          				</form>
                        				</div>
                        				<div class="trainer-rank d-flex align-items-center">
                          					<span class="mr-2">${search_student_list[i].moyenne}</span><i class="far fa-star"></i>
                        				</div>
                      					</div>
                    			</div>
                    			<div class="card-footer bg-transparent border-success">
                      			<form action='contacter_prof' method='post'>
                      			<input type="hidden" name="contacter_prof_id_offre" value="${search_student_list[i].id_offre}">
                      			<button class="btn bg-primary text-secondary">Contacter prof</button>
                      			</form>
                    			</div>
                  				</div>
                				</div> <!-- End Course Item-->
         
            </c:forEach>
  		  </c:if>
      </div> 
      
    </div>
    </section>
    <!-- End Courses Section -->    
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
  <!-- Optional JS -->
  <script src="../assets/vendor/chart.js/dist/Chart.min.js"></script>
  <script src="../assets/vendor/chart.js/dist/Chart.extension.js"></script>
  <!-- Argon JS -->
  <script src="../assets/js/argon.js?v=1.2.0"></script>
</body>
</html>