package com.vane.android.owlcl.ui.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.FragmentLearnBinding
import com.vane.android.owlcl.model.CourseRepo
import com.vane.android.owlcl.model.courses
import com.vane.android.owlcl.ui.lessons.LessonsSheetFragment
import com.vane.android.owlcl.util.loadListener
import com.vane.android.owlcl.util.transition.DiagonalSlide
import com.vane.android.owlcl.util.transition.MaterialContainerTransition
import java.util.concurrent.TimeUnit

class LearnFragment : Fragment() {

    private val args: LearnFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val course = CourseRepo.getCourse(args.courseId)
        val binding = FragmentLearnBinding.inflate(inflater, container, false).apply {
            this.course = course
            imageLoadListener = loadListener {
                startPostponedEnterTransition()
            }
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
            alsoLikeList.adapter = RelatedAdapter().apply {
                submitList(courses)
            }
        }
//        (childFragmentManager.findFragmentById(R.id.lessons_sheet) as? LessonsSheetFragment)?.let {
//            // it.course = course
//        }
        postponeEnterTransition(1000L, TimeUnit.MILLISECONDS)
        val interp = AnimationUtils.loadInterpolator(
                context,
                android.R.interpolator.fast_out_slow_in
        )
        sharedElementEnterTransition = MaterialContainerTransition(R.id.scroll).apply {
            duration = 400L
            interpolator = interp
        }
//        enterTransition = DiagonalSlide().apply {
//            addTarget(R.id.lessons_sheet)
//            startDelay = 200L
//            duration = 200L
//            interpolator = interp
//        }
//        sharedElementReturnTransition = MaterialContainerTransition().apply {
//            duration = 300L
//            interpolator = interp
//        }
//        returnTransition = DiagonalSlide().apply {
//            addTarget(R.id.lessons_sheet)
//            duration = 100L
//            interpolator = interp
//        }
        return binding.root
    }
}