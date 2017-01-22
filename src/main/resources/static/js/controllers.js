app.controller('homeController', ['$scope', '$state', '$stateParams', 'appService', '$window', function ($scope, $state, $stateParams, appService, $window) {
    var vm = this;

    //init data start
    vm.loadWeibo = loadWeibo;
    vm.page = 1;
    vm.count = 10; //default count
    vm.items = [];
    vm.token = $window.sessionStorage.getItem('token_key');
    //init data end

    if ($stateParams.code) {
        appService.queryToken($stateParams.code).then(function (resp) {
            var token = resp.data.access_token;
            $window.sessionStorage.setItem('token_key', token);
            $state.go('home', {code: null});
        });
    }

    function loadWeibo() {
        if (vm.token) {
            vm.hideLogin = true;
            vm.loadingData = true;
            appService.loadWeibo(vm.token, vm.count, vm.page++).then(function (resp) {
                vm.loadingData = false;
                if (resp.data && resp.data.length > 0) {
                    vm.items = vm.items.concat(resp.data);
                }
            });
        }
    };
}]);