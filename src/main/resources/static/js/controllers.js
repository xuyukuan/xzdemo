app.controller('mainController', ['$scope', function ($scope) {

}]);

app.controller('homeController', ['$scope', '$state', '$stateParams', 'appService', '$window', function ($scope, $state, $stateParams, appService, $window) {
    var token = $window.sessionStorage.getItem('token_key');
    if ($stateParams.code) {
        appService.queryToken($stateParams.code).then(function (resp) {
            var token = resp.data.access_token;
            $window.sessionStorage.setItem('token_key', token);
            $state.go('home', {code: null});
        });
    }

    if (token) {
        loadWeibo(token, 10, 1);
    }

    function loadWeibo(token, count, page) {
        appService.loadWeibo(token, count, page).then(function (resp) {
            console.log(resp.data);
        });
    }
}]);