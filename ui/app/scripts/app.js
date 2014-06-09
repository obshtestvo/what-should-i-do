'use strict';

/**
 * @ngdoc overview
 * @name uiApp
 * @description
 * # uiApp
 *
 * Main module of the application.
 */
angular.module('configuration', [])
       .constant('API_END_POINT','http://localhost:8080/rest/api');

var app = angular.module('uiApp', 
	['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
		when('/register', {
			controller: 'RegisterCtrl',
			templateUrl: '/views/register.html'
		}).otherwise({redirectTo:'/views/404.html'});
}]);