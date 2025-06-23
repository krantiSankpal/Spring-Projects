<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Subject Management</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap JS Bundle -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <!-- jQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

  <!-- Toggle form -->
  <script>
    function toggleSubjectForm() {
      const formDiv = document.getElementById("subjectFormDiv");
      formDiv.style.display = formDiv.style.display === 'none' ? 'block' : 'none';
    }
    $(function () {
      $("#navbar").load("navbar");
    });
  </script>
</head>
<body>

<div class="container py-4">

  <!-- Navbar -->
  <div id="navbar"></div>

  <h2 class="mb-0">Subject Management</h2>

  <!-- Heading and Actions -->
  <div class="d-flex justify-content-between align-items-center mb-4">
    <!-- Add Subject Button -->
    <div>
      <button class="btn btn-primary mt-2" onclick="toggleSubjectForm()">Add Subject</button>
    </div>

    <!-- Get Subject Details -->
    <form class="d-flex gap-2 align-items-center" action="${pageContext.request.contextPath}/subject/details" method="post">
      <input type="text" name="id" class="form-control form-control-sm" placeholder="Subject ID" style="width: 160px;" />
      <button type="submit" class="btn btn-sm btn-outline-primary">Get Details</button>
    </form>
  </div>

  <!-- Subject Form -->
  <div id="subjectFormDiv" class="card p-4 mb-4" style="display: none;">
    <form:form modelAttribute="subject" method="post" action="${pageContext.request.contextPath}/subject/save">
      <div class="mb-3">
        <label class="form-label">Subject Name</label>
        <form:input path="name" cssClass="form-control"/>
      </div>
      <div >
        <button type="submit" class="btn btn-success">Save Subject</button>
        <button type="button" class="btn btn-secondary" onclick="toggleSubjectForm()">Close</button>
      </div>
    </form:form>
  </div>

  <!-- Subject Table -->
  <h4>Subject List</h4>
  <table class="table table-striped table-bordered">
    <thead class="table-light">
      <tr>
        <th>ID</th>
        <th>Name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="s" items="${subjects}">
        <tr>
          <td>${s.id}</td>
          <td>${s.name}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <!-- Subject with Trainers -->
  <c:if test="${not empty subjectDetail}">
    <div class="alert alert-info">
      <h5>Subject: ${subjectDetail.name}</h5>
      <ul>
        <c:forEach var="t" items="${subjectDetail.trainers}">
          <li>${t.name} (${t.email})</li>
        </c:forEach>
      </ul>
    </div>
  </c:if>

</div>

</body>
</html>
