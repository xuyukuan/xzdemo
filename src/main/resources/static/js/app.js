var app = angular.module('app', ['ui.router', 'infinite-scroll']);
app.config(function($stateProvider, $locationProvider){
    $stateProvider.state({
        name: 'home',
        url: '/?code',
        templateUrl: '/views/home.html',
        controller: 'homeController as vm'
    });
    $locationProvider.html5Mode(true);
});