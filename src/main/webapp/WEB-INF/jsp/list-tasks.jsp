<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>
<title>Tasks for ${username}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your tasks are</caption>
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>End Date</th>
					<th>Is it Done?</th>
					<th>Email</th>
					<th>Severity</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.taskName}</td>
						<td>${task.desc}</td>
						<td><fmt:formatDate value="${task.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${task.endDate}" pattern="dd/MM/yyyy"/></td>
						<td>${task.done}</td>
						<td>${task.email}</td>
						<td>${task.severity}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-task?id=${task.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-task?id=${task.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-task">Add a Task</a>
		</div>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>