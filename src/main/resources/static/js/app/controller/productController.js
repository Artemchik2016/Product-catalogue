app.controller("productController", function($scope, $http) {

    var url = 'http://localhost:8080/findAllProducts';
    $http.get(url).then(function(response){
        $scope.allProducts = response.data;
    });


});