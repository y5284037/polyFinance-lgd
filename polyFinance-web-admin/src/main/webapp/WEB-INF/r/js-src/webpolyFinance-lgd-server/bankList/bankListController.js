'use strict';
angular.module('polyFinance_lgd')
    .controller('bankListCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, bankListService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     paymentAgencyNumber: $state.params.paymentAgencyNumber
	                              ,  
                     	     withdrawAgencyNumber: $state.params.withdrawAgencyNumber
	                              ,  
                     	     SingleTransactionLimit: $state.params.SingleTransactionLimit
	                              ,  
                     	     DailyLimit: $state.params.DailyLimit
	                              ,  
                     	     logoPic: $state.params.logoPic
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


    bankListService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.bankListList", vm.params,{reload:true});
    };
    });
