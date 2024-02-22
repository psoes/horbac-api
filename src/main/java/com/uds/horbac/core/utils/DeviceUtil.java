package com.uds.horbac.core.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import ua_parser.Client;
import ua_parser.Parser;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

@Slf4j
public class DeviceUtil {
    public static HttpServletRequest getCurrentHttpRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            return request;
        }
        log.debug("Not called in the context of an HTTP request");
        return null;
    }

    public static String getClientIpAddress() {
        HttpServletRequest request = getCurrentHttpRequest();
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
        }
    }

    public static Locale getLocale() {
        HttpServletRequest request = getCurrentHttpRequest();
        return RequestContextUtils.getLocale(request);
    }

    public static TimeZone getTimeZone() {
        HttpServletRequest request = getCurrentHttpRequest();
        return RequestContextUtils.getTimeZone(request);
    }

    public static String getUserAgent() {
        HttpServletRequest request = getCurrentHttpRequest();
        String userAgent = request.getHeader("User-Agent");
        return userAgent;
    }

    public static Client getClientInfo() {
        Client cl;
        try {
            Parser uaParser = new Parser();
            cl = uaParser.parse(getUserAgent());
        } catch (Exception ex) {
            return null;
        }
        return cl;
    }


    public static Source getSource() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest();

        HttpRequest httpRequest = new ServletServerHttpRequest(request);
        UriComponents uriComponents = UriComponentsBuilder.fromHttpRequest(httpRequest).build();
        String serverName = request.getServerName();
        String scheme = uriComponents.getScheme();
        int port = request.getServerPort();
        String domain = request.getHeader("Host");
        String origin = request.getHeader("origin");
        String referer = request.getHeader("referer");
        String uri = request.getRequestURI();
        return new Source(serverName, scheme, port, domain, origin, referer, uri);

    }

    public static String determineDeviceType(Client client) {
        String os = client.os.family.toLowerCase();
        String device = client.device.family.toLowerCase();

        if (device.contains("mobile") || os.contains("android") || os.contains("ios")) {
            return "MOBILE";
        } else if (device.contains("tablet")) {
            return "TABLET";
        } else {
            return "DESKTOP";
        }
    }

    public static class Source {
        public String serverName;
        public String scheme;
        public int port;
        public String domain;
        public String origin;
        public String referer;

        public String uri;

        public Source(String serverName,
                      String scheme,
                      int port,
                      String domain,
                      String origin,
                      String referer, String uri) {
            this.serverName = serverName;
            this.scheme = scheme;
            this.port = port;
            this.domain = domain;
            this.origin = origin;
            this.referer = referer;
            this.uri = uri;
        }

        @Override
        public String toString() {
            return "Source{" +
                    "serverName='" + serverName + '\'' +
                    ", scheme='" + scheme + '\'' +
                    ", port=" + port +
                    ", domain='" + domain + '\'' +
                    ", origin='" + origin + '\'' +
                    ", referer='" + referer + '\'' +
                    '}';
        }
    }

    // /app

}
