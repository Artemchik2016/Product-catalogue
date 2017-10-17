<!DOCTYPE html>

<html lang="en" ng-app="app">
    <head>
        <title>${title}</title>

        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/styles.css" rel="stylesheet"/>
        <script src="js/lib/angular.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/controller/productController.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="js/app/controller/scripts.js"></script>


    </head>

    <body ng-controller="productController">



    Hello guys
    <a href="http://localhost:8080/products">Link</a>

   <ul ng-repeat="product in allProducts">
        <li><h3>{{product.name}}</h3>{{product.description}}</li>
        <img src="{{product.imageSource}}"/>
    </ul>


    </body>
</html>


