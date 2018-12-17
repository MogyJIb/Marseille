package by.gomel.marseille.main.presentation.cart

import by.gomel.marseille.base.view.BaseContract
import by.gomel.marseille.main.data.models.Service


interface CartContract {
    interface View : BaseContract.View {
        fun updateServices(services: List<Service>)
        fun updateTotalAmount(amount: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun onDeleteButtonClicked()
    }
}