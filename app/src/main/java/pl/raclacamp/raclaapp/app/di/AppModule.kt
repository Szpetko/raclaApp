package pl.raclacamp.raclaapp.app.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pl.raclacamp.raclaapp.app.RaclaApp
import pl.raclacamp.raclaapp.data.repository.ArtistRepositoryImpl
import pl.raclacamp.raclaapp.domain.repository.ArtistRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApplication(): RaclaApp {
        return RaclaApp()
    }

    @Provides
    @Singleton
    fun providesFireStoreInstance(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun providesArtistRepository(db: FirebaseFirestore): ArtistRepository{
        return ArtistRepositoryImpl(db)
    }
}