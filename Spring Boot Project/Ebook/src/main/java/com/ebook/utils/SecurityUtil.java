package com.ebook.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class SecurityUtil {

	public static String extractAuthTokenFromRequest(HttpServletRequest request) {

		String bearerToken = request.getHeader(AppConstant.AUTH_HEADER);

		if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AppConstant.AUTH_TOKEN_PREFIX)) {
			//System.out.println("token="+bearerToken.substring(7));
			return bearerToken.substring(7);
		}

		return null;
	}

}
