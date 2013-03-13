'use strict';

angular.module('scrumifyService', ['ngResource']).
        factory('Task', function ($resource) {
            return $resource('rest/task/:id', {}, {
                'save': {method:'PUT'}
            });
        });
