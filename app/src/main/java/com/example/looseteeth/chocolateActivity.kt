package com.example.looseteeth

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore

class chocolateActivity : AppCompatActivity() {

    private lateinit var f:FirebaseFirestore
    private lateinit var tquantity:TextView
    private lateinit var eupdate:EditText
    private lateinit var bupdate:EditText
    private lateinit var tsold:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chocolate)

        eupdate = findViewById(R.id.edtupdate)
        bupdate = findViewById(R.id.btnupdate)
        tquantity = findViewById(R.id.txtquantitiy)
        tsold = findViewById(R.id.txtsold)



        bupdate.setOnClickListener{
            buttonUpdate()
        }



    }

    private fun buttonUpdate() {
        f = FirebaseFirestore.getInstance()
        var eneterd_update = eupdate.text.toString()
        var quant = hashMapOf(
            "quantity" to eneterd_update
        )
        var t = f.collection("icecream").document("OBV4XCIMeoBEFYqH9sKO").update(quant as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "quantity updated", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, "quantity no updated", Toast.LENGTH_SHORT).show()
            }

        tquantity.text = "quantity: " + t.toString()
    }

}