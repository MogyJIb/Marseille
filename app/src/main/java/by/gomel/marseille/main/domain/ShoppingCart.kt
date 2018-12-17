package by.gomel.marseille.main.domain

import by.gomel.marseille.main.data.models.Service
import java.io.Serializable

class ShoppingCart : Serializable {
    private val services: MutableSet<Service> = mutableSetOf()

    fun add(vararg service: Service) = services.addAll(service)
    fun add(services: MutableList<Service>) = this.services.addAll(services)
    fun clear() = services.clear()
    fun services() = services.toList()
    fun getTotalAmount(): Pair<Double, Double>
            = services.map { it.minPrice }.filter { it > 0 }.sum() to services.map { it.maxPrice }.filter { it > 0 }.sum()

    fun getTotalAmountString() = "${getTotalAmount().first}" +
            if (getTotalAmount().second > 0) " - ${getTotalAmount().second}" else ""
}