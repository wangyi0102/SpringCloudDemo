package demo.spring.cloud.consumer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 核桃(wy)
 * @date 2021/7/3 10:58
 * @description 拦截器
 **/
@Configuration
public class MyInterceptor {

    @Bean
    public RequestInterceptor getRequestInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                System.out.println("----拦截器----");
                requestTemplate.header("token", "123456789");
            }
        };
    }
}
