package com.uds.horbac.integration;

import com.uds.horbac.core.entities.requests.AccessRequest;
import com.uds.horbac.core.entities.requests.AppResponse;
import com.uds.horbac.core.entities.requests.Request;
import com.uds.horbac.core.utils.DeviceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua_parser.Client;

import javax.persistence.Access;
import java.util.Base64;

@Service
public class ApprovalService {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<AppResponse> handleApproval(AccessRequest.AccessRequestBuilder builder) {
        Client client = DeviceUtil.getClientInfo();
        builder.ipAddress(DeviceUtil.getClientIpAddress() != null ? DeviceUtil.getClientIpAddress() : "unknown");


        if (client != null) {
            String ua_v = client.userAgent != null ? client.userAgent.major : "unknown";
            String os = client.os != null ? client.os.family : "unknown";
            String os_v = client.os != null ? client.os.major : "unknown";
            String dev = client.device != null ? client.device.family : "unknown";
            String userAgent = DeviceUtil.getUserAgent() != null ? DeviceUtil.getUserAgent() : "unknown";
            String locale = DeviceUtil.getLocale().toString();

            builder.clientType(client.userAgent != null ? client.userAgent.family : "unknown")
                    .agentVersion(ua_v)
                    .locale(locale)
                    .osName(os)
                    .osVersion(os_v)
                    .clientName(dev)
                    .userAgent(userAgent);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        String password = "password";
        String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        headers.set("Authorization", "Basic " + encodedCredentials);

        HttpEntity<AccessRequest> request = new HttpEntity<>(builder.build(), headers);

        String url = "http://localhost:9080/process/secure/request-approval/start";
        ResponseEntity<AppResponse> response = restTemplate.postForEntity(url, request, AppResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());

        return response;
    }
}
