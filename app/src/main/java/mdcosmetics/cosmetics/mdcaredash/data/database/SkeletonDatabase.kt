package mdcosmetics.cosmetics.mdcaredash.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import mdcosmetics.cosmetics.mdcaredash.data.dao.CartItemDao
import mdcosmetics.cosmetics.mdcaredash.data.dao.OrderDao
import mdcosmetics.cosmetics.mdcaredash.data.database.converter.Converters
import mdcosmetics.cosmetics.mdcaredash.data.entity.CartItemEntity
import mdcosmetics.cosmetics.mdcaredash.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GWBVBDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}