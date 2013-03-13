'use strict';

angular.module('scrumifyApp', ['scrumifyService']).
        config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
            when('/task/list', {templateUrl:'views/task-list.html', controller:TaskListController}).
            otherwise({redirectTo:'/task/list'});
}]);
