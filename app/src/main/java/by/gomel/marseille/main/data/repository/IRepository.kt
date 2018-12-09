package by.gomel.marseille.main.data.repository


interface IRepository {
    fun products(): ProductRepository
    fun services(): ServiceRepository
}

