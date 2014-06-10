'use strict';

/**
 * @ngdoc directive
 * @name uiApp.directive:user
 * @description
 * # user
 */
angular.module('app-directives', [])
  .directive('user', function () {
    return {
      templateUrl: '/views/directives/user.html',
      restrict: 'A'
    };
  });
