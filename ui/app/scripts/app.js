'use strict';

/**
 * @ngdoc overview
 * @name uiApp
 * @description
 * # uiApp
 *
 * Main module of the application.
 */

angular.module('conf', [])
	.constant('ENDPOINT','http://localhost:8080/rest/api');

var app = angular.module('uiApp', ['ngRoute', 'directives']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/about', {
			templateUrl: '/views/about.html'
		}).when('/register', {
			controller: 'RegisterCtrl',
			templateUrl: '/views/register.html'
		});
}]);