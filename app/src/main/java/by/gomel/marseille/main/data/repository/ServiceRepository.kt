package by.gomel.marseille.main.data.repository

import by.gomel.marseille.main.data.database.ServiceDao
import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory
import io.reactivex.Observable


class ServiceRepository(
        private val serviceDao: ServiceDao
) {
    fun getAll(): Observable<List<Service>> = Observable.fromCallable { serviceDao.getAll()  }

    fun get(vararg serviceIds: String): Observable<List<Service>>
            = Observable.fromCallable { serviceDao.get(*serviceIds) }

    fun findByCategory(category: ServiceCategory): Observable<List<Service>>
            = Observable.fromCallable { serviceDao.findByCategory(category) }

    fun add(vararg services: Service): Observable<Unit> = Observable.fromCallable { serviceDao.insert(*services) }

    fun update(vararg services: Service): Observable<Unit>
            = Observable.fromCallable { serviceDao.update(*services) }

    fun delete(vararg services: Service): Observable<Unit>
            = Observable.fromCallable { serviceDao.delete(*services) }

    fun delete(vararg serviceIds: String): Observable<Unit>
            = Observable.fromCallable { serviceDao.delete(*serviceIds) }

    fun categories(): Observable<List<ServiceCategory>>
            = Observable.fromCallable { ServiceCategory.values().toList() }
}