package by.gomel.marseille.base.view

import androidx.fragment.app.Fragment
import by.gomel.marseille.utils.extentions.findNavController
import by.gomel.marseille.utils.extentions.hideKeyboard
import by.gomel.marseille.utils.extentions.log

abstract class BaseFragment: Fragment(), BaseContract.View {
    protected open val presenter: BaseContract.Presenter? = null

    override fun router() = view!!.findNavController()

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun onResume() {
        super.onResume()
        presenter?.bind(this)
        javaClass.log("onResume")
    }

    override fun onPause() {
        presenter?.unbind()
        activity?.hideKeyboard()
        super.onPause()
        javaClass.log("onPause")
    }

    override fun onStart() {
        super.onStart()
        javaClass.log("onStart")
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