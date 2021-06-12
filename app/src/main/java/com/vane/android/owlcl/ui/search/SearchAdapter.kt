package com.vane.android.owlcl.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vane.android.owlcl.databinding.SearchItemBinding
import com.vane.android.owlcl.model.Topic
import com.vane.android.owlcl.model.TopicDiff

class SearchAdapter : ListAdapter<Topic, SearchViewHolder>(TopicDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = SearchItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )

        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class SearchViewHolder(
        private val binding: SearchItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(topic: Topic) {
        binding.run {
            this.topic = topic
            executePendingBindings()
        }
    }
}