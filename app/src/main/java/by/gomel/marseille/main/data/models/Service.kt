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
): Serializable

enum class ServiceCategory {
    HAIR,
    MANICURE,
    PEDICURE,
    MAKE_UP,
    MAGIC_WHITE,
    TOOL_SHARPENING
}

class ServiceCategoryTypeConverter {
    @TypeConverter
    fun toServiceCategory(name: String) = ServiceCategory.valueOf(name)

    @TypeConverter
    fun fromServiceCategory(category: ServiceCategory) = category.name
}