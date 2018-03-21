'use strict';
angular.module('polyFinance_lgd')
    .controller('tradingRecordCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, tradingRecordService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     userId: $state.params.userId
	                              ,  
                     	     tradingNum: $state.params.tradingNum
	                              ,  
                     	     productName: $state.params.productName
	                              ,  
                     	     tradingAmount: $state.params.tradingAmount
	                              ,  
                     	     tradingType: $state.params.tradingType
	                              ,  
                     	     tradingStatus: $state.params.tradingStatus
	                              ,  
                     	     tradingMode: $state.params.tradingMode
	                              ,  
                     	     tradingTime: $state.params.tradingTime
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


    tradingRecordService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.tradingRecordList", vm.params,{reload:true});
    };
    });
