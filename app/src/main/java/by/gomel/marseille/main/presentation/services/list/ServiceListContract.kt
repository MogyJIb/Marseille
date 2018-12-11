package by.gomel.marseille.main.presentation.services.list

import by.gomel.marseille.base.view.BaseContract
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory

interface ServiceListContract {
    interface View : BaseContract.View {
        fun updateServices(services: List<Service>)
    }

    interface Presenter : BaseContract.Presenter {
        fun initServices(category: ServiceCategory)
    }
}