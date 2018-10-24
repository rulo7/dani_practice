package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_add_users.*

class AddUsersActivity : AppCompatActivity() {

    private lateinit var users_list: RecyclerView
    private val interactor = factory.interactor
    private lateinit var workersAdapter: WorkersAdapter

    private var list_of_items = arrayOf("CEO", "CTO", "Android Dev.", "iOS Dev.", "Front-End Dev.", "Design")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_users)

        users_list = findViewById<RecyclerView>(R.id.user_list)
        users_list.layoutManager = LinearLayoutManager(this)
        workersAdapter = WorkersAdapter(arrayListOf()) { position, worker ->
            removeWorker(position, worker.id)
        }
        users_list.adapter = workersAdapter


        /*Spinner*/
        //spinner_role!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        //val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_items)
        // Set layout to use when the list of choices appear
        //aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        //spinner_role!!.setAdapter(aa)
        /*Fin Spinner*/



        saveNewBtn.setOnClickListener {
            val workerId = input_name.text.split(" ")
            //val worker = Worker(workerId[0].toLowerCase(), input_name.text.toString(),input_role.text.toString())
            val worker = Worker(workerId[0].toLowerCase(), input_name.text.toString(), "Role")
            addWorker(worker)
        }


        retrieveWorkers()
    }

    private fun retrieveWorkers() {
        loading.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            loading.visibility = View.GONE
            renderWorkers(workers)
        }
    }

    private fun renderWorkers(workers: List<Worker>) {
        workersAdapter.items.clear()
        workersAdapter.items.addAll(workers)
        workersAdapter.notifyDataSetChanged()
    }

    private fun removeWorker(position: Int, id: String) {
        interactor.removeWorker(id) { success ->
            if (success) {
                Toast.makeText(this, "El trabajador se ha borrado con exito.", Toast.LENGTH_SHORT).show()
                retrieveWorkers()
            } else {
                Toast.makeText(this, "El trabajador no se ha borrado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addWorker(worker: Worker) {
        interactor.addOrUpdateWorker(worker) { success ->
            if (success) {
                Toast.makeText(this, "El trabajador se ha guardado con éxito.", Toast.LENGTH_SHORT).show()
                retrieveWorkers()
            } else {
                Toast.makeText(this, "El trabajador no se ha guardado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}