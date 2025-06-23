<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title></title>
  
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="${pageContext.request.contextPath}/">DemoApp</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
	          aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">

	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/trainer">Trainer</a>
	      </li>

	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/subject">Subject</a>
	      </li>

	    </ul>
	  </div>
	</nav>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

  
</body>
</html>
