'use strict';
angular.module('polyFinance_lgd')
    .controller('investRecordCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, investRecordService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     productId: $state.params.productId
	                              ,  
                     	     productName: $state.params.productName
	                              ,  
                     	     productInterestRate: $state.params.productInterestRate
	                              ,  
                     	     productPaymentMethod: $state.params.productPaymentMethod
	                              ,  
                     	     productInterestAmountLine: $state.params.productInterestAmountLine
	                              ,  
                     	     repaymentBank: $state.params.repaymentBank
	                              ,  
                     	     repaymentCard: $state.params.repaymentCard
	                              ,  
                     	     repaymentBankName: $state.params.repaymentBankName
	                              ,  
                     	     investAmount: $state.params.investAmount
	                              ,  
                     	     comodatoNum: $state.params.comodatoNum
	                              ,  
                     	     intercreditorAgreement: $state.params.intercreditorAgreement
	                              ,  
                     	     investStatus: $state.params.investStatus
	                              ,  
                     	     undistributedIncome: $state.params.undistributedIncome
	                              ,  
                     	     distributionIncome: $state.params.distributionIncome
	                              ,  
                     	     valueDay: $state.params.valueDay
	                              ,  
                     	     valueEndDay: $state.params.valueEndDay
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     createBy: $state.params.createBy
	                	     updateAt: $state.params.updateAt
	                	     updateBy: $state.params.updateBy
	                         };


    investRecordService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.investRecordList", vm.params,{reload:true});
    };
    });
