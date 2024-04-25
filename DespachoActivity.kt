package com.example.semana6


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class DespachoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despacho)

        val editTextPurchaseAmount = findViewById<EditText>(R.id.editTextPurchaseAmount)
        val editTextLatitude = findViewById<EditText>(R.id.editTextLatitude)
        val editTextLongitude = findViewById<EditText>(R.id.editTextLongitude)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        val button = findViewById<Button>(R.id.buttonRegresar)
        button.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        buttonCalculate.setOnClickListener {
            val purchaseAmount = editTextPurchaseAmount.text.toString().toDouble()
            val latitude = editTextLatitude.text.toString().toDouble()
            val longitude = editTextLongitude.text.toString().toDouble()

            // Calcular distancia
            val distancia = calculateDistance(latitude, longitude)

            // Calcular costo despacho
            val costodespacho = calculateDeliveryCost(purchaseAmount, distancia)

            textViewResult.visibility = View.VISIBLE
            textViewResult.text = "Distancia: $distancia km\nCostoDespacho: $$costodespacho"
        }
    }

    private fun calculateDistance(latitude: Double, longitude: Double): Double {
        val R = 6371 // Radio de la Tierra en kilómetros
        val lat1 = Math.toRadians(latitude)
        val lon1 = Math.toRadians(longitude)
        val lat2 = Math.toRadians(-33.43)
        val lon2 = Math.toRadians(-70.65)

        val dLat = lat2 - lat1
        val dLon = lon2 - lon1

        val a = sin(dLat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))

        return R * c
    }

    private fun calculateDeliveryCost(purchaseAmount: Double, distance: Double): Double {
        return when {
            purchaseAmount >= 50000 -> 0.0 // Sin costo
            purchaseAmount in 25000.0..49999.0 -> 150 * distance // $150 pesos por kilómetro
            else -> 300 * distance // $300 pesos por kilómetro
        }
    }
}
