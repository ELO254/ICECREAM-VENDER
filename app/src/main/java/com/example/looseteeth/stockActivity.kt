package com.example.looseteeth

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class stockActivity : AppCompatActivity() {

    private lateinit var f: FirebaseFirestore
    private lateinit var te: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        f = FirebaseFirestore.getInstance()
        te = findViewById(R.id.textView)

        f.collection("icecream")
            .get()
            .addOnSuccessListener { documents ->
                val quantities = StringBuilder()
                for (document in documents) {
                    val quantity = document.get("quantity") as? String
                    quantities.append("Quantity: $quantity\n")
                }
                te.text = quantities.toString()
                Toast.makeText(this, "Quantities shown", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Failed to connect to internet: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
