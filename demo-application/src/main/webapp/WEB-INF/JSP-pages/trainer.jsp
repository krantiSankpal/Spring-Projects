<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Trainer Management</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap JS Bundle -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- jQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

  <script>
    function toggleForm() {
      var formDiv = document.getElementById("trainerFormDiv");
      formDiv.style.display = formDiv.style.display === 'none' ? 'block' : 'none';
    }
    $(function () {
      $("#navbar").load("navbar");
    });
  </script>
</head>
<body>

 <div  class="container py-4">
 <!-- Navbar -->
  <div id="navbar"></div>
  <h2 class="mb-0">Trainer Management</h2>
  
  <div class="d-flex justify-content-between align-items-center mb-4">
    <!-- Left: Title & Add Button -->
    <div>
      <button class="btn btn-primary mt-2" onclick="toggleForm()">Add Trainer</button>
    </div>

    <!-- Right: Search & Filter Forms -->
    <div class="d-flex gap-2">
      <!-- Search Form -->
      <form class="d-flex" action="${pageContext.request.contextPath}/trainer/findByEmpId" method="post">
        <input type="text" name="empId" class="form-control form-control-sm me-2" placeholder="Emp ID" style="width: 160px;" />
        <button type="submit" class="btn btn-sm btn-outline-primary">Search</button>
      </form>

      <!-- Filter Form -->
      <form class="d-flex" action="${pageContext.request.contextPath}/trainer/findBySubject" method="post">
        <input type="text" name="subject" class="form-control form-control-sm me-2" placeholder="Subject" style="width: 160px;" />
        <button type="submit" class="btn btn-sm btn-outline-secondary">Filter</button>
      </form>
    </div>
  </div>

  <!-- Trainer Form -->
  <div id="trainerFormDiv" class="card p-4 mb-4" style="display:none;">
    <form:form modelAttribute="trainer" method="post" action="${pageContext.request.contextPath}/trainer/save">
      <div class="mb-3">
        <label class="form-label">Emp ID</label>
        <form:input path="empId" cssClass="form-control"/>
      </div>
      <div class="mb-3">
        <label class="form-label">Name</label>
        <form:input path="name" cssClass="form-control"/>
      </div>
      <div class="mb-3">
        <label class="form-label">Email</label>
        <form:input path="email" cssClass="form-control"/>
      </div>
      <div class="mb-3">
        <label class="form-label">Subjects</label><br/>
        <c:forEach var="subj" items="${subjects}">
          <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" name="subjects" value="${subj.id}" id="subj${subj.id}">
            <label class="form-check-label" for="subj${subj.id}">${subj.name}</label>
          </div>
        </c:forEach>
      </div>
      <button type="submit" class="btn btn-success">Save Trainer</button>
      <button type="button" class="btn btn-secondary" onclick="toggleForm()">Close</button>
    </form:form>
  </div>

  <!-- Trainer Table -->
  <h4>Trainer List</h4>
  <table class="table table-striped table-bordered">
    <thead class="table-light">
      <tr>
        <th>Emp ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Subjects</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="t" items="${trainers}">
        <tr>
          <td>${t.empId}</td>
          <td>${t.name}</td>
          <td>${t.email}</td>
          <td>
            <c:forEach var="s" items="${t.subjects}">
              <span class="badge bg-info text-dark">${s.name}</span>
            </c:forEach>
          </td>
          <td>
            <a href="${pageContext.request.contextPath}/trainer/delete/${t.id}" class="btn btn-sm btn-danger">Delete</a>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <!-- Optional Section: Search Results -->
  <c:if test="${not empty trainerById}">
    <div class="alert alert-info">
      <h5>Trainer By Emp ID</h5>
      <p>${trainerById.name} - ${trainerById.email}</p>
    </div>
  </c:if>

  <c:if test="${not empty subjectTrainers}">
    <div class="alert alert-warning">
      <h5>Trainers By Subject</h5>
      <ul>
        <c:forEach var="t" items="${subjectTrainers}">
          <li>${t.name} (${t.email})</li>
        </c:forEach>
      </ul>
    </div>
  </c:if>
</div>

</body>
</html>
