<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
              <a class="nav-link active" href="dash_board_prof.jsp">
                <i class="ni ni-tv-2 text-primary"></i>
                <span class="nav-link-text">Home</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="my_offres.jsp">
                <i class="ni ni-books text-orange"></i>
                <span class="nav-link-text">Mes Offres</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="accepter_offre.jsp">
                <i class="ni ni-paper-diploma text-info"></i>
                <span class="nav-link-text">Acceptation des offres</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="offre_accepted.jsp">
               	<i class="fas fa-vote-yea text-success"></i>
                <span class="nav-link-text">Offres Acceptée</span>
              </a>
            </li>
             <li class="nav-item">
              <a class="nav-link" href="profile_prof.jsp">
                <i class="ni ni-single-02 text-danger"></i>
                <span class="nav-link-text">Profile</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </nav>
</body>
</html>