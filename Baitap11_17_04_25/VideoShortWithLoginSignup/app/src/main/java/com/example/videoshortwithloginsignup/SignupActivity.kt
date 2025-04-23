package com.example.videoshortwithloginsignup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.videoshortwithloginsignup.databinding.ActivitySignupBinding
import com.example.videoshortwithloginsignup.model.UserModel
import com.example.videoshortwithloginsignup.util.UiUtil
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import org.intellij.lang.annotations.Pattern

class SignupActivity : AppCompatActivity() {
    lateinit var binding : ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.submitBtn.setOnClickListener {
            signupUser()
        }
        binding.goToLoginBtn.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
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

    fun signupUser(){
        val email= binding.emailInput.text.toString()
        val password= binding.passwordInput.text.toString()
        val confirmPassword= binding.confirmPasswordInput.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.emailInput.error = "Invalid Email"
            return
        }
        if(password.length < 6){
            binding.passwordInput.error = "Password length should be greater than 6"
            return
        }
        if(password != confirmPassword){
            binding.confirmPasswordInput.error = "Password does not match"
            return
        }
        signUpAfterValidation(email, password)
    }

    fun signUpAfterValidation(email: String, password: String){
        setInProgress(true)
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            it.user?.let {user->
                val userModel = UserModel( user.uid,email,email.substringBefore("@") )
                Firebase.firestore.collection("users")
                    .document(user.uid)
                    .set(userModel).addOnSuccessListener {
                        UiUtil.showToast(applicationContext,"Account created successfully")
                        setInProgress(false)
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
            }
        }.addOnFailureListener {
            UiUtil.showToast(applicationContext,it.localizedMessage?: "Something went wrong")
            setInProgress(false)

        }
    }
}
