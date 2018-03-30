package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Product  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ProductController {
    private static final Log log = LogFactory.getLog(ProductController.class);
    
    @Autowired
    private ProductService productService;
    
    /**
     * 精选,前台产品列表
     *
     * @param page          当前页数
     * @param size          每页数量
     * @param recommended   0代表所有产品,1代表查询推荐
     * @param productStatus 0在售,1停售
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/l/product/list", method = RequestMethod.GET)
    public String getProductList(Integer page, Integer size, Integer recommended, Integer productStatus, ModelMap modelMap) {
        
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        if(CommonUtil.isEmpty(recommended,productStatus)){
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/product/json/productListJson";
        }
        try {
            if (recommended == 0) {
                List<Long> ids = productService.getProductIdsByProductStatus(productStatus, start, size);
                
                List<Product> products = productService.getObjectsByIds(ids);
                modelMap.addAttribute("productList", products);
                modelMap.addAttribute("code", 0);
                modelMap.addAttribute("total", productService.countProductIds());
                modelMap.addAttribute("size", size);
            } else {
                List<Long> ids = productService.getProductIdsByRecommendedAndProductStatus(1, productStatus, start, size);
                List<Product> products = productService.getObjectsByIds(ids);
                modelMap.addAttribute("productList", products);
                modelMap.addAttribute("code", 0);
                modelMap.addAttribute("total", productService.countProductIdsByRecommendedAndProductStatus(1, 0));
                modelMap.addAttribute("size", 3);
            }
            
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        
        return "polyFinance-lgd-server/product/json/productListJson";
    }
    
    /**
     * 查询单个产品详情
     *
     * @param id    产品id
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, ModelMap model) {
        try {
            Product product = productService.getObjectById(id);
            model.addAttribute("product", product);
            model.addAttribute("code", 0);
        } catch (ServiceException | ServiceDaoException e) {
            model.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productDetailJson";
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    
    @RequestMapping(value = "/c/product", method = RequestMethod.GET)
    public String getproductList(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model) throws Exception {
        
        
        log.info("/product  to /product/view/productList");
        
        return "/polyFinance-lgd-server/product/view/productList";
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    
    
    @RequestMapping(value = "/c/product1 ", method = RequestMethod.GET)
    public String getProductIdsByRecommendedList1(HttpServletRequest request,
                                                  HttpServletResponse response, ModelMap model, Integer recommended) throws Exception {
        
        log.info("/product  to /product/view/productList");
        
        return "/polyFinance-lgd-server/product/view/productList";
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    
    
    @RequestMapping(value = "/c/product2 ", method = RequestMethod.GET)
    public String getProductIdsByRecommendedAndProductStatusList2(HttpServletRequest request,
                                                                  HttpServletResponse response, ModelMap model, Integer recommended, Integer productStatus) throws Exception {
        
        log.info("/product  to /product/view/productList");
        
        return "/polyFinance-lgd-server/product/view/productList";
    }
    
    
    @RequestMapping(value = "/c/product/{id}", method = RequestMethod.GET)
    public String getProduct(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("/product/" + id + "  to /product/view/productDeail");
        if (null != id) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", 0);
        }
        
        return "/polyFinance-lgd-server/product/view/productDetail";
    }
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    
    
    /**
     * @param
     * @return
     * @throws ServiceException
     * @throws ServiceDaoException
     */
    
    @RequestMapping(value = "/a/product2 ", method = RequestMethod.GET)
    public String getProductIdsByRecommendedAndProductStatusJsonList(HttpServletRequest request,
                                                                     HttpServletResponse response, ModelMap model, Integer page,
                                                                     Integer size, Integer recommended, Integer productStatus) throws Exception {
        
        
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        
        log.info("pageList : page= " + start + " , size=" + size);
        
        try {
            
            List<Long> ids = productService.getProductIdsByRecommendedAndProductStatus(recommended, productStatus, start, size);
            log.info("get countProductIdsByRecommendedAndProductStatus size is " + ids.size());
            
            List<Product> productList = productService.getObjectsByIds(ids);
            log.info("get product data is " + productList.size());
            
            Integer total = productService.countProductIdsByRecommendedAndProductStatus(recommended, productStatus);
            log.info("get product count is " + total);
            
            model.addAttribute("code", 0);
            model.addAttribute("page", page);
            model.addAttribute("size", size);
            
            model.addAttribute("total", total);
            
            model.addAttribute("productList", productList);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get product list error,page is  " + start + " , size "
                    + size);
            // for test
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/product/json/productListJson";
    }
    
}

