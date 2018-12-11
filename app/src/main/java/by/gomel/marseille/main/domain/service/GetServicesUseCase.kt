package by.gomel.marseille.main.domain.service

import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory
import by.gomel.marseille.main.data.repository.IRepository
import by.gomel.marseille.utils.extentions.async
import io.reactivex.Observable

class GetServicesUseCase(
        private val repository: IRepository
) {
    fun getServicesFilteredByNameAsync(category: ServiceCategory): Observable<List<Service>>
            = repository.services().get(category)
            .flatMap { list ->
                Observable.fromIterable(list)
                        .sorted(compareBy { service -> service.name })
                        .toList()
                        .toObservable()
            }
            .onErrorReturn { emptyList() }
            .async()
}