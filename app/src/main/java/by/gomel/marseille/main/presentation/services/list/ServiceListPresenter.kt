package by.gomel.marseille.main.presentation.services.list

import by.gomel.marseille.base.view.BasePresenter
import by.gomel.marseille.main.data.models.ServiceCategory


class ServiceListPresenter(
) : BasePresenter<ServiceListContract.View>(), ServiceListContract.Presenter {
    override fun initServices(category: ServiceCategory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init() {
//        disposables += getServiceCategoriesUseCase.getCategoriesFilteredByNameAsync()
//                .subscribe({
//                    categories -> view?.updateCategories(categories)
//                }, this::handleError)
    }


}