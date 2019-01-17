package c.offwhite.samplekotlincoroutinechannel

import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class Store(val dispatcher: Dispatcher) {
    val sendData = dispatcher.receiveChannel
}