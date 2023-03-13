import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {

    /**
     * Hello
     * main @coroutine#1
     * World!
     * main @coroutine#2
     */
    // thread 차단 없이 새로운 코루틴 동작
    launch {
        // Thread.sleep(500) 과 동작은 유사하나 스레드를 차단하지 않고 일시 중단
        delay(500)

        println("World!")
        println(Thread.currentThread().name)
    }

    println("Hello")
    println(Thread.currentThread().name)

    ///////////////////////////////////////////////////////////////////

    val job1 = launch {
        val measureTimeMillis = measureTimeMillis {
            delay(150)
        }
        println("async task 1 $measureTimeMillis ms")
    }
    job1.cancel()

    val job2 = launch(start = CoroutineStart.LAZY) {
        val measureTimeMillis = measureTimeMillis {
            delay(100)
        }
        println("async task 2 $measureTimeMillis ms")
    }

    println("job1.isActive : ${job1.isActive}")
    println("job2.isActive : ${job2.isActive}")

    println("job2 start")
    job2.start()
}