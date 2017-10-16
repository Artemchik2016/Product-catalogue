app.controller("productController", function($scope, $filter, $http) {


    $scope.initProductList = function() {
            var url = 'http://localhost:8080/findAllProducts';
            $http.get(url).then(function(response){
                $scope.allProducts = response.data;
            });

    };


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

    $scope.createProduct = function () {
        $scope.errorMessage = null;
        $scope.infoMessage = null;
        $scope.state = null;
        $scope.product = {
            name: "",
            description: "",
            price: 0
        };
        return true;
    };



    $scope.saveProduct = function () {
        $scope.errorMessage = null;
        $scope.infoMessage = null;
        $scope.state = null;
        $scope.loading = true;
        $http.post('http://localhost:8080/save', $scope.product).then(
            function (res, respStatus, headers, config) {
                $scope.loading = false;
                if (data.errorMessage) {
                    $scope.errorMessage = res.data.errorMessage;
                } else {
                    $scope.product = null;
                    $scope.initProductList();
                    $scope.infoMessage = 'Successfully saved the product';
                }
            }, function error(data, respStatus, headers, config) {
                $scope.loading = false;
                $scope.errorMessage = "Request error";
            });
    };



    $scope.initProductList();
});