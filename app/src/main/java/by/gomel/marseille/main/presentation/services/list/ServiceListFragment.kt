package by.gomel.marseille.main.presentation.services.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.R
import by.gomel.marseille.base.view.BaseFragment
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.presentation.BaseMainFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_service_list.*
import org.koin.android.ext.android.inject


class ServiceListFragment : BaseMainFragment(), ServiceListContract.View {
    override val presenter: ServiceListContract.Presenter by inject()

    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var category: ServiceCategory

    companion object {
        @JvmStatic
        fun newInstance(category: ServiceCategory) = ServiceListFragment().apply {
            arguments = bundleOf("CATEGORY" to category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_service_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Init on menu item click listener */
        bottomBar().replaceMenu(R.menu.service_list_menu)
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_back -> router().navigateUp()
                else -> false
            }
        }

        category = arguments?.getSerializable("CATEGORY") as ServiceCategory

        /* Init adapter and set up recycler view */
        serviceAdapter = ServiceAdapter()

        service_recycler_view.apply {
            adapter = serviceAdapter

            val dividerItemDecoration = DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
        }

        presenter.initServices(category)
    }

    override fun onDestroyView() {
        bottomBar().menu.clear()
        super.onDestroyView()
    }

    override fun updateServices(services: List<Service>) = serviceAdapter.updateItems(services)
}