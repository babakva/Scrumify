'use strict';

function TaskListController($scope, $location, Task) {
    $scope.tasks = Task.query();
    $scope.gotoTaskNewPage = function () {
        $location.path("/task/new")
    };
    $scope.deleteTask = function (task) {
        task.$delete({'id':task.id}, function () {
            $location.path('/');
        });
    };
}

function TaskDetailController($scope, $routeParams, $location, Task) {
    $scope.task = Task.get({id:$routeParams.id}, function (task) {
    });
    $scope.gotoTaskListPage = function () {
        $location.path("/")
    };
}

function TaskNewController($scope, $location, Task) {
    $scope.submit = function () {
        Task.save($scope.task, function (task) {
            $location.path('/');
        });
    };
    $scope.gotoTaskListPage = function () {
        $location.path("/")
    };
}
