package by.gomel.marseille.main.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import java.io.Serializable
import java.util.*

@Entity(tableName="services")
data class Service (
    @ColumnInfo(name="category")
    var category: ServiceCategory,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="minPrice")
    var minPrice: Double,

    @ColumnInfo(name="maxPrice")
    var maxPrice: Double,

    @ColumnInfo(name = "uid")
    @PrimaryKey
    val uid: String = UUID.randomUUID().toString()
): Serializable {
    val price: String
        get() = (if (minPrice < 0) "" else "$minPrice - ") + "$maxPrice Р"
}



enum class ServiceCategory(
        val title: String
) {
    HAIR("Hair"),
    MANICURE("Manicure"),
    PEDICURE("Pedicure"),
    MAKE_UP("Make up"),
    MAGIC_WHITE("Magic white"),
    TOOL_SHARPENING("Tool sharpening")
}


class ServiceCategoryTypeConverter {
    @TypeConverter
    fun toServiceCategory(name: String) = ServiceCategory.valueOf(name)

    @TypeConverter
    fun fromServiceCategory(category: ServiceCategory) = category.name
}