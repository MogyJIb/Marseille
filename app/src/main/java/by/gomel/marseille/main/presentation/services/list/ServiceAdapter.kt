package by.gomel.marseille.main.presentation.services.list

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.R
import by.gomel.marseille.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.base.recycler.BaseViewHolder
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.utils.extentions.hide
import kotlinx.android.synthetic.main.service_list_item.view.*


class ServiceAdapter : BaseRecyclerViewAdapter<Service, ServiceAdapter.ServiceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.service_list_item, parent, false)
        return ServiceViewHolder(itemView)
    }

    class ServiceViewHolder(itemView: View) : BaseViewHolder<Service>(itemView) {
        private val nameTV = itemView.service_name
        private val priceTV = itemView.service_price
        private val descriptionTV = itemView.service_description
        private val buttomAddToPurchase = itemView.button_add_purchase

        init { descriptionTV.hide() }

        override fun bindData(data: Service) {
            super.bindData(data)

            nameTV.text = data.name
            priceTV.text = data.price
        }
    }
}