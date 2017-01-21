app.service('appService', ['$http', function ($http) {
    this.queryToken = function(code) {
        return $http.get('/getToken/' + code);
    }
}]);