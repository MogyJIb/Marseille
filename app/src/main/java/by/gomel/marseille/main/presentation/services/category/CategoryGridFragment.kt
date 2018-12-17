package by.gomel.marseille.main.presentation.services.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.R
import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.presentation.BaseMainFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_category_grid.*
import org.koin.android.ext.android.inject


class CategoryGridFragment : BaseMainFragment(), CategoryGridContract.View {
    override val presenter: CategoryGridContract.Presenter by inject()

    private lateinit var serviceCategoryAdapter: ServiceCategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_category_grid, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Услуги")

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().menu.clear()
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

                    setImageResource(R.drawable.outline_shopping_cart_white_24)
                    bottomBarButton().setOnClickListener { router().navigate(R.id.action_to_cart) }

                    show()
                }
            })
        }

        /* Init adapter and set up recycler view */
        serviceCategoryAdapter = ServiceCategoryAdapter()
        serviceCategoryAdapter.onClickListener = presenter::onCategoryItemClicked

        category_recycler_view.adapter = serviceCategoryAdapter
    }

    override fun updateCategories(categories: List<ServiceCategory>)
            = serviceCategoryAdapter.updateItems(categories)
}