package by.gomel.marseille.data

@Entity(tableName="Products")
data class Product (
    @ColumnInfo(name="category")
    var category: String,

    @ColumnInfo(name="name")
    var name: String,

    @ColumnInfo(name="price")
    var price: Double
)