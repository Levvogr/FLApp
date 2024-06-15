package com.levog.flapp.extension

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.levog.flapp.FLApplication


fun CreationExtras.fLApplication(): FLApplication =
    (this[
        ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY
    ] as FLApplication)

