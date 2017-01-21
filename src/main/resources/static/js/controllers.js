app.controller('mainController', ['$scope', function($scope) {

}]);

app.controller('homeController', ['$scope', '$stateParams', 'appService', '$window', function($scope, $stateParams, appService, $window) {
    if ($stateParams.code) {
        appService.queryToken($stateParams.code).then(function(resp) {
            $window.sessionStorage.setItem('token_key', JSON.stringify(resp.data));
        });
    }
}]);