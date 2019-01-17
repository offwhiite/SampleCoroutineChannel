package c.offwhite.samplekotlincoroutinechannel

import kotlinx.coroutines.ExperimentalCoroutinesApi

// まだChannelって実験段階なので、アノテーションで実験段階APIって書いてあげる必要があるみたい。
@ExperimentalCoroutinesApi
class ActionCreator(val dispatcher: Dispatcher) {
    fun load() {
        dispatcher.launchAndDispatch(Action.TestActionFinished("Test"))
    }
}