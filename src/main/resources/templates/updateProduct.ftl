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
<title>Product - {{product.name}}</title>
</head>

<body ng-app="app">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>

	<section class="container" ng-controller="productController">

        <section class="container">
            <form  name="product" method="POST"  enctype="multipart/form-data" class="form-horizontal" action="http://localhost:8080/updateProductProcess">

                <fieldset>
                    <legend>Add new product</legend>



                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="id">ProductID</label>
                        <div class="col-lg-10">
                            <input id="id" type="text" name="id" class="form:input-large" value="${product.id}" />
                        </div>
                    </div>



                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="name">Name</label>
                        <div class="col-lg-10">
                            <input id="name" type="text" name="name" class="form:input-large" value="${product.name}"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="unitPrice">Price</label>
                        <div class="col-lg-10">
                            <input type="text" id="price" name="price" class="form:input-large" value="${product.price}"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="control-label col-lg-2" for="description">Description</label>
                        <div class="col-lg-10">
                            <input type="text" id="description" name="description" rows="2" value="${product.description}"/>
                        </div>
                    </div>


                    <div class="form-group fileUploadHandle">
                        <label class="control-label col-lg-2 col-lg-2" for="productImage">Product image</label>
                        <div class="col-lg-10">
                            <input type="text" name ="imageSource" class="form:input-large" id="imageSource" value="${product.imageSource}" />
                        </div>
                    </div>



                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value="Update" />
                        </div>
                    </div>

                </fieldset>
        </section>
		</div>
	</section>
</body>
</html>