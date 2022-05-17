package cn.xiaofengkj.fitpr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.xiaofengkj.fitpr.R

class ExperienceAdapter(): RecyclerView.Adapter<ExperienceAdapter.GameViewHolder>() {

    var listGame = arrayListOf<String>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    interface ClickItem{
        fun onClickItem(position: Int)
    }


    inner class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvExpereicne = itemView.findViewById<TextView>(R.id.tvExpereicne)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.experience_item, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.tvExpereicne.text = listGame[position]
    }

    override fun getItemCount() = listGame.size
}