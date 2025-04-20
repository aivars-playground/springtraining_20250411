package org.example.base.services;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class ManagerService {

    @Autowired
    WorkerService workerService;

    public String reportResultOfAdding(int a, int b) {
        return MessageFormat.format("Adding {0} and {1} returns {2}", a, b, workerService.add(a, b));
    }
}
