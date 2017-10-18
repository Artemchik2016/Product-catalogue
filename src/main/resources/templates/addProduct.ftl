<!DOCTYPE html>
<html>
<head>
<#import "/spring.ftl" as spring />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/styles.css" rel="stylesheet"/>
    <script src="js/lib/angular.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/controller/productController.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script src="js/app/controller/scripts.js"></script>


<title>Products</title>
</head>

<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<a href="http://localhost:8080/logout" class="btn btn-danger btn-mini pull-right" >logout</a>
				<a href="products.ftl" class="btn btn-success pull-right">Products</a>

				<h1>Products</h1>
				<p>Add products</p>
			</div>
		</div>
	</section>


	<section class="container">
		<form  name="product" method="POST"  enctype="multipart/form-data" class="form-horizontal" action="http://localhost:8080/add">

			<fieldset>
				<legend>Add new product</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<input id="name" type="text" name="name" class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Price</label>
					<div class="col-lg-10">
						<input type="text" id="price" name="price" class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<input type="text" id="description" name="description" rows="2"/>
					</div>
				</div>


				<div class="form-group">
					<a href="#" class="fileUploadHandler">toggle file upload</a>
				</div>


				<div class="form-group fileUploadHandle">
					<label class="control-label col-lg-2 col-lg-2" for="productImage">Product image</label>
					<div class="col-lg-10">
						<input type="file" name ="productImage" class="form:input-large" id="productImage"  />
					</div>
				</div>


				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add Product" />
					</div>
				</div>

			</fieldset>
	</section>

</body>
</html>