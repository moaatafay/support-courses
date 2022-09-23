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
      <div class="container mt-6">
        <div class="section-title">
          <h2>E-Learning</h2>
          <p>vos demande accepte:</p>
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
                    <th scope="col" class="sort" data-sort="family_name"></th>
                  </tr>
                </thead>
                <tbody class="list">
                <c:if test = "${notification_size>=1}">
  					<c:forEach var="i" begin="0" end="${notification_size-1}" step="1">
  					  <tr>
                  		<td>
                  			<a href="#!" class="list-group-item list-group-item-action">
                    			<div class="row align-items-center">
                      				<div class="col-auto">
                        			<!-- Avatar -->
                        				<img alt="Image placeholder" src="${notification[i].img}" class="avatar rounded-circle">
                      				</div>
                      				<div class="col ml--2">
                        				<div class="d-flex justify-content-between align-items-center">
                          					<div>
                            					<h4 class="mb-0 text-sm">${notification[i].name} ${notification[i].family_name}</h4>
                          					</div>
                        				</div>
                        				<p class="text-sm mb-0">a accepter votre demande a propos ${notification[i].matiere} jour:${notification[i].date} prix:${notification[i].prix} dh</p>
                      				</div>
                    			</div>
                  			</a>
                  		</td>
                      </div>
                    </td>
                  </tr>
  				    </c:forEach>
               </c:if>
                </tbody>
              </table>
            </div>
            <!-- Card footer -->
            <div class="card-footer py-4">
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