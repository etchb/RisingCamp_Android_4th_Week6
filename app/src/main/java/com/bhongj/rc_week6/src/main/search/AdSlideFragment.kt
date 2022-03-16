package com.bhongj.rc_week6.src.main.search

import android.os.Bundle
import android.view.View
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentAdSlideBinding

class AdSlideFragment(val image: Int) :
    BaseFragment<FragmentAdSlideBinding>(FragmentAdSlideBinding::bind, R.layout.fragment_ad_slide) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgAdSlide.setImageResource(image)
    }
}