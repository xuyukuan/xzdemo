var app = angular.module('app', ['ui.router']);
app.config(function($stateProvider, $locationProvider){
    $stateProvider.state({
        name: 'home',
        url: '/?code',
        templateUrl: '/views/home.html',
        controller: 'homeController'
    });
    $locationProvider.html5Mode(true);
});