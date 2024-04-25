package com.example.semana6

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class MenuActivity : AppCompatActivity() {
    private var fusedLocationClient: FusedLocationProviderClient? = null
    private var databaseReference: DatabaseReference? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val boton = findViewById<Button>(R.id.botonCerrar)
        boton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        val button = findViewById<Button>(R.id.buttonDespacho)
        button.setOnClickListener {
            val intent = Intent(this, DespachoActivity::class.java)
            startActivity(intent)
        }



        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Ubicacion")

        findViewById<View>(R.id.btnGuardarUbicacion).setOnClickListener { v: View? ->
            if (ActivityCompat.checkSelfPermission(
                    this@MenuActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this@MenuActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@MenuActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_LOCATION_PERMISSION
                )
                return@setOnClickListener
            }
            fusedLocationClient!!.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        guardarUbicacionEnFirebase(location.latitude, location.longitude)
                    }
                }
        }
    }



    private fun guardarUbicacionEnFirebase(latitud: Double, longitud: Double) {
        val ubicacionId = databaseReference!!.push().getKey()
        if (ubicacionId != null) {
            val ubicacionRef = databaseReference!!.child(ubicacionId)
            ubicacionRef.child("latitud").setValue(latitud)
            ubicacionRef.child("longitud").setValue(longitud)
                .addOnSuccessListener { aVoid: Void? -> }
                .addOnFailureListener { e: Exception? -> }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido, intenta obtener la ubicación nuevamente
                findViewById<View>(R.id.btnGuardarUbicacion).performClick()
            } else {
                // Permiso denegado, puedes mostrar un mensaje al usuario o realizar otra acción
            }
        }
    }

    companion object {
        private const val REQUEST_LOCATION_PERMISSION = 1
    }

}

