package com.example.looseteeth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var cardv:CardView
    private lateinit var cards:CardView
    private lateinit var cardc:CardView
    private lateinit var stockb:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cardc = findViewById(R.id.chocolateCardView)
        cardv = findViewById(R.id.vanillaCardView)
        cards = findViewById(R.id.strawberryCardView)

        cardc.setOnClickListener {
            var intent = Intent(this, chocolateActivity::class.java)
            startActivity(intent)
        }
        cards.setOnClickListener {
            var intent = Intent(this, strawberryActivity::class.java)
            startActivity(intent)
        }
        cardv.setOnClickListener {
            var intent = Intent(this, vanillaActivity::class.java)
            startActivity(intent)
        }
        stockb.setOnClickListener {
            var intent = Intent(this,stockActivity::class.java)
            startActivity(intent)
        }





    }


}