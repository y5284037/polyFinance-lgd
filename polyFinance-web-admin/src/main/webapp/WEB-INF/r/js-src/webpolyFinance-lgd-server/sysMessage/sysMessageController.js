'use strict';
angular.module('polyFinance_lgd')
    .controller('sysMessageCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, sysMessageService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     title: $state.params.title
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     resume: $state.params.resume
	                              ,  
                     	     messagePic: $state.params.messagePic
	                              ,  
                     	     messageType: $state.params.messageType
	                              ,  
                     	     sendType: $state.params.sendType
	                              ,  
                     	     sendTime: $state.params.sendTime
	                              ,  
                     	     sendTo: $state.params.sendTo
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


    sysMessageService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.sysMessageList", vm.params,{reload:true});
    };
    });
