package com.example.lab_ws.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_ws.R
import com.example.lab_ws.output.output


class UserAdapter(val users: List<output>): RecyclerView.Adapter<UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recycler_line,
            parent, false)
        return UsersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position])
    }
}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
    private val name: TextView = itemView.findViewById(R.id.text1)
    private val email:TextView = itemView.findViewById(R.id.text2)
    private val city:TextView = itemView.findViewById(R.id.text3)

    fun bind(user: output) {
        name.text = user.name.nativeName.por.common
        city.text = user.currencies.EUR.symbol
        email.text = user.capital
    }
}