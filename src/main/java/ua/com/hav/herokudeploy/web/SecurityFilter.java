package ua.com.hav.herokudeploy.web;

import ua.com.hav.herokudeploy.model.User;
import ua.com.hav.herokudeploy.model.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@WebFilter(urlPatterns = "/*")
public class SecurityFilter implements Filter {

    public static final String GUEST = "GUEST";
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";

    private Map<String, List<String>> accessRightsEquals = new HashMap<String, List<String>>(){{
        put("/units", asList(ADMIN, USER, GUEST));
        put("/users", asList(ADMIN, USER));
        put("/logout", asList(ADMIN, USER, GUEST));
        put("/roles", asList(ADMIN, USER));
        put("/clients", asList(ADMIN, USER));
        put("/levels", asList(ADMIN, USER));
        put("/states", asList(ADMIN));
        put("/channels", asList(ADMIN));
        put("/payments", asList(ADMIN, USER));
        put("/expenses", asList(ADMIN, USER));
        put("/outcomes", asList(ADMIN));
        put("/reasons", asList(ADMIN));
    }};

    private Map<String, List<String>> accessRightsStartsWith = new HashMap<String, List<String>>(){{
        put("/units/", asList(ADMIN, USER, GUEST));
        put("/users/", asList(ADMIN, USER));
        put("/roles/", asList(ADMIN, USER));
        put("/clients/", asList(ADMIN, USER));
        put("/levels/", asList(ADMIN));
        put("/states/", asList(ADMIN));
        put("/channels/", asList(ADMIN));
        put("/payments/", asList(ADMIN));
        put("/expenses/", asList(ADMIN, USER));
        put("/outcomes/", asList(ADMIN));
        put("/reasons/", asList(ADMIN));
    }};


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("============= Web Filter ==============");
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute("loggedUser");
        System.out.println("user = " + user);
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        System.out.println("requestURI = " + requestURI);
        String method = ((HttpServletRequest) servletRequest).getMethod();
        System.out.println("method = " + method);
        boolean accessAllowed = false;
        accessAllowed = requestURI.startsWith("/login") || requestURI.equals("/");
        if (!accessAllowed) {
            if (user != null) {
                List<String> userRoles = user.getUserRoles().stream().map(UserRole::getValue).collect(Collectors.toList());
                List<String> list = accessRightsEquals.get(requestURI);
                if (list != null) {
                    for (String role : list) {
                        if (userRoles.contains(role)) {
                            accessAllowed = true;
                            break;
                        }
                    }
                }
                if (!accessAllowed) {
                    Set<String> mappings = accessRightsStartsWith.keySet();
                    for (String s : mappings) {
                        if (requestURI.startsWith(s)) {
                            list = accessRightsStartsWith.get(s);
                            for (String role : list) {
                                if (userRoles.contains(role)) {
                                    accessAllowed = true;
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        }


        if (accessAllowed) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/forbidden").forward(servletRequest, servletResponse);
        }
    }
}
