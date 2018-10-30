package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.fragment_list_users.*


class FragmentListUsers : Fragment() {

    private val interactor = factory.interactor
    private lateinit var adapter: WorkersAdapter

    fun loadData() {
        progressBar?.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            progressBar?.visibility = View.GONE
            adapter.items.clear() //Borramos la lista antes de volver a pintarla
            adapter.items.addAll(workers)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_users, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Init the adapter
        //if(canRemove){
        WorkersAdapter(arrayListOf()) { _, worker -> removeWorker(worker.id) }
        //}
        //else
        WorkersAdapter(arrayListOf())


        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        loadData()
    }


    private fun removeWorker(id: String) {
        interactor.removeWorker(id) { success ->
            if (success) {
                Toast.makeText(context, "El trabajador se ha borrado con exito.", Toast.LENGTH_SHORT).show()
                loadData()
            } else {
                Toast.makeText(context, "El trabajador no se ha borrado. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
