// declare a module
var app = angular.module('sample', []);

app.value("mock", true);

app.filter('greet', function() {
	return function(name) {
		return 'Hello, ' + name + '!';
	};
});
