package by.gomel.marseille.main.domain.service

import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.data.repository.IRepository
import by.gomel.marseille.utils.extentions.async
import io.reactivex.Observable

class GetServiceCategoriesUseCase(
        private val repository: IRepository
) {
    fun getCategoriesFilteredByNameAsync(): Observable<List<ServiceCategory>>
            = repository.services().categories()
                    .flatMap { list ->
                        Observable.fromIterable(list)
                                .sorted(compareBy { category -> category.name })
                                .toList()
                                .toObservable()
                    }
                    .onErrorReturn { emptyList() }
                    .async()
}