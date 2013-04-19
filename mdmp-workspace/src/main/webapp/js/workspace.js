/**
 * 1.ReportService 2.GroupService 3.AppService
 * 
 */

var Workspace = angular.module('Workspace', [ 'ui.bootstrap' ]);
// global value

Workspace.value("$WorkspaceHost", "http://nemo.sonarsource.org");
Workspace.value("$MaxPaneSize", 10);
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
Workspace.service('GroupService', [ '$http', '$CategoryListURL',
		function($http, $CategoryListURL) {
			// FIXME
			var callUri = $CategoryListURL + "?callback=JSON_CALLBACK";
			this.listGroups = function(scope) {
				// test
				console.log(callUri);
				$http({
					method : 'jsonp',
					url : callUri
				}).success(function(data, status) {
					scope.groups = [ {
						name : "group 1",
						isFocus : true,
						reports : [ {
							name : "report 1 1 sss",
							isFocus : true
						}, {
							name : "report 1 2",
							isFocus : false
						}, {
							name : "report 1 3",
							isFocus : false
						}, {
							name : "report 1 4",
							isFocus : false
						}, {
							name : "report 1 5",
							isFocus : false
						}, {
							name : "report 1 6",
							isFocus : false
						}, {
							name : "report 1 7",
							isFocus : false
						} ]
					}, {
						name : "group 2",
						isFocus : false,
						reports : [ {
							name : "report 2 1",
							isFocus : true
						}, {
							name : "report 2 2",
							isFocus : false
						}, {
							name : "report 2 3",
							isFocus : false
						}, {
							name : "report 2 4",
							isFocus : false
						}, {
							name : "report 2 5",
							isFocus : false
						}, {
							name : "report 2 6",
							isFocus : false
						}, {
							name : "report 2 7",
							isFocus : false
						} ]
					}, {
						name : "group 3",
						isFocus : false,
						reports : [ {
							name : "report 3 1",
							isFocus : false
						}, {
							name : "report 3 2",
							isFocus : false
						}, {
							name : "report 3 3",
							isFocus : false
						}, {
							name : "report 3 4",
							isFocus : false
						}, {
							name : "report 3 5",
							isFocus : false
						}, {
							name : "report 3 6",
							isFocus : false
						}, {
							name : "report 3 7",
							isFocus : false
						} ]
					}, {
						name : "group 4",
						isFocus : false,
						reports : [ {
							name : "report 4 1",
							isFocus : true
						}, {
							name : "report 4 2",
							isFocus : false
						}, {
							name : "report 4 3",
							isFocus : false
						}, {
							name : "report 4 4",
							isFocus : false
						}, {
							name : "report 4 5",
							isFocus : false
						}, {
							name : "report 4 6",
							isFocus : false
						}, {
							name : "report 4 7",
							isFocus : false
						} ]
					} ];
					// console.log(scope.groups);
					// FIXME panes data;
					// Generate Reports
					for (index in scope.groups) {
						var group = scope.groups[index];
						if (group.isFocus) {
							scope.initPanesReports(group, scope)
						}
						;
					}
					;
					// console.log(scope.reports);
				}).error(function(data, status) {
					console.log(data + " , status : " + status);
				});
			};
		} ]);
// Controller
var WorkspaceController = function($scope, GroupService, AppService) {
	$scope.init = function() {
		// Get userId from cookies
		GroupService.listGroups($scope);

	};
	$scope.initPanesReports = function(group, scope) {
		scope.reports = {
			focusReport : {},
			rows : []
		};
		scope.panes = [{
			title : group.name
		}];
		var cols = [];
		for (rep in group.reports) {
			var report = group.reports[rep];
			if (report.isFocus == true) {
				scope.reports["focusReport"] = report;
			} else {
				if ((rep - 1) % 3 == 0) {
					cols = [];
					console.log(" rows " + scope.reports.rows.length);
					scope.reports.rows[scope.reports.rows.length] = {
						"cols" : cols
					};
				}
				cols[cols.length] = report;
			}
		}
	};
	$scope.initApps = function() {
		// Get userId from cookies
		AppService.listApps($scope);

	};
	$scope.panes = [];
	$scope.radioValue = [ " Last 1 day", "Last 1 Week", "Last 1 Month" ];

	// FIXME init the reports for 1 group
	// $scope.reports = {
	// focusReport : {
	// name : "Focus Report"
	// },
	// rows : [ {
	// cols : [ {
	// name : "report1"
	// }, {
	// name : "report12"
	// }, {
	// name : "report13"
	// } ]
	// }, {
	// cols : [ {
	// name : "report21"
	// }, {
	// name : "report22"
	// }, {
	// name : "report23"
	// } ]
	// }, {
	// cols : [ {
	// name : "report31"
	// }, {
	// name : "report32"
	// }, {
	// name : "report33"
	// } ]
	// } ]
	// };
	// AddPane
	$scope.addPane = function(index) {
		var group = $scope.groups[index];

		console.log(group);
		if ($scope.panes.length < 10) {
			$scope.initPanesReports(group, $scope);
			$scope.panes[$scope.panes.length - 1]["active"] = true;
		}

	};
};

Workspace.controller("WorkspaceContrl", WorkspaceController);
