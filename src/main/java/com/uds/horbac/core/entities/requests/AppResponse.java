package com.uds.horbac.core.entities.requests;

import com.uds.horbac.core.entities.permissions.OperationalPermission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import springfox.documentation.spring.web.readers.operation.OperationTagsReader;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppResponse implements Serializable {
    private Integer statusCode;
    private HttpStatus status;
    private String message;
    private Object data;
    private List<OperationalPermission> permissions;
    private String decision;
    private Long duration;
}
