package by.gomel.marseille

import by.gomel.marseille.main.data.database.DatabaseApi
import by.gomel.marseille.main.data.repository.IRepository
import by.gomel.marseille.main.data.repository.RepositoryApi
import by.gomel.marseille.main.domain.ShoppingCart
import by.gomel.marseille.main.domain.service.GetServiceCategoriesUseCase
import by.gomel.marseille.main.domain.service.GetServicesUseCase
import by.gomel.marseille.main.presentation.services.category.CategoryGridContract
import by.gomel.marseille.main.presentation.services.category.CategoryGridPresenter
import by.gomel.marseille.main.presentation.cart.CartContract
import by.gomel.marseille.main.presentation.cart.CartPresenter
import by.gomel.marseille.main.presentation.services.list.ServiceListContract
import by.gomel.marseille.main.presentation.services.list.ServiceListPresenter
import by.gomel.marseille.main.presentation.splash.view.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
    single { ShoppingCart() }
}

val domainModule = module {
    single { GetServiceCategoriesUseCase(get()) }
    single { GetServicesUseCase(get()) }
}

val splashModule = module {
    factory { SplashPresenter(get()) }
}

val serviceModule = module {
    factory { CategoryGridPresenter(get()) as CategoryGridContract.Presenter }
    factory { CartPresenter(get()) as CartContract.Presenter }
    factory { ServiceListPresenter(get(), get()) as ServiceListContract.Presenter }
}