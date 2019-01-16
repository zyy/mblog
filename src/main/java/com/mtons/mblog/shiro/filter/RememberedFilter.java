package com.mtons.mblog.shiro.filter;

import com.mtons.mblog.modules.data.AccountProfile;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author : xulang
 * @version : 1.0
 * @date : 2019/1/16
 */
public class RememberedFilter extends FormAuthenticationFilter {

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if (!subject.isAuthenticated() && subject.isRemembered() && session.getAttribute("profile") == null) {
            AccountProfile profile = (AccountProfile) subject.getPrincipal();
            session.setAttribute("profile", profile);
        }
        return subject.isAuthenticated() || subject.isRemembered();
    }
}
