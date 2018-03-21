'use strict';
angular.module('polyFinance_lgd')
    .controller('settingsCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, settingsService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     companyChop: $state.params.companyChop
	                              ,  
                     	     invsetExpireWarn: $state.params.invsetExpireWarn
	                              ,  
                     	     DaysBeforeMaturity: $state.params.DaysBeforeMaturity
	                              ,  
                     	     investFullLine: $state.params.investFullLine
	                              ,  
                     	     status: $state.params.status
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


    settingsService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.settingsList", vm.params,{reload:true});
    };
    });
