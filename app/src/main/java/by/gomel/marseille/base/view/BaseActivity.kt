package by.gomel.marseille.base.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import by.gomel.marseille.utils.extentions.log

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {
    override fun context() = this

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        javaClass.log("onCreate")
    }

    override fun onStart() {
        super.onStart()
        javaClass.log("onStart")
    }

    override fun onResume() {
        super.onResume()
        javaClass.log("onResume")
    }

    override fun onPause() {
        super.onPause()
        javaClass.log("onPause")
    }

    override fun onStop() {
        super.onStop()
        javaClass.log("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        javaClass.log("onDestroy")
    }
}