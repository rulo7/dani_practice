package com.quohealth.danipractice.domain

import android.os.Handler
import android.os.Looper
import com.quohealth.danipractice.data.Provider0
import com.quohealth.danipractice.presentation.interactors.WorkersInteractor

class Factory {
    private val responseHandler by lazy { Handler(Looper.getMainLooper()) }

    private val dataProvider by lazy<Provider> { Provider0() }

    val interactor by lazy { WorkersInteractor(responseHandler, dataProvider) }
}

val factory by lazy { Factory() }