package com.example.looseteeth

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore

class stockActivity : AppCompatActivity() {

    private lateinit var f:FirebaseFirestore
    private lateinit var te:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        f = FirebaseFirestore.getInstance()
        te = findViewById(R.id.textView)

        var v = f.collection("icecream").get()
            .addOnSuccessListener {
                Toast.makeText(this, "quantities shown", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, "connect to internet", Toast.LENGTH_SHORT).show()
            }
        te.text = v.toString()
    }
}