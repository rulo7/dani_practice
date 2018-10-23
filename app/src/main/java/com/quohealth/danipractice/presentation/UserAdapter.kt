package com.quohealth.danipractice.presentation

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.quohealth.danipractice.R
import com.quohealth.danipractice.domain.Worker
import com.quohealth.danipractice.domain.dp
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.users_child.view.*

class UserAdapter(private val items: List<Worker>,
                  private val onRemoveListener: ((Int, Worker) -> Unit)? = null) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_child, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.apply {
            val element = items[position]

            if (onRemoveListener != null) {
                //1. render trash
                trashButton.visibility = View.VISIBLE
                /*removeTrash.setOnClickListener = {
                    onRemoveListener(position,element)
                }*/
            } else {
                trashButton.visibility = View.GONE
            }

            user_name?.text = element.name
            user_role?.text = element.role
            Picasso.get()
                    .load(element.image)
                    .resize(context.dp(80), context.dp(80))
                    .into(user_image)
        }
    }

    companion object
    class UserViewHolder(v: View) : RecyclerView.ViewHolder(v)
}