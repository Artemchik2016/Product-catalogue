<!DOCTYPE html >
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/styles.css" rel="stylesheet"/>
    <script src="js/lib/angular.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/controller/productController.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="js/app/controller/scripts.js"></script>
<meta http-equiv="Content-Type" content="text/html;">
<title>Login</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>Add products</p>
			</div>
		</div>
	</section>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<form action="" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="User Name"
										name='j_username' type="text">
								</div>

								<div class="form-group">
									<input class="form-control" placeholder="Password" name='j_password' type="password" value="">
								</div>

								<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>