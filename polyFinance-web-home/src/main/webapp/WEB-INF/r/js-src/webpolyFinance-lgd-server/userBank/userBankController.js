'use strict';
angular.module('polyFinance_lgd')
    .controller('userBankCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, userBankService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     city: $state.params.city
	                              ,  
                     	     bankListId: $state.params.bankListId
	                              ,  
                     	     CardNo: $state.params.CardNo
	                              ,  
                     	     bankPhone: $state.params.bankPhone
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     first: $state.params.first
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


    userBankService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.userBankList", vm.params,{reload:true});
    };
    });
