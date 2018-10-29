package com.quohealth.danipractice.data

import com.quohealth.danipractice.domain.Provider
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.asHasheable

class Provider0 : Provider {
    companion object {
        private val workers = hashMapOf(
                Worker("raul", "Raúl", "GOD", "https://www.quohealth.com/static/media/raul.0d508223.jpg").asHasheable(),
                Worker("danijr", "Daniel Jr.", "Android padawan", "https://www.quohealth.com/static/media/daniel.f9185410.jpg").asHasheable(),
                Worker("alvaro", "Alvaro", "Guard of Raúl", "https://www.quohealth.com/static/media/alvaro.dd28b8e6.jpg").asHasheable(),
                Worker("david", "David", "Guard of the guard", "https://www.quohealth.com/static/media/david.3cbff542.jpg").asHasheable(),
                Worker("beatriz", "Beatriz", "Designer and condescending", "https://www.quohealth.com/static/media/bea.b428952e.jpg").asHasheable(),
                Worker("estefania", "Estefanía", "Designer and Ness spy", "https://www.quohealth.com/static/media/estefi.b75bd369.jpg").asHasheable(),
                Worker("jacobo", "Jacobo", "Marketing manager, head social, first of his name and mother of dragons", "https://www.quohealth.com/static/media/estefi.b75bd369.jpg").asHasheable(),
                Worker("fallero", "Fallero", "Frontend developer and hoonigan driver", "https://www.quohealth.com/static/media/david2.1e8d17ba.jpg").asHasheable(),
                Worker("rafa", "Rafa", "Frontend developer and far away than mordor resident", "https://www.quohealth.com/static/media/rafa.98d00d18.jpg").asHasheable(),
                Worker("daniel", "Daniel", "CTO and really bad singer", "https://www.quohealth.com/static/media/dani.d4c19242.jpg").asHasheable(),
                Worker("gustavo", "Gustavo", "CEO, diabetic master and apple supreme fanboy", "https://www.quohealth.com/static/media/gustavo.1741c2e1.jpg").asHasheable()
        )
    }

    override fun provideWorkers(): List<Worker> {
        Thread.sleep(3000)
        return workers.values.toList()
    }

    override fun addOrUpdateWorker(worker: Worker): Boolean {
        if (generateDelayWithRandomResult(1000)) {
            workers[worker.id] = worker
            return true
        }
        return false
    }

    override fun removeWorker(id: String): Boolean {
        if (generateDelayWithRandomResult(1000)) {
            workers.remove(id)
            return true
        }
        return false
    }

    private fun generateDelayWithRandomResult(delay: Long): Boolean {
        Thread.sleep(delay)
        return System.currentTimeMillis() % 2L == 0L
    }

}

class Provider1 : Provider {
    override fun provideWorkers(): List<Worker> {
        TODO("not implemented")
    }

    override fun addOrUpdateWorker(worker: Worker): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeWorker(id: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}