'use strict';

function TaskListController($scope, $location, Task) {
    $scope.tasks = Task.query();
    $scope.taskTypes = ['Test', 'Support', 'Bug', 'Story'];

    $scope.createTask = function () {
    	$scope.task.status = 'TODO';
        Task.save($scope.task, function (task) {
            $location.path('/');
        });
    };
    $scope.deleteTask = function (task) {
        task.$delete({'id':task.id}, function () {
            $location.path('/');
        });
    };

    $scope.upgradeTaskStatus = function (task) {
    	task.status = getUpgradedStatus(task.status);
        task.$save({'id':task.id}, function () {
            $location.path('/');
        });
    };


    $scope.downgradeTaskStatus = function (task) {
    	task.status = getDowngradedStatus(task.status);
        task.$save({'id':task.id}, function () {
            $location.path('/');
        });
    };

}