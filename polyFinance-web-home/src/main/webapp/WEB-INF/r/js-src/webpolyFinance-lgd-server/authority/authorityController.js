'use strict';
angular.module('polyFinance_lgd')
    .controller('authorityCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, authorityService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     adminRoleId: $state.params.adminRoleId
	                              ,  
                     	     moduleId: $state.params.moduleId
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                              ,  
                              };


    authorityService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.authorityList", vm.params,{reload:true});
    };
    });
