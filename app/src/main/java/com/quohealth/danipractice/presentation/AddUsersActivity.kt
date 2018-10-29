package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_add_users.*


class AddUsersActivity : AppCompatActivity() {

    private lateinit var users_list: RecyclerView
    private val interactor = factory.interactor
    private lateinit var workersAdapter: WorkersAdapter

    private var role_msg: TextView? = null
    private var list_of_roles = arrayOf("CEO", "CTO", "Android Dev.", "iOS Dev.", "Front-End Dev.", "Design", "Social")
    private var userSelectedIndex = 0


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
        //Asociamos la lista de roles con el spinner
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list_of_roles)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_role!!.adapter = arrayAdapter

        //Cogemos el item seleccionado
        spinner_role.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                userSelectedIndex = position
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        /*Fin Spinner*/


        saveNewBtn.setOnClickListener {
            val workerId = input_name.text.split(" ")

            val worker = Worker(workerId[0].toLowerCase(), input_name.text.toString(), list_of_roles.get(userSelectedIndex))
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