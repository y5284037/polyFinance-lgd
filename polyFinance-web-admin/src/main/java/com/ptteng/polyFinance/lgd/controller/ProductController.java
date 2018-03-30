package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.service.ProductService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
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
            System.out.println(SQLUtil.convert2Sql(map, start, size));
            List<Product> products = productService.getObjectsByIds(ids);
            modelMap.addAttribute("productList", products);
            modelMap.addAttribute("total", productService.countProductIds());
            modelMap.addAttribute("code", 0);
            modelMap.addAttribute("size", size);
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productListJson";
    }
    
    /**
     * 更新产品上下架状态.
     *
     * @param id       需要更新上下架的产品id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/product/{id}", method = RequestMethod.PUT)
    public String changeStatus(@PathVariable Long id, ModelMap modelMap) {
        if(CommonUtil.isEmpty(id)){
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/product/json/productChangeStatus";
        }
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
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productChangeStatus";
    }
    
    /**
     * 新增产品接口
     *
     * @param product        产品信息
     * @param detailsPicFile 图片对象
     * @param modelMap       回显数据
     * @return 返回json数据.
     */
    @RequestMapping(value = "/a/u/product", method = RequestMethod.POST)
    public String insertProduct(Product product, MultipartFile detailsPicFile, ModelMap modelMap) {
        
        product.setCreateBy(7L);
        product.setUpdateBy(7L);
        
        try {
            product.setDetailsPic(FilesUtil.upLoadFile(detailsPicFile));
        } catch (IOException e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        try {
            productService.insert(product);
            modelMap.addAttribute("code", 0);
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/product/json/productNewOne";
        
    }
    
    /**
     * 获取单个产品详情
     *
     * @param id       产品id
     * @param modelMap 回显数据
     * @return
     */
    @RequestMapping(value = "/a/u/product/list/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, ModelMap modelMap) {
        try {
            Product product = productService.getObjectById(id);
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("code", 0);
            modelMap.addAttribute("detailsPicUrl", FilesUtil.getUrl(product.getDetailsPic()));
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -200);
            e.printStackTrace();
        }
        
        return "polyFinance-lgd-server/product/json/product";
    }
    
    /**
     * 更新产品接口
     *
     * @param id             产品ID
     * @param product        需要更新的产品原信息
     * @param detailsPicFile 图片文件
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/product/list/{id}", method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Product product, MultipartFile detailsPicFile, ModelMap modelMap) {
        
        if (!CommonUtil.isEmpty(detailsPicFile) && detailsPicFile.getSize() > 0) {
            try {
                product.setDetailsPic(FilesUtil.upLoadFile(detailsPicFile));
            } catch (IOException e) {
                modelMap.addAttribute("code", -200);
                e.printStackTrace();
            }
        }
        try {
            productService.update(product);
            modelMap.addAttribute("code", 0);
        } catch (ServiceException | ServiceDaoException e) {
            modelMap.addAttribute("code", -200);
            e.printStackTrace();
        }
        
        return "polyFinance-lgd-server/product/json/productNewOne";
        
    }
    
}

