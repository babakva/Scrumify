'use strict';

angular.module('scrumifyApp', ['scrumifyService']).
        config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
            when('/task/list', {templateUrl:'views/task-list.html', controller:TaskListController}).
            when('/task/new', {templateUrl:'views/task-new.html', controller:TaskNewController}).
            when('/task/:id', {templateUrl:'views/task-detail.html', controller:TaskDetailController}).
            otherwise({redirectTo:'/task/list'});
}]);
