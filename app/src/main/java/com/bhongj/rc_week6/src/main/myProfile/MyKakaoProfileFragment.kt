package com.bhongj.rc_week6.src.main.myProfile

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.ApplicationClass.Companion.sSharedPreferences
import com.bhongj.rc_week6.config.BaseFragment
import com.bhongj.rc_week6.databinding.FragmentMyKakaoProfileBinding
import com.bhongj.rc_week6.src.login.LoginActivity
import com.bumptech.glide.Glide

class MyKakaoProfileFragment :
    BaseFragment<FragmentMyKakaoProfileBinding>(
        FragmentMyKakaoProfileBinding::bind,
        R.layout.fragment_my_kakao_profile
    ) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoLoginPage.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            intent.putExtra("reset", true)
            startActivity(intent)
        }

        Glide.with(requireActivity())
            .load(sSharedPreferences.getString("imageUrl", "defaultImageUrl"))
            .into(binding.imgMe)
        binding.txtName.text = sSharedPreferences.getString("userId", "defaultId")
    }
}