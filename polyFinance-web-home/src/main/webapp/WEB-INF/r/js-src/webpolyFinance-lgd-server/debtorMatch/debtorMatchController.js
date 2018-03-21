'use strict';
angular.module('polyFinance_lgd')
    .controller('debtorMatchCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, debtorMatchService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     debtorId: $state.params.debtorId
	                              ,  
                     	     comodatoNum: $state.params.comodatoNum
	                              ,  
                     	     intercreditorAgreement: $state.params.intercreditorAgreement
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     productName: $state.params.productName
	                              ,  
                     	     valueDay: $state.params.valueDay
	                              ,  
                     	     valueEndDay: $state.params.valueEndDay
	                              ,  
                     	     investAmount: $state.params.investAmount
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


    debtorMatchService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.debtorMatchList", vm.params,{reload:true});
    };
    });
