/**
 * 1.ReportService 2.CategoryService 3.AppService
 * 
 */

var Workspace = angular.module('Workspace', []);
// global value

Workspace.value("$WorkspaceHost", "http://nemo.sonarsource.org");

Workspace.factory("$CategoryListURL", function($WorkspaceHost) {
	return $WorkspaceHost + "/api/resources";
});// Services

Workspace.factory("$AppListURL", function($WorkspaceHost) {
	return $WorkspaceHost + "/api/resources";
});// Services

Workspace.service('AppService', [ '$http', '$AppListURL',
		function($http, $AppListURL) {
			var callUri = $AppListURL + "?callback=JSON_CALLBACK";
			// FIXME
			this.listApps = function(scope) {
				scope.apps = [ {
					name : "test1 app1 - Game",
					id : "1",
					type : "game",
					versions : [ "v0.1", "v0.2", "v0.3" ]
				}, {
					name : "test2 app2 - Social",
					id : "2",
					type : "game",
					versions : [ "v0.11", "v0.22", "v0.33" ]
				}, {
					name : "test3  app3 - Social",
					id : "3",
					type : "game",
					versions : [ "v0.111", "v0.222", "v0.333" ]
				}, {
					name : "test4 app3 - Social",
					id : "4",
					type : "game",
					versions : [ "v0.1111", "v0.2222", "v0.3333" ]
				}, {
					name : "test5 app3 - Social",
					id : "5",
					type : "game app3 - Social",
					versions : [ "v0.11111", "v0.22222", "v0.33333" ]
				} ];
				// Default
				scope.currentApp = scope.apps[0];
			};
		} ]);
Workspace.service('CategoryService', [ '$http', '$CategoryListURL',
		function($http, $CategoryListURL) {
			// FIXME
			var callUri = $CategoryListURL + "?callback=JSON_CALLBACK";
			this.listCategories = function(scope) {
				// test
				console.log(callUri);
				$http({
					method : 'jsonp',
					url : callUri
				}).success(function(data, status) {
					// FIXME
					var index = 0;
					var retData = [];
					for (cate in data) {
						var item = {};
						if (index++ < 20) {
							if ((index % 5) == 0) {
								item["isGroup"] = true;
							}
							item["name"] = data[cate].name;

							retData[retData.length] = item;
						}
					}
					;
					// console.log(retData);
					scope.categories = retData;

				}).error(function(data, status) {
					console.log(data + " , status : " + status);
				});
			};
		} ]);
// Controller
var WorkspaceController = function($scope, CategoryService, AppService) {
	$scope.init = function() {
		// Get userId from cookies
		CategoryService.listCategories($scope);
	};
	$scope.initApps = function() {
		// Get userId from cookies
		AppService.listApps($scope);

	};
	$scope.radioValue = [" Last 1 day", "Last 1 Week", "Last 1 Month"];
};

Workspace.controller("WorkspaceContrl", WorkspaceController);
