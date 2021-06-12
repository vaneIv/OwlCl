package com.vane.android.owlcl.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnNextLayout
import androidx.fragment.app.Fragment
import com.vane.android.owlcl.R
import com.vane.android.owlcl.databinding.FragmentSearchBinding
import com.vane.android.owlcl.model.topics
import com.vane.android.owlcl.util.SpringAddItemAnimator

class SearchFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            searchResults.apply {
                itemAnimator = SpringAddItemAnimator()
                adapter = SearchAdapter().apply {
                    // Add data after layout so that animations run
                    doOnNextLayout {
                        submitList(topics)
                    }
                }
            }
        }
        return binding.root
    }
}