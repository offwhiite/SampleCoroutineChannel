package c.offwhite.samplekotlincoroutinechannel

/**
 * Actionクラス
 * - sealed : enum拡張みたいなもの。
 * sealedクラス単体ではインスタンス化できない。
 * またメンバーにはサブクラスを持つことができるので、データクラスも持てる。
 * 今回は「どんな処理かを示しつつデータも渡したい」のでsealed classを使う。
 */
sealed class Action {
    data class TestActionFinished(val str : String): Action()
}