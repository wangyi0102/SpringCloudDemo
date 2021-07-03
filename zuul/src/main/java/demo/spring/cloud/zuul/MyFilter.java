package demo.spring.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 0003 14:47
 * @description
 **/
public class MyFilter extends ZuulFilter {

    // filterType：过滤器的类型，它决定过滤器在请求的哪个生命周期中执行。
    // pre：可以在请求被路由之前调用
    // route：在路由请求时候被调用
    // post：在route和error过滤器之后被调用
    // error：处理请求时发生错误时被调用
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序。值越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    // shouldFilter：判断该过滤器是否需要被执行。
    // true表示该过滤器对所有请求都会生效。
    // 实际运用中我们可以利用该函数来指定过滤器的有效范围。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        System.out.println("--token:" + token);
        if(token == null || token == ""){
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            currentContext.addZuulResponseHeader("content-type","text/html;charset=utf-8");
            currentContext.setResponseBody("您没有权限访问");
        }
        return null;
    }
}
