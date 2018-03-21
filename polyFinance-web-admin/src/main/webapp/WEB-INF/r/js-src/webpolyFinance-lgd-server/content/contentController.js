'use strict';
angular.module('polyFinance_lgd')
    .controller('contentCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, contentService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     title: $state.params.title
	                              ,  
                     	     type: $state.params.type
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     contentCoverPic: $state.params.contentCoverPic
	                              ,  
                     	     contentPic: $state.params.contentPic
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


    contentService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.contentList", vm.params,{reload:true});
    };
    });
