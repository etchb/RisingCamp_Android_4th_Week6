package com.bhongj.rc_week6.src.main.discount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentDiscountBinding
import com.bhongj.rc_week6.databinding.FragmentIssueBinding

class DiscountFragment :
    BaseFragment<FragmentDiscountBinding>(FragmentDiscountBinding::bind, R.layout.fragment_issue) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}