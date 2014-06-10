'use strict';

/**
 * @ngdoc service
 * @name uiApp.User
 * @description
 * # User
 * Service in the uiApp.
 */
 angular.module('app-services', ['ngResource', 'app-conf'])
   .factory('User', ['$resource', 'ENDPOINT', function($resource, ENDPOINT) {
     return $resource(ENDPOINT + '/users/:userId', {userId: '@id'},
		{'update': {method: 'PUT' }});
 }]);
