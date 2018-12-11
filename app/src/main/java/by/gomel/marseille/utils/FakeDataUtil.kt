package by.gomel.marseille.utils

import by.gomel.marseille.main.data.models.Service
import by.gomel.marseille.main.data.models.ServiceCategory


fun fakeServices() = listOf(
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр",
                minPrice = -1.0,
                maxPrice = 12.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + лак",
                minPrice = -1.0,
                maxPrice = 16.50),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак",
                minPrice = -1.0,
                maxPrice = 28.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Маникюр + гельлак + френч",
                minPrice = -1.0,
                maxPrice = 33.0),
        Service(category = ServiceCategory.MANICURE,
                name = "Снятие гельлака",
                minPrice = -1.0,
                maxPrice = 5.0)
)

