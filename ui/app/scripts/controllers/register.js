'use strict';

/**
 * @ngdoc function
 * @name uiApp.controller:RegisterCtrl
 * @description
 * # RegisterCtrl
 * Controller of the uiApp
 */
angular.module('uiApp', ['services'])
  .controller('RegisterCtrl', ['$scope', '$location', 'User',
  	function ($scope, $location, User) {
    $scope.user = new User({});

    $scope.save = function() {
    	$scope.user.$save(function(user) {
    		$location.path('/login');
    	});
    }
  }]);
