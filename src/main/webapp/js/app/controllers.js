'use strict';

function TaskListController($scope, $location, Task) {
    $scope.tasks = Task.query();

    $scope.createTask = function () {
        Task.save($scope.task, function (task) {
            $location.path('/');
        });
    };
    $scope.deleteTask = function (task) {
        task.$delete({'id':task.id}, function () {
            $location.path('/');
        });
    };
    $scope.updateTodoStatus = function (task) {
    	task.status = 'IN_PROGRESS'
        task.$save(task, function () {
            $location.path('/');
        });
    };
}