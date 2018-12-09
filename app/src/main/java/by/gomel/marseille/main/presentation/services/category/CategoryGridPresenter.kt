package by.gomel.marseille.main.presentation.services.category

import androidx.core.os.bundleOf
import by.gomel.marseille.R
import by.gomel.marseille.base.view.BasePresenter
import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.domain.GetServiceCategoriesUseCase
import io.reactivex.rxkotlin.plusAssign


class CategoryGridPresenter(
        private val getServiceCategoriesUseCase: GetServiceCategoriesUseCase
) : BasePresenter<CategoryGridContract.View>(), CategoryGridContract.Presenter {
    override fun init() {
        disposables += getServiceCategoriesUseCase.getCategoriesFilteredByNameAsync()
                .subscribe({
                    categories -> view?.updateCategories(categories)
                }, this::handleError)
    }

    override fun onCategoryItemClicked(category: ServiceCategory)
            = view?.router()?.navigate(
                    R.id.action_category_grid_to_services,
                    bundleOf("CATEGORY" to category)
            ) ?: Unit
}