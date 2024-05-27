import kotlin.test.Test
import kotlinx.datetime.Clock

class MyTest {

    @Test
    fun test() {
        println("Current time: ${Clock.System.now()}")
    }
}
