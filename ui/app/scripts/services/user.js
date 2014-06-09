'use strict';

/**
 * @ngdoc service
 * @name uiApp.User
 * @description
 * # User
 * Service in the uiApp.
 */
angular.module('services', ['configuration', 'ngResource'])
  .factory('User', ['$resource', function($resource) {
    return $resource(API_END_POINT + '/users/:id', {id: '@id'});
}]);
