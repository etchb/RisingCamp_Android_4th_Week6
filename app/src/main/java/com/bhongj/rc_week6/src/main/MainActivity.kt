package com.bhongj.rc_week6.src.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.ApplicationClass
import com.bhongj.rc_week6.config.BaseActivity
import com.bhongj.rc_week6.databinding.ActivityMainBinding
import com.bhongj.rc_week6.src.main.discount.DiscountFragment
import com.bhongj.rc_week6.src.main.issue.IssueFragment
import com.bhongj.rc_week6.src.main.myProfile.MyKakaoProfileFragment
import com.bhongj.rc_week6.src.main.myProfile.MyProfileFragment
import com.bhongj.rc_week6.src.main.search.SearchFragment


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    var backKeyPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bottomNav.itemIconTintList = null

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val fragmentList = arrayListOf<Fragment>()

        if (ApplicationClass.sSharedPreferences.getBoolean("isAutoLogin", false)) {
            fragmentList.addAll(arrayListOf<Fragment>(SearchFragment(binding.bottomNav), DiscountFragment(), IssueFragment(), MyKakaoProfileFragment()))
        } else {
            fragmentList.addAll(arrayListOf<Fragment>(SearchFragment(binding.bottomNav), DiscountFragment(), IssueFragment(), MyProfileFragment()))
        }

        for (fragment in fragmentList) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frmlay_main, fragment)
                .hide(fragment)
                .commitAllowingStateLoss()
        }
        supportFragmentManager.beginTransaction()
            .show(fragmentList[0])
            .commitAllowingStateLoss()
        var showFragment = fragmentList[0]

        binding.bottomNav.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.btm_item_search -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .show(fragmentList[0])
                        .hide(showFragment)
                        .commitAllowingStateLoss()
                    showFragment = fragmentList[0]
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_discount -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .show(fragmentList[1])
                        .hide(showFragment)
                        .commitAllowingStateLoss()
                    showFragment = fragmentList[1]
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_issue -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .show(fragmentList[2])
                        .hide(showFragment)
                        .commitAllowingStateLoss()
                    showFragment = fragmentList[2]
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_my_profile -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .show(fragmentList[3])
                        .hide(showFragment)
                        .commitAllowingStateLoss()
                    showFragment = fragmentList[3]
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.bottomNav.visibility == View.GONE) {
            binding.bottomNav.visibility = View.VISIBLE
        } else {
            if (System.currentTimeMillis() > backKeyPressedTime + 1000) {
                backKeyPressedTime = System.currentTimeMillis()
                showCustomToast("뒤로가기 버튼을 한번 더 누르면 종료합니다.")
                return
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 1000) {
                finish()
            }
        }
    }
}