app.controller("productController", function($scope, $http) {


    var url = 'http://localhost:8080/findAllProducts';
    $http.get(url).then(function(response){
        $scope.allProducts = response.data;
    });


    $scope.editProduct = function (product) {
        $scope.idSelectedProduct = product.id;
        $scope.product = null;
        $scope.errorMessage = null;
        $scope.infoMessage = null;
        $scope.loading = true;
        $http.get('http://localhost:8080/findProduct?productId=' + product.id).then(function (res) {
            $scope.loading = false;
            if (res.data.errorMessage) {
                $scope.product = null;
                $scope.errorMessage = res.data.errorMessage;
            } else {
                $scope.product = res.data.product;
            }

        } , function error(res) {
            $scope.errorMessage = "Request error";
            $scope.product = null;
        });
    };



});