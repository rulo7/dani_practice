package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_add_users.*

class AddUsersActivity : AppCompatActivity() {

    lateinit var users_list: RecyclerView
    val interactor = factory.interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_users)

        users_list = findViewById<RecyclerView>(R.id.user_list)
        users_list.layoutManager = LinearLayoutManager(this)

        val progressBar: ProgressBar = this.loadingBarAddUser

        progressBar.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            progressBar.visibility = View.GONE
            users_list.adapter = UserAdapter(workers) { position, worker ->
                interactor.removeWorker(worker.id) { success ->
                    if (!success) {
                        Toast.makeText(this, "El trabajador no se ha borrado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "El trabajador se ha borrado con exito.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        saveNewBtn.setOnClickListener {
            var editTextName = findViewById<EditText>(R.id.input_name)
            //Toast.makeText(this, editTextName.text, Toast.LENGTH_SHORT).show()
            var editTextRole = findViewById<EditText>(R.id.input_role)
            //Toast.makeText(this, editTextRole.text, Toast.LENGTH_SHORT).show()

            var workerId = editTextName.text.split(" ")

            val worker = Worker(workerId[0].toLowerCase(), editTextName.text.toString(), editTextRole.text.toString(), "https://www.quohealth.com/static/media/smile.efaf64d3.png")

            interactor.addOrUpdateWorker(worker) { success ->
                if (!success) {
                    Toast.makeText(this, "El trabajador no se ha guardado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "El trabajador se ha guardado con éxito.", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}