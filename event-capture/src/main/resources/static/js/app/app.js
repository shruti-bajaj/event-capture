'use strict'
var eventCaptureApp = angular.module('eventCaptureApp', ['ui.bootstrap', 'eventcapture.controllers']);
eventCaptureApp.constant("CONSTANTS", {
	getLodonEvents: "/events/London",
    getLodonMusicEvents: "/events/London/music",
    getLodonComedyEvents: "/events/London/comedy",
    getLodonKidsEvents: "/events/London/family_fun_kids",
    getLodonSportsEvents: "/events/London/sports",
    getLodonNightLifeEvents: "/events/London/singles_social"
});