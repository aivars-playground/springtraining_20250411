package org.example.base.services;

import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    public int add(int a, int b) {
        return a + b;
    }
}
