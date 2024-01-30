package com.example.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memo.databinding.ItemWordBinding

class WordAdapter(
    private val list: MutableList<Word>,
    private val itemClickListenr: ItemCLickListenr? = null
) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemWordBinding.inflate(inflater, parent, false)

        return WordViewHolder(binding)
    }


    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = list[position]
        holder.bind(word)
        holder.itemView.setOnClickListener {
            itemClickListenr?.onClick(word)
        }
    }

    class WordViewHolder(private val binding: ItemWordBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(word: Word) {
            binding.apply {
                textTextView.text = word.text
                meanTextVIew.text = word.mean
                typeChip.text = word.type
            }

        }
    }

    interface ItemCLickListenr {
        fun onClick(word: Word)
    }
}