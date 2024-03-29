package com.tarea02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tarea02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegistrar.setOnClickListener{ haceRegistro() }
        binding.btLogin.setOnClickListener{ haceLogin() }
    }

    private fun haceLogin() {
        val email = binding.etCorreo.text.toString()
        val contra = binding.etContra.text.toString()

        auth.signInWithEmailAndPassword(email, contra)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    actualiza(user)
                }else{
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_login),Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }

            }
    }

    private fun haceRegistro() {
        val email = binding.etCorreo.text.toString()
        val contra = binding.etContra.text.toString()

        auth.createUserWithEmailAndPassword(email, contra)
            .addOnCompleteListener(this){ task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    actualiza(user)
                }else{
                    Toast.makeText(baseContext,
                        getString(R.string.msg_fallo_registro),Toast.LENGTH_SHORT).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if(user!=null){
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }

    }

    public override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        actualiza(user)
    }
}