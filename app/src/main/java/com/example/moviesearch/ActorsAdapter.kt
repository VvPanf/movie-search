package com.example.moviesearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ActorsAdapter (
    private val actors: List<Actor>
) : RecyclerView.Adapter<ActorsAdapter.ActorViewHolder>() {
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getItemCount(): Int = actors.size
    private fun getItem(position: Int): Actor = actors[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ActorViewHolder(view: View) : ViewHolder(view) {
        private val name: TextView = itemView.findViewById(R.id.name_actor)
        private val image: ImageView = itemView.findViewById(R.id.image_actor)

        fun bind(actor: Actor) {
            val idField = R.drawable::class.java.getDeclaredField(actor.image)
            this.image.setImageResource(idField.getInt(idField))
            this.name.text = actor.name
        }
    }
}