app.service('appService', ['$http', function ($http) {
    this.queryToken = function(code) {
        return $http.get('/getToken/' + code);
    };

    this.loadWeibo = function(token, count, page) {
        return $http.get('/weibo', {params: {token: token, count: count, page: page}});
    };
}]);