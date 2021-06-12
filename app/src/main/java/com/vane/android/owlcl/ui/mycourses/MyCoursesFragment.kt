package com.vane.android.owlcl.ui.mycourses

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Px
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.FragmentMyCoursesBinding
import com.vane.android.owlcl.model.courses
import com.vane.android.owlcl.util.SpringAddItemAnimator
import java.util.concurrent.TimeUnit

class MyCoursesFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMyCoursesBinding.inflate(inflater, container, false).apply {
            list.apply {
                itemAnimator = SpringAddItemAnimator()
                addItemDecoration(
                        BottomSpacingItemDecoration(resources.getDimensionPixelSize(R.dimen.grid_2))
                )
                adapter = MyCoursesAdapter().apply {
                    // Add data after layout so that animations run
                    doOnNextLayout {
                        submitList(courses)
                        doOnNextLayout {
                            startPostponedEnterTransition()
                        }
                    }
                }
            }
        }
        postponeEnterTransition(1000L, TimeUnit.MILLISECONDS)
        return binding.root
    }
}

/**
 * A [RecyclerView.ItemDecoration] which adds the given `spacing` to the bottom of any view,
 * unless it is the last item.
 */
class BottomSpacingItemDecoration(
        @Px private val spacing: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        val lastItem = parent.getChildAdapterPosition(view) == state.itemCount - 1
        outRect.bottom = if (!lastItem) spacing else 0
    }
}