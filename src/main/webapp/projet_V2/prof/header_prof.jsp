<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <!-- Search form -->
          <form class="navbar-search navbar-search-light form-inline mr-sm-3" id="navbar-search-main">
            <div class="form-group mb-0">
              <div class="input-group input-group-alternative input-group-merge">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-search"></i></span>
                </div>
                <input class="form-control" placeholder="Search" type="text" name="">
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
</body>
</html>