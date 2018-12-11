package by.gomel.marseille.base.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.gomel.marseille.utils.extentions.findNavController
import by.gomel.marseille.utils.extentions.hideKeyboard
import by.gomel.marseille.utils.extentions.log

abstract class BaseFragment: Fragment(), BaseContract.View {
    protected open val presenter: BaseContract.Presenter? = null

    override fun router() = view!!.findNavController()

    override fun context() = context
            ?: throw NullPointerException("Class ${this.javaClass.simpleName} context is null")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.bind(this)
    }

    override fun onDestroyView() {
        presenter?.unbind()
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        javaClass.log("onResume")
    }

    override fun onPause() {
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