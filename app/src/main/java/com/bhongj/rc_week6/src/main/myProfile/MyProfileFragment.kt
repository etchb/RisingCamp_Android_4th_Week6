package com.bhongj.rc_week6.src.main.myProfile

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentMyProfileBinding
import com.bhongj.rc_week6.src.login.LoginActivity

class MyProfileFragment :
    BaseFragment<FragmentMyProfileBinding>(FragmentMyProfileBinding::bind, R.layout.fragment_my_profile) {
    private var mCount = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoLoginPage.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.putExtra("reset", true)
            startActivity(intent)
        }
    }
}