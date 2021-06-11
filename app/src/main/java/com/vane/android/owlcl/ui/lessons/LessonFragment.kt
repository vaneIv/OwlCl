package com.vane.android.owlcl.ui.lessons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.FragmentLessonBinding
import com.vane.android.owlcl.model.CourseRepo
import com.vane.android.owlcl.model.lessons

class LessonFragment : Fragment() {

    private val args: LessonFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLessonBinding.inflate(inflater, container, false).apply {
            lesson = lessons.first()
            steps.apply {
                adapter = StepsAdapter(lessons, context)
                smoothScrollToPosition(args.stepNumber)
            }
            collapse.setOnClickListener {
                it.findNavController().popBackStack()
            }
        }
        (childFragmentManager.findFragmentById(R.id.lessons_sheet) as? LessonsSheetFragment)?.let {
            it.course = CourseRepo.getCourse(args.courseId)
        }
        return binding.root
    }
}