package com.eghanury.nfc
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "Egha NFC Ready!"
        tv.textSize = 24f
        setContentView(tv)
    }
}
