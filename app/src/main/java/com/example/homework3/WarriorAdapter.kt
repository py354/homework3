package com.example.homework3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework3.databinding.ElemBinding

class WarriorAdapter: RecyclerView.Adapter<WarriorAdapter.WarriorHolder>() {
    class WarriorHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ElemBinding.bind(item)
        fun bind(warrior: Warrior, position: Int) {
            with(binding) {
                image.setImageResource(warrior.img)
                name.text = warrior.name
            }
            binding.cardView.setOnClickListener {
                val i = Intent(it.context, Info::class.java)
                i.putExtra(WARRIOR_ID_PARAM, position)
                it.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarriorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.elem, parent, false)
        return WarriorHolder(view)
    }

    override fun onBindViewHolder(holder: WarriorHolder, position: Int) {
        holder.bind(Repository.army[position], position)
    }

    override fun getItemCount(): Int {
        return Repository.army.size
    }
}