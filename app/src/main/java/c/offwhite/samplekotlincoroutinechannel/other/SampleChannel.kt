package c.offwhite.samplekotlincoroutinechannel.other

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SampleChannel {

    fun getValue() = runBlocking {
        var value = ""

        //sampleStart
        val channel = Channel<Int>()

        // 5回sendするが、非同期処理のため処理を待たないで次に行く
        launch {
            for (x in 1..5) channel.send(x * x)
        }
        // receive()は一つずつsendされた情報を受け取る
        // なお、ここで中断されるため、sendされない限り次の処理に進まない。非同期でないところに注意。
        repeat(5) {
            value += channel.receive()
            value += System.lineSeparator()
        }
        println("Done!")
    }

    fun CoroutineScope.produceSquares(): ReceiveChannel<Int> = produce {
        for (x in 1..5) send(x * x)
    }

    fun main() = runBlocking {
        //sampleStart
        val squares = produceSquares()
        squares.consumeEach { println(it) }
        println("Done!")
//sampleEnd
    }

}