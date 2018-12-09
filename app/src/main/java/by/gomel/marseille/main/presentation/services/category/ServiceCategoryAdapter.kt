package by.gomel.marseille.main.presentation.services.category

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.R
import by.gomel.marseille.base.recycler.BaseRecyclerViewAdapter
import by.gomel.marseille.base.recycler.BaseViewHolder
import by.gomel.marseille.main.data.models.ServiceCategory
import kotlinx.android.synthetic.main.service_category_grid_item.view.*


class ServiceCategoryAdapter : BaseRecyclerViewAdapter<ServiceCategory, ServiceCategoryAdapter.ServiceCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.service_category_grid_item, parent, false)
        return ServiceCategoryViewHolder(itemView)
    }

    class ServiceCategoryViewHolder(itemView: View) : BaseViewHolder<ServiceCategory>(itemView) {
        private val nameTV = itemView.name_text_view

        override fun bindData(data: ServiceCategory) {
            super.bindData(data)
            nameTV.text = data.title
        }
    }
}