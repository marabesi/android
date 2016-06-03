package com.example.login.login_service;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void thereIsUserToBeUsed() throws Exception {

    }

    @Test
    public void shouldCalculateAgeGivenAYearhOfBirth() {
        LoginService loginService = new LoginService();

        assertEquals(23, loginService.age(1993));
    }

    @Test
    public void shouldReturnZeroWhenTheGivenYearIsGreaterThanTheCurrentYear() {
        LoginService loginService = new LoginService();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        assertEquals(0, loginService.age(currentYear + 2));
    }

    @Test
    public void shouldReturnZeroWhenTheGivenYearIsTheSameOfCurrentYear() {
        LoginService loginService = new LoginService();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        assertEquals(0, loginService.age(currentYear));
    }

}