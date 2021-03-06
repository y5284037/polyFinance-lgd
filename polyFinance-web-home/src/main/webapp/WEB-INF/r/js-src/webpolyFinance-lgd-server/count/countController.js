'use strict';
angular.module('polyFinance_lgd')
    .controller('countCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, countService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     productId: $state.params.productId
	                              ,  
                     	     date: $state.params.date
	                              ,  
                     	     purchasePeople: $state.params.purchasePeople
	                              ,  
                     	     purchaseTimes: $state.params.purchaseTimes
	                              ,  
                     	     purchaseAmount: $state.params.purchaseAmount
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


    countService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.countList", vm.params,{reload:true});
    };
    });
