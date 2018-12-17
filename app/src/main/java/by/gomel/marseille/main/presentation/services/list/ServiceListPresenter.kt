package by.gomel.marseille.main.presentation.services.list

import by.gomel.marseille.base.view.BasePresenter
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.domain.ShoppingCart
import by.gomel.marseille.main.domain.service.GetServicesUseCase
import io.reactivex.rxkotlin.plusAssign


class ServiceListPresenter(
        private val getServicesUseCase: GetServicesUseCase,
        private val shoppingCart: ShoppingCart
) : BasePresenter<ServiceListContract.View>(), ServiceListContract.Presenter {
    override fun initServices(category: ServiceCategory) {
        disposables += getServicesUseCase.getServicesFilteredByNameAsync(category)
                .subscribe({
                    services -> view?.updateServices(services)
                }, this::handleError)
    }

    override fun onAddServiceClick(service: Service) {
        shoppingCart.add(service)
        view?.toast("\"${service.name}\" добавлено в корзину")
    }
}