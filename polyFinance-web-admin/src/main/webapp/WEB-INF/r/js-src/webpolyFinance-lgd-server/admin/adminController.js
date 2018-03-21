'use strict';
angular.module('polyFinance_lgd')
    .controller('adminCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, adminService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     loginName: $state.params.loginName
	                              ,  
                     	     adminRoleId: $state.params.adminRoleId
	                              ,  
                     	     pswd: $state.params.pswd
	                              ,  
                     	     salt: $state.params.salt
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


    adminService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.adminList", vm.params,{reload:true});
    };
    });
