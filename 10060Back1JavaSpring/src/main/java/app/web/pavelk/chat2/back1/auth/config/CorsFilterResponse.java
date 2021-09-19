package app.web.pavelk.chat2.back1.auth.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilterResponse implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request2 = (HttpServletRequest) request;
        HttpServletResponse response2 = (HttpServletResponse) response;
//        response2.setHeader("Access-Control-Allow-Origin", "*");
//        response2.setHeader("Access-Control-Allow-Credentials", "true");
//        response2.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
//        response2.setHeader("Access-Control-Max-Age", "3600");
//        response2.setHeader("Access-Control-Allow-Headers", "Origin, Cache-Control, X-Requested-With, Content-Type, Accept, Key, Authorization");
        response2.setHeader("Type-App-Back", "back1");
        chain.doFilter(request2, response2);
    }
}
