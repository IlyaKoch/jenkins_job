package test.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTest {
    @Test
    @Disabled
    void test0(){
        assertTrue(false);
    }

    @Test
    @Disabled
    void test1(){
        assertTrue(false);
    }

    @Test
    @Disabled
    void test2(){
        assertTrue(false);
    }

}