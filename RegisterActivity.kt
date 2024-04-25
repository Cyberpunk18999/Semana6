package com.example.semana6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()

        val registerButton = findViewById<Button>(R.id.buttonRegister)
        registerButton.setOnClickListener {
            registerUser()
        }
        val button = findViewById<Button>(R.id.botonLogin)
        button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser() {
        val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor llena los campos", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear usuario con auntenticacion Firebase
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, store user data in Realtime Database
                    val user = auth.currentUser
                    val userId = user?.uid
                    userId?.let {
                        val userRef = database.reference.child("Usuarios").child(it)
                        userRef.child("email").setValue(email)
                        userRef.child("password").setValue(password)
                    }

                    // Abrir MenuActivity
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Si falla el usuario, saltara el siguiente mensaje.
                    Toast.makeText(baseContext, "Registro Fallido.", Toast.LENGTH_SHORT).show()
                }


            }
    }
}
