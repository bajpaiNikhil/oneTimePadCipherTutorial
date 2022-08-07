package com.example.onetimepadciphertutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val plainText = findViewById<EditText>(R.id.plainText)
        val generateButton = findViewById<Button>(R.id.cipherBtn)
        val cipherTextView = findViewById<TextView>(R.id.cipherTextTV)

        //val plainText = "This is just and example"
//        val randomKeyCipher = OneTimePadCipherObject.oneTimePadRandomGenerator(plainText.text.toString())
//        Log.d("MainActivity" , "RandomKeyCipher $randomKeyCipher")

        generateButton.setOnClickListener {

            //val plainText = "This is just and example"
            val randomKeyCipher = OneTimePadCipherObject.oneTimePadRandomGenerator(plainText.text.toString())
            Log.d("MainActivity" , "RandomKeyCipher $randomKeyCipher")

            val oneTimePadEncryption = OneTimePadCipherObject.oneTimePadCipherEncryption(plainText.text.toString() , randomKeyCipher)
            Log.d("MainActivity" , "OneTimePadEncryption $oneTimePadEncryption")

            cipherTextView.text = oneTimePadEncryption

            val oneTimePadDecryption = OneTimePadCipherObject.oneTimePadCipherDecryption(oneTimePadEncryption , randomKeyCipher)
            Log.d("MainActivity" , "OneTimePadDecryption $oneTimePadDecryption")

        }




    }
}