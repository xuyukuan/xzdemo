app.directive('header', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/header.html',
        replace: true
    };
});
app.directive('login', function() {
    return {
        restrict: 'E',
        templateUrl: 'views/login.html',
        replace: true,
        scope: {},
        link: function(scope, element, attrs) {
            scope.requestLogin = function() {
                location.href='requestLogin';
            }
        }
    };
});
