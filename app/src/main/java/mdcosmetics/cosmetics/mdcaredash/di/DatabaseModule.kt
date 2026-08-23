package mdcosmetics.cosmetics.mdcaredash.di

import androidx.room.Room
import mdcosmetics.cosmetics.mdcaredash.data.database.GWBVBDatabase
import org.koin.dsl.module

private const val DB_NAME = "gwbvb_db"

val databaseModule = module {
  single {
    Room.databaseBuilder(context = get(), klass = GWBVBDatabase::class.java, name = DB_NAME).build()
  }

  single { get<GWBVBDatabase>().cartItemDao() }

  single { get<GWBVBDatabase>().orderDao() }
}
