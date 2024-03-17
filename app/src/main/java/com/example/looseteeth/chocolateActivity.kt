package com.example.looseteeth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class chocolateActivity : AppCompatActivity() {

    private lateinit var f: FirebaseFirestore
    private lateinit var tquantity: TextView
    private lateinit var eupdate: EditText
    private lateinit var bupdate: Button
    private lateinit var tsold: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chocolate)

        eupdate = findViewById(R.id.edtupdate)
        bupdate = findViewById(R.id.btnupdate)
        tquantity = findViewById(R.id.txtquantitiy)
        tsold = findViewById(R.id.txtsold)

        bupdate.setOnClickListener {
            buttonUpdate()
        }
    }

    private fun buttonUpdate() {
        f = FirebaseFirestore.getInstance()
        val enteredUpdate = eupdate.text.toString()
        val quant = hashMapOf(
            "quantity" to enteredUpdate
        )
        f.collection("icecream").document("OBV4XCIMeoBEFYqH9sKO").update(quant as Map<String, Any>)
            .addOnSuccessListener {
                Toast.makeText(this, "Quantity updated", Toast.LENGTH_SHORT).show()
                tquantity.text = "Quantity: $enteredUpdate"
            }
            .addOnFailureListener {
                Toast.makeText(this, "Quantity not updated", Toast.LENGTH_SHORT).show()
            }
    }
}
