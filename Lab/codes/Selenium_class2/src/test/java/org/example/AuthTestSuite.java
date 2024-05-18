package org.example;

import org.example.testing.LoginTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
        LoginTest.class
})
public class AuthTestSuite {

}
