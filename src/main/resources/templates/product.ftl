<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet"/>
<script src="js/lib/angular.js"></script>
<script src="js/app/service/ng-table.min.js"></script>
<script src="js/app/controller/controller.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="js/app/controller/script"></script>

<meta http-equiv="Content-Type" content="text/html;">
<title>Product - ${product.name}</title>
</head>

<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>

	<section class="container" ng-app="cartApp">

		<div class="row">
			<div class="col-md-6">
				<img src=/images/${product.imageSource}" class="single-img" alt="image" />
			</div>

			<div class="col-md-6">

				<h3>${product.name}</h3>

				<p>${product.description}</p>

				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${product.category}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.price}USD</h4>

			</div>
		</div>
	</section>
</body>
</html>