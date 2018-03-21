'use strict';
angular.module('polyFinance_lgd')
    .controller('repaymentCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, repaymentService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     investRecordId: $state.params.investRecordId
	                              ,  
                     	     repaymentDate: $state.params.repaymentDate
	                              ,  
                     	     repaymentAmount: $state.params.repaymentAmount
	                              ,  
                     	     moneyType: $state.params.moneyType
	                              ,  
                     	     repaymentStatus: $state.params.repaymentStatus
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


    repaymentService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.repaymentList", vm.params,{reload:true});
    };
    });
