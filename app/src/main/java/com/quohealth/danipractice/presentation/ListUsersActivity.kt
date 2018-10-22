package com.quohealth.danipractice.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.factory
import kotlinx.android.synthetic.main.activity_list_users.*

class ListUsersActivity : AppCompatActivity() {

    lateinit var users_list: RecyclerView
    //var users:MutableList<String> = ArrayList()

    val interactor = factory.interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        //loadData()
        users_list = findViewById<RecyclerView>(R.id.user_list)
        users_list.layoutManager = LinearLayoutManager(this)

        val progressBar: ProgressBar = this.loadingBar

        progressBar.visibility = View.VISIBLE
        interactor.retrieveWorkers { workers ->
            progressBar.visibility = View.GONE
            //users_list.adapter = UserAdapter(workers, this)
            users_list.adapter = UserAdapter(workers)
        }

    }

    /*class UserAdapter(items: List<Worker>, ctx: Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

        var list = items
        var context = ctx

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.users_child, parent, false))
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            holder.itemView.apply {
                user_name?.text = list.get(position).name
                user_role?.text = list.get(position).role
                Picasso.get()
                        .load(list.get(position).image)
                        .resize(context.dp(80), context.dp(80))
                        .into(user_image)
            }
        }

        class UserViewHolder(v: View) : RecyclerView.ViewHolder(v)
    }*/
}