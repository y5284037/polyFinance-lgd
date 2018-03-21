'use strict';
angular.module('polyFinance_lgd')
    .controller('debtorCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, debtorService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     debtorMark: $state.params.debtorMark
	                              ,  
                     	     debtorName: $state.params.debtorName
	                              ,  
                     	     debtorPhone: $state.params.debtorPhone
	                              ,  
                     	     debtorIDcard: $state.params.debtorIDcard
	                              ,  
                     	     expires: $state.params.expires
	                              ,  
                     	     debtStartTime: $state.params.debtStartTime
	                              ,  
                     	     debtEndTime: $state.params.debtEndTime
	                              ,  
                     	     amount: $state.params.amount
	                              ,  
                     	     debtorInvest: $state.params.debtorInvest
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     matchedAmount: $state.params.matchedAmount
	                              ,  
                     	     remark: $state.params.remark
	                              ,  
                     	     nature: $state.params.nature
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


    debtorService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.debtorList", vm.params,{reload:true});
    };
    });
