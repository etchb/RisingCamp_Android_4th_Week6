package com.bhongj.rc_week6.src.login

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bhongj.rc_week6.databinding.ActivityLoginBinding
import com.bhongj.rc_week6.src.splash.SplashActivity
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* init sharedPreferences */
        setLoginData()

        ObjectAnimator.ofFloat(binding.imgMoveBack, View.TRANSLATION_X, -1000f).apply {
            duration = 15000L
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.RESTART
            start()
        }

        binding.btnLoginKakao.setOnClickListener {
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity)) {
                UserApiClient.instance.loginWithKakaoTalk(this@LoginActivity, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this@LoginActivity, callback = callback)
                Log.d("TEST", "로그인 실패")
            }
        }

        binding.btnLoginSkip.setOnClickListener {
            setLoginData()

            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLoginApple.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Log.d("TEST", "연결 끊기 실패", error)
                }
                else {
                    Log.d("TEST", "연결 끊기 성공. SDK에서 토큰 삭제 됨")
                }
            }
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun setLoginData(userId : String? = "defaultId", imageUrl : String? = "defaultImageUrl") {
        val sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        if (userId == "defaultId" || userId == null) {
            editor.putBoolean("isAutoLogin", false)
        } else {
            editor.putBoolean("isAutoLogin", true)
        }
        editor.putString("userId", userId)
        editor.putString("imageUrl", imageUrl)
        editor.apply()
        Log.d("TEST userId", sharedPreferences.getString("userId", "??").toString())
        Log.d("TEST imageUrl", sharedPreferences.getString("imageUrl", "??").toString())
        Log.d("TEST", sharedPreferences.getBoolean("isAutoLogin", false).toString())
    }

    internal val callback : (OAuthToken?, Throwable?) -> Unit = { token, error ->
        if (error != null) {
            Log.d("TEST", "로그인 실패 - $error")
        } else if (token != null) {
            UserApiClient.instance.me { user, error ->
                if (error != null) {
                    Log.d("TEST", "사용자 정보 요청 실패", error)
                    setLoginData()
                }
                else if (user != null) {
                    Log.d("TEST", "사용자 정보 요청 성공" +
                            "\n회원번호: ${user.id}" +
                            "\n이메일: ${user.kakaoAccount?.email}" +
                            "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                            "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
                    setLoginData(user.kakaoAccount?.profile?.nickname, user.kakaoAccount?.profile?.thumbnailImageUrl)

                    val intent = Intent(this, SplashActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                else {
                    Log.d("TEST", "user is null")
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TEST", "onStart()")

        if (intent.getBooleanExtra("reset", false)) {
            setLoginData()
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Log.d("TEST", "연결 끊기 실패", error)
                }
                else {
                    Log.d("TEST", "연결 끊기 성공. SDK에서 토큰 삭제 됨")
                }
            }
            binding.btnLoginSkip.visibility = View.GONE
            binding.btnClose.visibility = View.VISIBLE
        } else {
            binding.btnLoginSkip.visibility = View.VISIBLE
            binding.btnClose.visibility = View.GONE
        }

        val sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)
        Log.d("TEST", sharedPreferences.getBoolean("isAutoLogin", false).toString())
        if (sharedPreferences.getBoolean("isAutoLogin", false)) {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("TEST", "onResume()")
    }
}