'use strict';
angular.module('eventCaptureApp.service', []).factory('eventService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.getLondonEvents = function() {
    	console.log("coming from servicejs");
    	return $http.get(CONSTANTS.getLodonEvents);
	},
    service.getLondonMusicEvents = function() {
        return $http.get(CONSTANTS.getLodonMusicEvents);
    },
    service.getLodonComedyEvents = function() {
        return $http.get(CONSTANTS.getLodonComedyEvents);
    },
    service.getLodonKidsEvents = function() {
        return $http.get(CONSTANTS.getLodonKidsEvents);
    },
    service.getLodonSportsEvents = function() {
        return $http.get(CONSTANTS.getLodonSportsEvents);
    },
    service.getLodonNightLifeEvents = function() {
        return $http.get(CONSTANTS.getLodonNightLifeEvents);
    },
    return service;
}]);