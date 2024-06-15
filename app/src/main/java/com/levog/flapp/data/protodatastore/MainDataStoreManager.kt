package com.levog.flapp.data.protodatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


private val Context.counterDataStore:
        DataStore<Preferences> by preferencesDataStore(
    ConstantsDataStore.MAIN_DATA_STORE
        )

class MainDataStoreManager(private val context: Context) {
    suspend fun saveIsAuthenticatedValue(isAuthenticated: Boolean){
        context.counterDataStore.edit { pref ->
            pref[booleanPreferencesKey(
                ConstantsDataStore.IS_AUTHENTICATED_BOOLEAN_VALUE
            )] = isAuthenticated
        }
    }

    fun getIsAuthenticatedValue() =
        context.counterDataStore.data.map { pref ->
        return@map pref[booleanPreferencesKey(
            ConstantsDataStore.IS_AUTHENTICATED_BOOLEAN_VALUE
        )] ?: false
    }
}