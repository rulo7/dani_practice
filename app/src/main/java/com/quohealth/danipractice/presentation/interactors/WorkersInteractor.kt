package com.quohealth.danipractice.presentation.interactors

import android.os.Handler
import com.quohealth.danipractice.domain.Provider
import com.quohealth.danipractice.domain.Worker
import kotlin.concurrent.thread

class WorkersInteractor(private val responseHandler: Handler,
                        private val provider: Provider) {


    fun retrieveWorkers(onRetrievedListListener: OnRetrievedListListener) {

    }

    fun retrieveWorkers(response: (List<Worker>) -> Unit) {
        thread {
            val users = provider.provideWorkers()
            responseHandler.post {
                response(users)
            }
        }
    }

    fun addOrUpdateWorker(worker: Worker, response: (Boolean) -> Unit) {
        thread {
            val result = provider.addOrUpdateWorker(worker)
            responseHandler.post {
                response(result)
            }
        }
    }

    fun removeWorker(id: String, response: (Boolean) -> Unit) {
        thread {
            val result = provider.removeWorker(id)
            responseHandler.post {
                response(result)
            }
        }
    }
}


interface OnRetrievedListListener {
    fun onSuccess(workers: List<Worker>)
}