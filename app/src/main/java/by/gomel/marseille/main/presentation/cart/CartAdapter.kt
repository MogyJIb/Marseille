package by.gomel.marseille.main.presentation.cart

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.R
import by.gomel.marseille.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.base.recycler.BaseViewHolder
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.utils.extentions.hide
import kotlinx.android.synthetic.main.service_list_item.view.*


class CartAdapter : BaseRecyclerViewAdapter<Service, CartAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_service_list_item, parent, false)
        return CartViewHolder(itemView)
    }

    class CartViewHolder(itemView: View) : BaseViewHolder<Service>(itemView) {
        private val nameTV = itemView.service_name
        private val priceTV = itemView.service_price
        private val descriptionTV = itemView.service_description

        init { descriptionTV.hide() }

        override fun bindData(data: Service) {
            super.bindData(data)

            nameTV.text = data.name
            priceTV.text = data.price
        }
    }
}