package org.diyorbek.listadapterviewwithrecyclerview_h1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import org.diyorbek.listadapterviewwithrecyclerview_h1.databinding.GamesSampleBinding
import org.diyorbek.listadapterviewwithrecyclerview_h1.model.Games

class GameAdapter :
    androidx.recyclerview.widget.ListAdapter<Games, GameAdapter.GamesViewHolder>(DiffCallBack()) {

    lateinit var onClick:(Games) -> Unit

    private class DiffCallBack : DiffUtil.ItemCallback<Games>() {
        override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem.gameName == newItem.gameName
        }

        override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem == newItem
        }

    }

    inner class GamesViewHolder(private val binding: GamesSampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(games: Games) {
            binding.apply {
                gameImage.setImageResource(games.gameImage)
                gameName.text = games.gameName
                gameDate.text = games.gameDate
            }
            itemView.setOnClickListener {
                onClick.invoke(games)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder(
            GamesSampleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}