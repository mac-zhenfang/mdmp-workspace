// declare a module
var app = angular.module('sample', []);

// declare a global value
app.value("$mock", true);

// define the call host
app.value("$sonarhost", "http://nemo.sonarsource.org");

// define the call url
app.factory("$sonarrequestUrl", function($sonarhost) {
	return $sonarhost + "/api/resources";
});

// sonar http JSON service
app.factory('sonar', ['$http', '$sonarrequestUrl', '$window',
		function($http, $sonarrequestUrl, $window) {
			var callUri = $sonarrequestUrl + "?callback=JSON_CALLBACK";
			console.log(callUri);
			return function(scope) {
				$http({method: 'jsonp', url: callUri})
				 .success(function(data, status) {
					 scope.data = data;;
					 console.log(retData);
				 }).error(function(data, status) {
					 scope.data = data;;
				 });
			};
		} ]);
// notify service
app.factory('notify', function($window) {

	var msgs = [];
	return function(msg) {
		msgs.push(msg);
		if (msgs.length == 3) {
			$window.alert(msgs.join("\n"));
			msgs = [];
		}
	};
});

var sample = function($scope, notify, sonar) {
	$scope.username = "mac";
	// sonar.getData();
	$scope.callNotify = function(msg) {
		notify(msg);
	};
	$scope.callSonar = function() {
		
		sonar($scope);
	};
};
// sample.$inject = ['$sonar', '$notify'];
app.controller("sample", sample);
