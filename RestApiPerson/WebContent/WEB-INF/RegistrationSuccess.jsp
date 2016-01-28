<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>Success !!</h1>


	<h2>Saved Data:</h2>

	<table>
		<tr>
			<td>Person Name:</td>
			<td>${personObject.personName}</td>
		</tr>
		<tr>
			<td>Person Email ID:</td>
			<td>${personObject.emailID}</td>
		</tr>
		<tr>
			<td>Person ContactNumber :</td>
			<td>${personObject.contactNumber}</td>
		</tr>
		<tr>
			<td>Person City :</td>
			<td>${personObject.personCity}</td>
		</tr>
		<tr>
			<td>Person State :</td>
			<td>${personObject.personState}</td>
		</tr>



	</table>
	<form action="/RestApiPerson/RegisterPerson" method="get">
		<input type="submit" value="Back To Registration Page">
	</form>

</body>
</html>