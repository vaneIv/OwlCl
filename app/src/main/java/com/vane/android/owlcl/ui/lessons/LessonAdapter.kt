package com.vane.android.owlcl.ui.lessons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vane.android.owlcl.databinding.LessonItemBinding
import com.vane.android.owlcl.model.Lesson
import com.vane.android.owlcl.model.LessonDiff

class LessonAdapter(
        private val onClick: (Int) -> Unit
) : ListAdapter<Lesson, LessonViewHolder>(LessonDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = LessonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = LessonViewHolder(binding)
        binding.root.setOnClickListener {
            onClick(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class LessonViewHolder(
        private val binding: LessonItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lesson: Lesson) {
        binding.run {
            this.lesson = lesson
            executePendingBindings()
        }
    }
}