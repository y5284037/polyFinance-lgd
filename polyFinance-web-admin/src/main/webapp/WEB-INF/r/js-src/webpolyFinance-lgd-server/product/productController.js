'use strict';
angular.module('polyFinance_lgd')
    .controller('productCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, productService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     productMark: $state.params.productMark
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     interestRate: $state.params.interestRate
	                              ,  
                     	     financialPeriodDay: $state.params.financialPeriodDay
	                              ,  
                     	     financialPeriodMonth: $state.params.financialPeriodMonth
	                              ,  
                     	     paymentMethod: $state.params.paymentMethod
	                              ,  
                     	     interestDelayed: $state.params.interestDelayed
	                              ,  
                     	     productStatus: $state.params.productStatus
	                              ,  
                     	     interestAmountLine: $state.params.interestAmountLine
	                              ,  
                     	     remark: $state.params.remark
	                              ,  
                     	     detailsPic: $state.params.detailsPic
	                              ,  
                     	     hotCornerMark: $state.params.hotCornerMark
	                              ,  
                     	     newCornerMark: $state.params.newCornerMark
	                              ,  
                     	     recommended: $state.params.recommended
	                              ,  
                     	     limited: $state.params.limited
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                         };


    productService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.productList", vm.params,{reload:true});
    };
    });
