package com.vane.android.owlcl.ui.mycourses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.CourseItemBinding
import com.vane.android.owlcl.model.Course
import com.vane.android.owlcl.model.CourseDiff
import com.vane.android.owlcl.model.CourseId
import com.vane.android.owlcl.util.ShapeAppearanceTransformation

class MyCoursesAdapter : ListAdapter<Course, MyCourseViewHolder>(CourseDiff) {

    private object onClick : CourseViewClick {
        override fun onClick(view: View, courseId: CourseId) {
            val extras = FragmentNavigatorExtras(
                    view to "shared_element"
            )
            val action = MyCoursesFragmentDirections.actionMyCoursesToLearn(courseId)
            view.findNavController().navigate(action, extras)
        }
    }

    private val shapeTransform =
            ShapeAppearanceTransformation(R.style.ShapeAppearance_Owl_SmallComponent)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCourseViewHolder {
        return MyCourseViewHolder(
                CourseItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: MyCourseViewHolder, position: Int) {
        holder.bind(getItem(position), shapeTransform, onClick)
    }

}

interface CourseViewClick {
    fun onClick(view: View, courseId: CourseId)
}

class MyCourseViewHolder(
        private val binding: CourseItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
            course: Course,
            imageTransform: ShapeAppearanceTransformation,
            onClick: CourseViewClick
    ) {
        binding.run {
            this.course = course
            this.clickHandler = onClick
            Glide.with(courseImage)
                    .load(course.thumbUrl)
                    .placeholder(R.drawable.stroked_course_image_placeholder)
                    .transform(imageTransform)
                    .into(courseImage)
            executePendingBindings()
        }
    }
}