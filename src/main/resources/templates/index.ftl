<!DOCTYPE html>

<html lang="en" ng-app="app">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        <script src="js/lib/angular.js" ></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/service/ng-table.min.js"></script>
        <script src="js/app/controller/productController.js"></script>

    </head>

    <body ng-controller="productController">


    <ul ng-repeat="product in allProducts">
        <li><h3>{{product.name}}</h3>{{product.description}}</li>
    </ul>


    </body>
</html>


