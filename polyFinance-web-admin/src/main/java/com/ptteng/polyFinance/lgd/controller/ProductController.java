package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
     * 查询产品列表
     *
     * @param name                      产品名称
     * @param interestAmountLine        起投金额
     * @param productMark               产品代号
     * @param interestDelayed           起息日期
     * @param productStatus             产品状态
     * @param interestRateStart         年化收益下限
     * @param interestRateEnd           年化收益上限
     * @param financialPeriodDayStart   期限下限(日)
     * @param financialPeriodDayEnd     期限上限(日)
     * @param financialPeriodMonthStart 期限下限(月)
     * @param financialPeriodMonthEnd   期限上限(月)
     * @param page                      当前显示第几页
     * @param size                      每页显示数量
     * @param modelMap                  用于给前端返回数据.
     * @return 返回json-taglib页面.
     */
    @RequestMapping(value = "/a/u/productList", method = RequestMethod.GET)
    public String getProductList(String name, BigDecimal interestAmountLine, String productMark, Integer interestDelayed, Integer productStatus, BigDecimal interestRateStart, BigDecimal interestRateEnd, Integer financialPeriodDayStart, Integer financialPeriodDayEnd, Integer financialPeriodMonthStart, Integer financialPeriodMonthEnd, Integer page, Integer size, ModelMap modelMap) {
        
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
        
        Map<String, Object> map = DynamicUtil.getProductListSqlMap(name, interestAmountLine, productMark, interestDelayed, productStatus, interestRateStart, interestRateEnd, financialPeriodDayStart, financialPeriodDayEnd, financialPeriodMonthStart, financialPeriodMonthEnd);
        try {
            List<Long> ids = productService.getIdsByDynamicCondition(Product.class, map, start, size);
            List<Long> countIds = productService.getIdsByDynamicCondition(Product.class, map, 0, productService.countProductIds());
            System.out.println(SQLUtil.convert2Sql(map, start, size));
            List<Product> products = productService.getObjectsByIds(ids);
            modelMap.addAttribute("productList", products);
            modelMap.addAttribute("total", countIds.size());
            modelMap.addAttribute("code", 0);
            modelMap.addAttribute("size", size);
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -100000);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productListJson";
    }
    
    /**
     * @param id       需要更新上下架的产品id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/product/{id}", method = RequestMethod.PUT)
    public String changeStatus(@PathVariable Long id, ModelMap modelMap) {
        try {
            Product product = productService.getObjectById(id);
            if (product.getProductStatus() == 0) {
                product.setProductStatus(1);
            } else {
                product.setProductStatus(0);
            }
            productService.update(product);
            modelMap.addAttribute("code", 0);
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -100000);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productChangeStatus";
    }
    
    
    @RequestMapping(value = "/a/u/product",method = RequestMethod.POST)
    public String insertProduct(Product product, MultipartFile detailsPic,ModelMap modelMap){
        product.setCreateAt(System.currentTimeMillis());
        product.setUpdateAt(System.currentTimeMillis());
        product.setCreateBy(007L);
        product.setUpdateBy(007L);
        try {
            InputStream is = detailsPic.getInputStream();
            String [] strs = detailsPic.getOriginalFilename().split("\\.");
            String suffix = strs[strs.length - 1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    
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
    
    @RequestMapping(value = "/a/product1 ", method = RequestMethod.GET)
    public String getProductIdsByRecommendedJsonList(HttpServletRequest request,
                                                     HttpServletResponse response, ModelMap model, Integer page,
                                                     Integer size, Integer recommended) throws Exception {
        
        
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
            
            List<Long> ids = productService.getProductIdsByRecommended(recommended, start, size);
            log.info("get countProductIdsByRecommended size is " + ids.size());
            
            List<Product> productList = productService.getObjectsByIds(ids);
            log.info("get product data is " + productList.size());
            
            Integer total = productService.countProductIdsByRecommended(recommended);
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
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/product/json/productListJson";
    }
    
    
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
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/product/json/productListJson";
    }
    
    
    @RequestMapping(value = "/a/product/{id}", method = RequestMethod.GET)
    public String getProductJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            Product product = productService.getObjectById(id);
            log.info("get product data is " + product);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("product", product);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get product error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/product/json/productDetailJson";
    }
    
    @RequestMapping(value = "/a/product/{id}", method = RequestMethod.PUT)
    public String updateProductJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Product product) throws Exception {
        
        log.info("update product : product= " + product);
        
        try {
            
            productService.update(product);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("product", product);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update product error,id is  " + product.getId());
            model.addAttribute("code", -6003);
            
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/product", method = RequestMethod.POST)
    public String addProductJson(HttpServletRequest request,
                                 HttpServletResponse response, ModelMap model, Product product) throws Exception {
        
        log.info("update product : product= " + product);
        
        try {
            product.setId(null);
            
            productService.insert(product);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add product error ");
            model.addAttribute("code", -6002);
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/product/{id}", method = RequestMethod.DELETE)
    public String deleteProductJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("delete product : id= " + id);
        try {
            productService.delete(id);
            
            log.info("add product success");
            model.addAttribute("code", 0);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete product error,id is  " + id);
            model.addAttribute("code", -6004);
            
        }
        
        return "/data/json";
    }
    
    
    @RequestMapping(value = "/a/multi/product", method = RequestMethod.GET)
    public String getMultiProductJson(HttpServletRequest request,
                                      HttpServletResponse response, ModelMap model, Long[] ids)
            throws Exception {
        
        List<Long> idList = new ArrayList();
        if (ids == null) {
        
        } else {
            idList = Arrays.asList(ids);
        }
        try {
            
            
            List<Product> productList = productService.getObjectsByIds(idList);
            log.info("get  product data is " + productList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", productList.size());
            
            model.addAttribute("productList", productList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get product error,id is  " + idList);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/product/json/productListJson";
    }
    
    
}

