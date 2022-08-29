package com.example.nginep1

import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var imgHouse: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvPrice: TextView
    private lateinit var tvRate: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvDetails: TextView
    private lateinit var tvOwner: TextView

    private lateinit var btnBack: ImageButton
    private lateinit var btnShare: ImageButton
    private lateinit var btnFav: Button
    private lateinit var btnMessage: ImageButton

    private lateinit var btnBook: Button

    private var isClicked : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgHouse = findViewById(R.id.detail_imgHouse)
        tvName = findViewById(R.id.name_house)
        tvPrice = findViewById(R.id.price_house)
        tvRate = findViewById(R.id.rating_house)
        tvAddress = findViewById(R.id.address_house)
        tvDetails = findViewById(R.id.desc_detail_house)
        tvOwner = findViewById(R.id.name_owner)

        imgHouse.setImageResource(intent.getStringExtra("PHOTO")!!.toInt())
        tvName.text = intent.getStringExtra("NAME")
        tvPrice.text = intent.getStringExtra("PRICE")
        tvRate.text = intent.getStringExtra("RATE")
        tvAddress.text = intent.getStringExtra("ADDRESS")
        tvDetails.text = intent.getStringExtra("DETAILS")
        tvOwner.text = intent.getStringExtra("OWNER")

        //btnTop
        btnBack = findViewById(R.id.btn_back)
        btnBack.setOnClickListener(this)
        btnShare = findViewById(R.id.btn_share)
        btnShare.setOnClickListener(this)
        btnFav = findViewById(R.id.btn_fav)
        btnFav.setOnClickListener(this)
        btnMessage = findViewById(R.id.btn_message)
        btnMessage.setOnClickListener(this)
        btnBook = findViewById(R.id.btn_book)
        btnBook.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if(view != null){
            when (view.id){
                R.id.btn_back -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
                R.id.btn_share -> {
                    val sendIntent : Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Berbagi tempat ini\n"+"--------------------\n"+tvName.text.toString()+"\n"+tvAddress.text.toString()+"\n"+tvPrice.text.toString())
                        type="text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent, "Share via : ")
                    startActivity(shareIntent)
                }
                R.id.btn_fav -> {
                    if(isClicked){
                        isClicked = false
                        view.setBackgroundResource(R.drawable.icon_fav)

                    }
                    else{
                        isClicked = true
                        view.setBackgroundResource(R.drawable.icon_fav_clicked)
                        Toast.makeText(this, "Favorite telah dipilih", Toast.LENGTH_SHORT).show()
                    }

                }
                R.id.btn_message -> {
                    val sendMessage: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Saya ingin tanya tentang \n"+"--------------------\n"+tvName.text)
                        type="text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendMessage, null)
                    sendMessage.setPackage("com.whatsapp")
                    startActivity(shareIntent)
                }
                R.id.btn_book -> {
                    Toast.makeText(this, "Pemesanan Berhasil", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}