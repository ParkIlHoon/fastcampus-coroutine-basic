import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        println("Hello")
        // VM Options에 `-Dkotlinx.coroutines.debug` 추가해야 코루틴 정보 출력됨
        println(Thread.currentThread().name)
    }

    println("World")
    println(Thread.currentThread().name)
}