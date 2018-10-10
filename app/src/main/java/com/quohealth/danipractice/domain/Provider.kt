package com.quohealth.danipractice.domain

interface Provider {
    fun provideWorkers(): List<Worker>
    fun addOrUpdateWorker(worker: Worker): Boolean
    fun removeWorker(id: String): Boolean
}