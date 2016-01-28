<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>


	<form:errors path="personObject.*" />
	<h1>Person Registration</h1>

	<form action="/RestApiPerson/RegistrationSuccess" method="post">

		<p>
			Person's Name : <input type="text" name="personName" />
		</p>

		<p>
			Person's contact Number : <input type="text" name="contactNumber" />
		</p>
		<p>
			Person's email ID : <input type="text" name="emailID" />
		</p>
		<p>
			Person's City : <input type="text" name="personCity" />
		</p>
		<p>
			Person's State : <input type="text" name="personState" />
		</p>

		<input type="submit" value="Submit this form by clicking here" />
	</form>

	<form action="/RestApiPerson/ViewPersons" method="get">
		<input type="submit" value="View All Person">
	</form>

</body>
</html>




