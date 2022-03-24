package by.example.briefcases.di

import android.content.Context
import by.example.briefcases.data.repository.RepositoryImpl
import by.example.briefcases.data.storage.local.BriefcaseDataBase
import by.example.briefcases.data.storage.local.LocalDAO
import by.example.briefcases.data.storage.local.LocalStorage
import by.example.briefcases.data.storage.local.LocalStorageImpl
import by.example.briefcases.data.storage.remote.CategoryApi
import by.example.briefcases.data.storage.remote.RemoteStorage
import by.example.briefcases.data.storage.remote.RemoteStorageImp
import by.example.briefcases.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRemoteStorage(categoryApi: CategoryApi): RemoteStorage {
        return RemoteStorageImp(categoryApi)
    }

    @Provides
    @Singleton
    fun provideLocalStorage(localDAO: LocalDAO): LocalStorage {
        return LocalStorageImpl(localDAO)
    }

    @Singleton
    @Provides
    fun provideRepository(localStorage: LocalStorage, remoteStorage: RemoteStorage): Repository {
        return RepositoryImpl(localStorage,remoteStorage)
    }

    @Singleton
    @Provides
    fun provideBriefcaseDatabase(
        @ApplicationContext app: Context
    ) = BriefcaseDataBase.getBriefcaseDatabase(app)

    @Singleton
    @Provides
    fun provideLocalDao(db: BriefcaseDataBase) = db.localDAO()

}