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
  <jsp:include page="links.jsp"/>
  <!-- Main content -->
  <div class="main-content" id="panel">
    <!-- Topnav -->
    <jsp:include page="header_student.jsp"/>
    <!-- Header -->
    <!-- Header -->
    
    <!-- Page content -->
    <div class="container mt-6">
    <div class="section-title">
      <h2>E-Learning</h2>
      <p>Valider vos informations</p>
    </div>   
  </div>
      <form action="valider_offre" method="post" class="container w-75 pb-0 pt-5 px-5" style="background-color: #FFFFFF">
       <div class="row ">
        <div class="col form-group ">
            <label for="localisation" class="form-control-label">localisation</label>
            <input class="form-control" style="color: rgb(49, 48, 48);" type="text" placeholder="Ville / Rue / bloc" name="localisation" maxlength="40" required>
        </div>
        </div>
        
        <div class="row form-group px-3">
            <label for="date" class="form-control-label">Date</label>
            <input class="form-control" style="color: rgb(49, 48, 48);" type="date" placeholder="YYYY-MM-DD" name="date" min ="${date_min}" max="${date_max}" required>
        </div>
        <div class="row form-group px-3">
          <label for="start_time" class="form-control-label">start time</label>
          <input class="form-control" style="color: rgb(49, 48, 48);" type="time" placeholder="10:00"  name="start" min="07:00" max="22:00" required>
      </div>
      <div class="row form-group px-3">
        <label for="end time" class="form-control-label">end time</label>
        <input class="form-control" style="color: rgb(49, 48, 48);" type="time" placeholder="11:00" name="finish"  min="08:00" max="23:00" required>
    </div>
      
        
        <div class="row form-group d-flex justify-content-center mb-0"   >
          <button type="submit" class="  btn  btn-lg mb-"  style="background-color: #5E72E4; color:#FFFFFF; width: 20%;">valider l'offre</button>
          </div>
        <br>
       <input type="hidden" name="id_students" value="${student.id_students}">
       <input type="hidden" name="id_offre" value="${contacter_prof_id_offre}">
      
    </form>




    <!-- Footer -->
    <footer class="footer container">
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