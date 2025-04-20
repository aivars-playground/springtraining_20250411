package org.example.base.actuators;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customactuator")
public class CustomActuator {

    @ReadOperation
    private String reportedStatus() {
        return "Custom Actuator is running";
    }
}
