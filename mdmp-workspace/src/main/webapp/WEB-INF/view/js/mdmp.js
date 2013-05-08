// declare a module
var Mdmp = angular.module('Mdmp', []);
// global value
Mdmp.value("$loginUrl", "");

// services

// declare UserService

Mdmp.service('UserService', [ '$http', function($http) {
	this.login = function(user, func) {
		// TODO call from http, if succes, return true, set-into Cookies
		console.log("login success", user);
		func();
		return true;
	};
}]);

// sample Service
Mdmp.service('nametrickService', function() {
  this.reverse = function(name) {
    return name.split("").reverse().join("");
  };
});

// declare main controller MainCtrl
var MainController = function() {

};

var LoginController = function($scope, UserService,  $location, $window) {
	
	$scope.signin = function(user) {
		
		//UserService.login();
		//console.log(nametrickService.reverse(user.email));
		UserService.login(user, jumpToWorkspace);
	};
	var jumpToWorkspace = function(){
		$window.location =  "workspace.html";
	}
	
};

Mdmp.controller("MainCtrl", MainController);

Mdmp.controller("LoginCtrl", LoginController);
