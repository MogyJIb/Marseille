package by.gomel.marseille.main.presentation.splash.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.R
import by.gomel.marseille.base.view.BaseContract
import by.gomel.marseille.base.view.BaseFragment
import org.koin.android.ext.android.inject


class SplashFragment : BaseFragment(), BaseContract.View {
    override val presenter: SplashPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_splash, container, false)
}
