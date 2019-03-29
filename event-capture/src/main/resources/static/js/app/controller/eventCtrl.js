'use strict';
var module = angular.module('eventCaptureApp.controller', []);
module.controller("eventCtrl"["$scope", "eventService", function($scope,
		eventService) {
	alert('controller initializing');
	eventService.getLondonEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.events = response;
	}),
	eventService.getLondonMusicEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.musicEvents = response;
	}),
	eventService.getLodonComedyEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.comedyEvents = response;
	}),
	eventService.getLodonKidsEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.kidsEvents = response;
	}),
	eventService.getLodonSportsEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.sportsEvents = response;
	}),
	eventService.getLodonNightLifeEvents().then(function successCallback(response) {
		$scope.response = response;
		$scope.nightLifeEvents = response;
	}),
	function errorCallback(response) {
		console.log("Unable to perform get request");
	};
}]);