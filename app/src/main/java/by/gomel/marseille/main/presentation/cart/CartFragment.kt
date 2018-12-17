package by.gomel.marseille.main.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.R
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.presentation.BaseMainFragment
import by.gomel.marseille.utils.extentions.hide
import by.gomel.marseille.utils.extentions.show
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.android.ext.android.inject


class CartFragment : BaseMainFragment(), CartContract.View {
    override val presenter: CartContract.Presenter by inject()

    private lateinit var cartAdapter: CartAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_cart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Корзина")

        /* Init bottom app bar with button */
        bottomBarButton().run {
            hide(object : FloatingActionButton.OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    bottomBar().replaceMenu(R.menu.cart_menu)
                    bottomBar().fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END

                    setImageResource(R.drawable.outline_arrow_back_ios_white_24)
                    bottomBarButton().setOnClickListener { router().navigateUp() }

                    show()
                }
            })
        }

        /* Init on menu item click listener */
        bottomBar().setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> {
                    presenter.onDeleteButtonClicked()
                    true
                }
                else -> false
            }
        }

        /* Init adapter and set up recycler view */
        cartAdapter = CartAdapter()

        cart_recycler_view.apply {
            adapter = cartAdapter

            val dividerItemDecoration = DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL)
            ContextCompat.getDrawable(context(), R.drawable.list_divider)?.let {
                dividerItemDecoration.setDrawable(it)
            }
            addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onDestroyView() {
        bottomBar().menu.clear()
        super.onDestroyView()
    }

    override fun updateServices(services: List<Service>) {
            if (services.isEmpty())
            empty_view.show()
        else
            empty_view.hide()

        cartAdapter.updateItems(services)
    }

    override fun updateTotalAmount(amount: String) { amount_text_view.text = amount }
}