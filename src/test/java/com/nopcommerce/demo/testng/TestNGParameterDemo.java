package com.nopcommerce.demo.testng;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
public class TestNGParameterDemo {

    @Test
    @Parameters({"myName","myName2"})
    public void test(@Optional("Jay") String name, @Optional("Vaghani") String name2) {
        System.out.println("My name is : " + name );
        System.out.println("My name is : " + name2 );
    }
}
