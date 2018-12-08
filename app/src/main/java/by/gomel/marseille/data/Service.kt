package by.gomel.marseille.data

@Entity(tableName="Services")
data class Service (
    @ColumnInfo(name="category")
    var category: String,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="minPrice")
    var minPrice: Double,

    @ColumnInfo(name="maxPrice")
    var maxPrice: Double
)