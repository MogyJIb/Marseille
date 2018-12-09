package by.gomel.marseille.main.presentation.services.category

import by.gomel.marseille.base.view.BaseContract
import by.gomel.marseille.main.data.models.ServiceCategory

interface CategoryGridContract {
    interface View : BaseContract.View {
        fun updateCategories(categories: List<ServiceCategory>)
    }

    interface Presenter : BaseContract.Presenter {
        fun onCategoryItemClicked(category: ServiceCategory)
    }
}