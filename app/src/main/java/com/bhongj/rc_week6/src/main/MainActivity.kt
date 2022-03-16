package com.bhongj.rc_week6.src.main

import android.os.Bundle
import com.bhongj.rc_week6.R
import com.bhongj.rc_week6.config.BaseActivity
import com.bhongj.rc_week6.databinding.ActivityMainBinding
import com.bhongj.rc_week6.src.main.discount.DiscountFragment
import com.bhongj.rc_week6.src.main.issue.IssueFragment
import com.bhongj.rc_week6.src.main.search.SearchFragment
import com.bhongj.rc_week6.src.main.myProfile.MyProfileFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.frmlay_main, SearchFragment()).commitAllowingStateLoss()

        binding.bottomNav.itemIconTintList = null
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener{ it ->
            when (it.itemId) {
                R.id.btm_item_search -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .replace(R.id.frmlay_main, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_discount -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .replace(R.id.frmlay_main, DiscountFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_issue -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .replace(R.id.frmlay_main, IssueFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.btm_item_my_profile -> {
                    supportFragmentManager.beginTransaction()
//                        .setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, androidx.appcompat.R.anim.abc_fade_out)
                        .replace(R.id.frmlay_main, MyProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}