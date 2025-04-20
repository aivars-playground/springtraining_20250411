package org.example.base.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.MessageFormat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WorkerServiceTest {

    @Mock
    private WorkerService workerService;

    @InjectMocks
    private ManagerService managerService;

    @Test
    void test_adding() {
        when(workerService.add(1,2)).thenReturn(123456);
        String expected = "Adding 1 and 2 returns 123,456";
        assertEquals(expected, managerService.reportResultOfAdding(1, 2));
    }
}