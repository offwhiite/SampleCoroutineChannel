package c.offwhite.samplekotlincoroutinechannel

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class MainActivity : AppCompatActivity() {

    // dispatcherはとりあえずActivityに置いているけど、
    // 別のところから供給する方が依存関係的にいいと思います。
    private val dispatcher: Dispatcher = Dispatcher()

    private val actionCreator: ActionCreator by lazy {
        ActionCreator(dispatcher)
    }

    private val store: Store by lazy {
        Store(dispatcher)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // load 実施
        actionCreator.load()

        // ActionCreatorのload()の結果がDispatcherを通じてstoreに返却されているので、storeでレシーブしてtext表示する
        // LiveDataを利用するとよりよい感じでデータ反映できそう。
        GlobalScope.launch {
            val action = store.sendData.receive()
            when (action) {
                is Action.TestActionFinished -> findViewById<TextView>(R.id.textView).text = action.str
            }
        }
    }

}
