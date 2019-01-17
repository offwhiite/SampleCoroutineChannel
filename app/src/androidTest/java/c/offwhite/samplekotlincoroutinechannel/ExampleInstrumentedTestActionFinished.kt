package c.offwhite.samplekotlincoroutinechannel

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented TestActionFinished, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTestActionFinished {
    @Test
    fun useAppContext() {
        // Context of the app under TestActionFinished.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("c.offwhite.samplekotlincoroutinechannel", appContext.packageName)
    }
}
