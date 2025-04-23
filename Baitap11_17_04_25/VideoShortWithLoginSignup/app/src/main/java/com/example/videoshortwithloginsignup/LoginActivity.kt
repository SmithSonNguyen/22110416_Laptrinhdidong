package com.example.videoshortwithloginsignup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.videoshortwithloginsignup.databinding.ActivityLoginBinding
import com.example.videoshortwithloginsignup.model.UserModel
import com.example.videoshortwithloginsignup.util.UiUtil
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        FirebaseAuth.getInstance().currentUser?.let {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
        binding.submitBtn.setOnClickListener {
            loginUser()
        }
        binding.goToSignupBtn.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
            finish()
        }

    }

    fun setInProgress(inProgress: Boolean) {
        if (inProgress) {
            binding.progressBar.visibility = View.VISIBLE
            binding.submitBtn.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.submitBtn.visibility = View.VISIBLE
        }
    }

    fun loginUser(){
        val email= binding.emailInput.text.toString()
        val password= binding.passwordInput.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailInput.error = "Invalid Email"
            return
        }
        if(password.length < 6){
            binding.passwordInput.error = "Password length should be greater than 6"
            return
        }

        loginAfterValidation(email, password)
    }

    fun loginAfterValidation(email: String, password: String){
        setInProgress(true)
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnSuccessListener {
            UiUtil.showToast(this,"Login successfully")
            setInProgress(false)
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        }.addOnFailureListener {
            UiUtil.showToast(applicationContext,it.localizedMessage?: "Something went wrong")
            setInProgress(false)

        }
    }
}