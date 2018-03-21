'use strict';
angular.module('polyFinance_lgd')
    .controller('userCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, userService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     phoneNum: $state.params.phoneNum
	                              ,  
                     	     pswd: $state.params.pswd
	                              ,  
                     	     salt: $state.params.salt
	                              ,  
                     	     managerNum: $state.params.managerNum
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     totalProperty: $state.params.totalProperty
	                              ,  
                     	     income: $state.params.income
	                              ,  
                     	     accountsStatus: $state.params.accountsStatus
	                              ,  
                     	     address: $state.params.address
	                              ,  
                     	     email: $state.params.email
	                              ,  
                     	     IDCardFornt: $state.params.IDCardFornt
	                              ,  
                     	     IDCardBack: $state.params.IDCardBack
	                              ,  
                     	     IDCard: $state.params.IDCard
	                              ,  
                     	     identityStatus: $state.params.identityStatus
	                              ,  
                     	     refuseReason: $state.params.refuseReason
	                              ,  
                     	     refuseStatus: $state.params.refuseStatus
	                              ,  
                     	     identityTime: $state.params.identityTime
	                              ,  
                     	     userBankId: $state.params.userBankId
	                              ,  
                     	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                         };


    userService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.userList", vm.params,{reload:true});
    };
    });
