package com.eghanury.nfc
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity(), NfcAdapter.ReaderCallback {
 private var nfcAdapter: NfcAdapter? = null
 private lateinit var statusText: TextView
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  statusText = TextView(this).apply {
   text = "TEMPELKAN KARTU NFC\nMenunggu..."
   textSize = 20f
   setPadding(50,200,50,50)
  }
  setContentView(statusText)
  nfcAdapter = NfcAdapter.getDefaultAdapter(this)
 }
 override fun onResume() {
  super.onResume()
  nfcAdapter?.enableReaderMode(this,this,15,null)
 }
 override fun onPause() {
  super.onPause()
  nfcAdapter?.disableReaderMode(this)
 }
 override fun onTagDiscovered(tag: Tag?) {
  val id = tag?.id?.joinToString(":") { "%02X".format(it) }
  runOnUiThread { statusText.text = "TERDETEKSI!\nID: $id" }
 }
}
