package c.offwhite.samplekotlincoroutinechannel

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class Dispatcher {

    // Actionからデータを送るChannel
    private val actions = BroadcastChannel<Action>(Channel.CONFLATED)

    // StoreがこのChannelを購読する
    val receiveChannel : ReceiveChannel<Action> = actions.openSubscription()

    fun launchAndDispatch(action: Action) {
        GlobalScope.launch {
            actions.send(action)
        }
    }
}