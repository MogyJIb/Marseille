package by.gomel.marseille.main.presentation.cart

import by.gomel.marseille.base.view.BasePresenter
import by.gomel.marseille.main.domain.ShoppingCart
import by.gomel.marseille.utils.extentions.async
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class CartPresenter(
        private val shoppingCart: ShoppingCart
) : BasePresenter<CartContract.View>(), CartContract.Presenter {
    override fun init() {
        disposables += Observable.just(shoppingCart.services())
                .async()
                .subscribe({
                    services -> view?.updateServices(services)
                }, this::handleError)

        disposables += Observable.just(shoppingCart.getTotalAmountString())
                .async()
                .subscribe({
                    amount -> view?.updateTotalAmount(amount)
                }, this::handleError)
    }

    override fun onDeleteButtonClicked() {
        shoppingCart.clear()
        view?.updateServices(emptyList())
        view?.updateTotalAmount("0.0 P")
    }
}