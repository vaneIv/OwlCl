package com.vane.android.owlcl.ui.learn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vane.android.owlcl.databinding.RelatedCourseItemBinding
import com.vane.android.owlcl.model.Course
import com.vane.android.owlcl.model.CourseDiff

class RelatedAdapter : ListAdapter<Course, RelatedViewHolder>(CourseDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RelatedViewHolder {
        val binding = RelatedCourseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return RelatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RelatedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class RelatedViewHolder(
        private val binding: RelatedCourseItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(course: Course) {
        binding.run {
            this.course = course
            executePendingBindings()
        }
    }
}