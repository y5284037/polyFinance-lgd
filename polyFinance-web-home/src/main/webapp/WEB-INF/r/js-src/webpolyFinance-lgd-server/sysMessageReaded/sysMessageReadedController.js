'use strict';
angular.module('polyFinance_lgd')
    .controller('sysMessageReadedCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, sysMessageReadedService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     sysMessageId: $state.params.sysMessageId
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     readStatus: $state.params.readStatus
	                              ,  
                     	     deleteStatus: $state.params.deleteStatus
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     updateBy: $state.params.updateBy
	                              ,  
                              };


    sysMessageReadedService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.sysMessageReadedList", vm.params,{reload:true});
    };
    });
