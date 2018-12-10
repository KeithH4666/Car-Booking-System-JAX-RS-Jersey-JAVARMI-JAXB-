<html>
<body>
	<h1>Update Order</h1>

	<form action="webapi/myresource/UpdateOrder" method="post">
		<p>
			Customer ID : <input type="number" name="custID" />
		</p>
		<p>
			Car Reg : <input type="number" name="carNO" />
		</p>
		<p>
			HireDate : <input type="text" name="hireDate" />
		</p>
		<p>
			ReturnDate : <input type="text" name="returnDate" />
		</p>
		<input type="submit" value="Update" />
	</form>

</body>
</html>