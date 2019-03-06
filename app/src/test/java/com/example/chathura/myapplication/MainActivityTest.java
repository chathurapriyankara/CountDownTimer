package com.example.chathura.myapplication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class) //Test runner
public class MainActivityTest {
    private MainActivity mainActivity;
    @Before
    public void setUp() {
        mainActivity = new MainActivity();
    }

    @Test
    public void testAdd() {
        double result = mainActivity.add(5d,5d);
        assertThat("Results should be equal",result, is(equalTo(11d)));
    }

    @After
    public void tearDown() {

    }
}
