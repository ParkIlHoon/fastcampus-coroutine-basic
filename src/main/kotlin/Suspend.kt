import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    doSomething()
}

/**
 * suspend fun -> fun : O
 * fun -> suspend fun : X
 */
suspend fun doSomething() = coroutineScope {

    launch {
        delay(200)
        println("World")
    }
    launch {
        printHello()
    }
}

fun printHello() = println("Hello")