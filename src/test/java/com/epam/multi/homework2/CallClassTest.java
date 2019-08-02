package com.epam.multi.homework2;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CallClassTest {
    private String callReturn = "Return from call: ";

    @Test
    public void call() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> list = executorService.submit(new CallClass(0));
        assertEquals(callReturn + 0, list.get());
        assertNotEquals(callReturn + 1, list.get());
    }
}
