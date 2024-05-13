package org.example;

import org.junit.jupiter.api.Order;
import org.testng.annotations.Test;

public class PrioritizedTests {

    @Order(1)
    @Test
    void jUnitOrder() {

    }

    @Test(priority = 3)
    void test1() {
        System.out.println("This is test1");
    }
    @Test(priority = 1)
    void test2() {
        System.out.println("This is test2");
    }
    @Test(priority = 2)
    void test3() {
        System.out.println("This is test3");
    }
}
