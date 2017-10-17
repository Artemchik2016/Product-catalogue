<!DOCTYPE html >
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" media="screen"/>
<link href="css/styles.css" rel="stylesheet" media="screen"/>
<script src="js/lib/angular.js"></script>
<script src="js/app/app.js"></script>
<script src="js/app/controller/productController.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/app/controller/scripts.js"></script>
<title>Products</title>
</head>


<body ng-app="app">

	<section>
	<div class="jumbotron">
		<div class="container">
		<a href="http://localhost:8080/login" class="btn btn-default btn-mini pull-right">Login as Admin</a>
		<a href="http://localhost:8080/add" class="btn btn-default pull-right">Add product</a>

			<h1>Products</h1>
			<p>All the available products in our store</p>
		</div>
	</div>
	</section>

	<section class="container"  >
	<div class="row" ng-controller="productController">
	<div ng-repeat="product in allProducts">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
						<h3>{{product.name}}</h3>
						<a href="http://localhost:8080//product?id={{product.productId}}">
						<img src="{{product.imageSource}}" alt="image"/>
						</a>
						<p>{{product.description}}</p>
						<p>{{product.price}} USD</p>
					    <p><a href="http://localhost:8080//product?id={{product.productId}}" class="btn btn-primary" >
						Details</a></p>
				</div>
			</div>
		</div>
	</div>
	</div>
	</section>
</body>
</html>