package by.gomel.marseille.main.data.repository

import by.gomel.marseille.main.data.database.DatabaseApi

class RepositoryApi(
        private val db: DatabaseApi
) : IRepository {
    override fun products() = ProductRepository(db.productDao())
    override fun services() = ServiceRepository(db.serviceDao())
}