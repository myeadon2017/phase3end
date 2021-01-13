<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>Task</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="container">


		<form:form method="post" commandName="task">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="taskName">Task Name</form:label>
				<form:input path="taskName" type="text" class="form-control"
					required="required" />
				<form:errors path="taskName" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control"
					required="required" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="severity">Severity</form:label>
				<form:select path="severity">
				<form:option value="High"></form:option>
				<form:option value="Medium"></form:option>
				<form:option value="Low"></form:option>
				</form:select>
				<form:errors path="severity" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="endDate">End Date</form:label>
				<form:input path="endDate" type="text" class="form-control"
					required="required" />
				<form:errors path="endDate" cssClass="text-warning" />
			</fieldset>

			<button type="submit" class="btn btn-danger">Add</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
	<script>
		$('#endDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>

</body>
</html>