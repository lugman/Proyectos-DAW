/*
 * Created by Lugman Sami 2/06/17 18:522/06/17 18:52
 * Copyright (c) 2017.
 * you the  lugman	don't have right to modifify or alter this app.
 */

package es.com.lugman.www.diarytask;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("es.com.lugman.www.diarytask", appContext.getPackageName());
    }
}
