package com.tiv.lab.blackbox.config.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class RedirectLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, "classpath:/static/test.html");
//        Object detailsObj = authentication.getDetails();
//        if (detailsObj instanceof WebAuthenticationDetails) {
//            WebAuthenticationDetails authDetails = (WebAuthenticationDetails) detailsObj;
//            log.info("Save Authenticated Session [{}]", authDetails.getSessionId());
////            redisSessionRepositoryManager.saveAuthenticatedSession(authDetails.getSessionId());
//        }
//
//        SavedRequest savedRequest = this.requestCache.getRequest(request, response);
//        if (savedRequest == null) {
////            super.onAuthenticationSuccess(request, response, authentication);
//            response.getWriter().write(new JSONObject().put("timestamp", LocalDateTime.now()).toString());
//            response.setStatus(200);
//        } else {
//            String targetUrlParameter = this.getTargetUrlParameter();
//            if (!this.isAlwaysUseDefaultTargetUrl() && (targetUrlParameter == null || !StringUtils.isNotEmpty(request.getParameter(targetUrlParameter)))) {
//                this.clearAuthenticationAttributes(request);
//                String targetUrl = savedRequest.getRedirectUrl();
//                log.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
////                this.getRedirectStrategy().sendRedirect(request, response, targetUrl);
//                response.getWriter().write(new JSONObject().put("timestamp", LocalDateTime.now()).put("requestedURL", targetUrl).toString());
//                response.setStatus(200);
//
//            } else {
//                this.requestCache.removeRequest(request, response);
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        }
    }
}
