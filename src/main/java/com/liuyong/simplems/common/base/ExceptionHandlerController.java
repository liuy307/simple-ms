package com.liuyong.simplems.common.base;

import com.alibaba.fastjson.JSON;
import com.liuyong.simplems.common.core.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常捕捉Controller
 *
 * @author liuyong
 * @date 2020/8/5 9:55
 */
@Slf4j
public abstract class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(HttpServletRequest request, HttpServletResponse response, Exception ex){
        try {
            log.error(ex.getMessage(), ex);
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(ApiResponse.failed(ex.getMessage())));

            // 如果为异步请求，返回ApiResponse对象
//            if(this.isAjax(request)){
//                response.setHeader("content-type", "text/html;charset=UTF-8");
//                response.getWriter().write(JSON.toJSONString(ApiResponse.failed(ex.getMessage())));
//                return null;
//            }
//            // 跳转至error页面
//            ModelMap model = new ModelMap();
//            model.addAttribute("error", ex.getMessage());
//            return new ModelAndView("error/default", model);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            ModelMap model = new ModelMap();
//            model.addAttribute("error", "未知异常");
//            return new ModelAndView("error/default", model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 判断请求是否为异步
//    private boolean isAjax(HttpServletRequest request){
//        return StringUtils.isNotBlank(request.getHeader("X-Requested-With"));
//    }
}
