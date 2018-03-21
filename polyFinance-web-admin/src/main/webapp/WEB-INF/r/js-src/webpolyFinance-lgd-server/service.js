'use strict';
angular.module('polyFinance_lgd')

    .factory('pathProject', function (commonUtil) {
        return {
                	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                                   ,  
                        
          
         
         	     authority: function (id) {
                if (!id) {
                    return "ajax/u/authority";
                } else {
                    return "ajax/u/authority/" + id;
                }
            },
          authority_list: "ajax/u/authority/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('userService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.user(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.user(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.user_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.user(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.user(id));
            }
           
        }
    })
                
	    .factory('userBankService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userBank(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userBank(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userBank_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userBank(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userBank(id));
            }
           
        }
    })
                
	    .factory('userMessageService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.userMessage(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.userMessage(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.userMessage_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.userMessage(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.userMessage(id));
            }
           
        }
    })
                
	    .factory('sysMessageService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.sysMessage(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.sysMessage(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.sysMessage_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.sysMessage(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.sysMessage(id));
            }
           
        }
    })
                
	    .factory('sysMessageReadedService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.sysMessageReaded(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.sysMessageReaded(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.sysMessageReaded_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.sysMessageReaded(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.sysMessageReaded(id));
            }
           
        }
    })
                
	    .factory('investRecordService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.investRecord(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.investRecord(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.investRecord_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.investRecord(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.investRecord(id));
            }
           
        }
    })
                
	    .factory('productService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.product(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.product(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.product_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.product(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.product(id));
            }
           
        }
    })
                
	    .factory('repaymentService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.repayment(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.repayment(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.repayment_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.repayment(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.repayment(id));
            }
           
        }
    })
                
	    .factory('tradingRecordService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.tradingRecord(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.tradingRecord(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.tradingRecord_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.tradingRecord(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.tradingRecord(id));
            }
           
        }
    })
                
	    .factory('debtorMatchService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.debtorMatch(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.debtorMatch(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.debtorMatch_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.debtorMatch(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.debtorMatch(id));
            }
           
        }
    })
                
	    .factory('debtorService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.debtor(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.debtor(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.debtor_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.debtor(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.debtor(id));
            }
           
        }
    })
                
	    .factory('contentService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.content(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.content(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.content_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.content(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.content(id));
            }
           
        }
    })
                
	    .factory('suggestionService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.suggestion(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.suggestion(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.suggestion_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.suggestion(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.suggestion(id));
            }
           
        }
    })
                
	    .factory('bankListService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.bankList(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.bankList(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.bankList_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.bankList(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.bankList(id));
            }
           
        }
    })
                
	    .factory('adminService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.admin(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.admin(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.admin_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.admin(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.admin(id));
            }
           
        }
    })
                
	    .factory('adminRoleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.adminRole(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.adminRole(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.adminRole_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.adminRole(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.adminRole(id));
            }
           
        }
    })
                
	    .factory('moduleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.module(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.module(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.module_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.module(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.module(id));
            }
           
        }
    })
                
	    .factory('settingsService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.settings(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.settings(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.settings_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.settings(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.settings(id));
            }
           
        }
    })
                
	    .factory('countService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.count(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.count(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.count_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.count(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.count(id));
            }
           
        }
    })
                
	    .factory('authorityService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.authority(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.authority(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.authority_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.authority(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.authority(id));
            }
           
        }
    })
             
   
    ;






