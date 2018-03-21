'use strict';
angular.module('polyFinance_lgd')
    .controller('suggestionCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, suggestionService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     phone: $state.params.phone
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     email: $state.params.email
	                              ,  
                     	     suggestionDetail: $state.params.suggestionDetail
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


    suggestionService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.suggestionList", vm.params,{reload:true});
    };
    });
