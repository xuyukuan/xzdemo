app.directive('header', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/header.html',
        replace: true
    };
});
app.directive('loadingSpinner', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/loading-spinner.html',
        replace: true
    };
});
app.directive('login', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/login.html',
        scope: {},
        link: function(scope, element, attrs) {
            scope.requestLogin = function() {
                location.href='requestLogin';
            }
        }
    };
});
app.directive('weiboItem', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/weibo-item.html',
        scope: {
            item: '='
        },
        link: function(scope, element, attrs) {

        }
    };
});
