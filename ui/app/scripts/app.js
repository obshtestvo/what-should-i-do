'use strict';

/**
 * @ngdoc overview
 * @name uiApp
 * @description
 * # uiApp
 *
 * Main module of the application.
 */

var app = angular.module('uiApp', ['ngRoute', 'app-controllers', 'app-directives']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/about', {
			templateUrl: '/views/about.html'
		}).when('/register', {
			controller: 'RegisterCtrl',
			templateUrl: '/views/register.html'
		});
}]);