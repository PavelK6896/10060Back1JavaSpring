package app.web.pavelk.chat2.back1.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CorsFilterResponse implements Filter {

    @Value("${ws.origins:}")
    private List<String> allowedOrigins;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request2 = (HttpServletRequest) request;
        HttpServletResponse response2 = (HttpServletResponse) response;

        String origin = request2.getHeader("Origin");
        response2.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
        response2.setHeader("Vary", "Origin");

//        response2.setHeader("Access-Control-Allow-Origin", "*");
        response2.setHeader("Access-Control-Allow-Credentials", "true");
        response2.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, PATCH");
        response2.setHeader("Access-Control-Max-Age", "3600");
        response2.setHeader("Access-Control-Allow-Headers", "Origin, Cache-Control, X-Requested-With, Content-Type, Accept, Key, Authorization");
        response2.setHeader("Type-App-Back", "back1");
        chain.doFilter(request2, response2);
    }
}
