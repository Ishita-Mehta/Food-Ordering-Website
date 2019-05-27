<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <link href="CSS/index_bg.css" type="text/css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>Register</title>
</head>
<body>
		<body class="bg">
<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-sm-4 col-xs-12"></div>
		<div class="col-md-4 col-sm-4 col-xs-12">
	<form action="registerInput" method="post" class="form-container">
			<h1 class="header"> Register for awesome food!</h1>
			<div class="form-group">
				<label for="InputName">Name</label>
					<input name="name" class="form-control" id="InputName" placeholder="Name" required> 
			</div>
			<div class="form-group">
				<label for="InputAddress">Address</label>
					<input name="address" class="form-control" id="InputAddress" placeholder="Address" required> 
			</div>
  			<div class="form-group">
    			<label for="exampleInputEmail1">Email address</label>
    				<input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email" required>
  			</div>
  			<div class="form-group">
    			<label for="InputPassword">Password</label>
    				<input type="password" pattern=".{6,}" required title="6 characters minimum" name="password" class="form-control" id="InputPassword" type="password" placeholder="Password" required>
    			<label for="ConfirmInputPassword1">Confirm Password</label>
    				<input name="confirmPassword" class="form-control" id="ConfirmInputPassword" type="password" placeholder="Password" required> 	
  			</div>
  			 
  			<button type="submit" class="btn btn-success btn-block" onclick="index.html">Register</button>
			
	</form>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12"></div>
	</div>
</div>
</body>
</html>
