<html>

<body>
	<h1>Add Order</h1>

	<form action="webapi/myresource/CreateOrder" method="post">
		<p>
			CustID : <input type="number" name="CustID" />
		</p>
		<p>
			CarREG : <input type="number" name="CarNO" />
		</p>
		<p>
			HireDate : <input type="text" name="hireDate" />
		</p>
		<p>
			ReturnDate : <input type="text" name="returnDate" />
		</p>
		<input type="submit" value="Add Order" />
	</form>

</body>
</html>