import kotlin.test.Test
import kotlinx.datetime.Clock

class MyTest {

    @Test
    fun test() {
        // The dependency kotlinx.datetime.Clock is not available now

        // Try to comment the plugin apollo in build.gradle.kts (line 6 & 62-66)
        // Then, the dependency kotlinx.datetime.Clock will be available
        println("Current time: ${Clock.System.now()}")
    }
}
