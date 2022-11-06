package com.sinno.ssms.util;

import com.sinno.ssms.model.CustomUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Objects;

@Slf4j
public class SecurityUtils {
    public static int getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        CustomUserDetails principal = extractPrincipal(securityContext.getAuthentication());

        if (Objects.isNull(principal)) {
            log.warn("Current user not found");
            return 0;
        }

        return principal.getUserId();
    }

    private static CustomUserDetails extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            return (CustomUserDetails) authentication.getPrincipal();
        }
        return null;
    }
}
