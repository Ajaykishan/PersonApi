<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>

	<h2>${process}</h2>


	<table>
		<tr>
			<td>Person ID:</td>
			<td>${resultObject.personId}</td>
		</tr>
		<tr>
			<td>Person Name:</td>
			<td>${resultObject.personName}</td>
		</tr>

		<tr>
			<td>Person Email ID:</td>
			<td>${resultObject.emailID}</td>
		</tr>

		<tr>
			<td>Person ContactNumber :</td>
			<td>${resultObject.contactNumber}</td>
		</tr>

		<tr>
			<td>Person City :</td>
			<td>${resultObject.personCity}</td>
		</tr>
		<tr>
			<td>Person State :</td>
			<td>${resultObject.personState}</td>
		</tr>


	</table>
	<form action="/RestApiPerson/RegisterPerson" method="get">
		<input type="submit" value="Back To Registration Page">
	</form>
</body>
</html>