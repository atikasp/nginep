package com.example.nginep1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nginep1.HousesSmallItemData.listHousesSmallItemData

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvHouses: RecyclerView
    private lateinit var rvHousesSmallItem: RecyclerView
    private var list: ArrayList<House> = arrayListOf()
    private var listSmallItem: ArrayList<House> = arrayListOf()
    private var listHouseHorizontalAdapter = CardViewHouseAdapter(list)
    private var listHouseVerticalAdapter = CardViewHouseSmallItemAdapter(listSmallItem)

    private lateinit var searchitem: SearchView
    private lateinit var profile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideKeyboard()
        showHorizontalRecyclerList()
        showVerticalRecyclerList()
        profile = findViewById(R.id.photoprofile)
        profile.setOnClickListener(this)
        searchfun()

        }

    fun AppCompatActivity.hideKeyboard() {
        val  view = this.currentFocus
        if(view != null){
            val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }


    private fun searchfun() {

        searchitem = findViewById(R.id.searchviewHouse)
        searchitem.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchitem.clearFocus()
                searchitem.setQuery("", false)
                searchitem.onActionViewCollapsed()
                return true
            }

            @SuppressLint("DefaultLocale")
            override fun onQueryTextChange(newText: String?): Boolean {
                val tempList : MutableList<House> = ArrayList()
                val tempSmallList : MutableList<House> = ArrayList()
                if(newText!!.isNotEmpty()){
                    val search = newText.lowercase()
                    for (house in list ) {
                        if (house.name.lowercase().contains(search) || house.address.lowercase().contains(search)) {
                            tempList.add(house)
                        }
                    }
                    for (house in listSmallItem ) {
                        if (house.name.lowercase().contains(search) || house.address.lowercase().contains(search)) {
                            tempSmallList.add(house)
                        }
                    }

                }
                else {
                    tempList.addAll(list)
                    tempSmallList.addAll(listSmallItem)
                }
                listHouseHorizontalAdapter.updateList(tempList)
                listHouseVerticalAdapter.updateList(tempSmallList)
                return true
            }
        })
    }

    private fun showHorizontalRecyclerList() {
        rvHouses = findViewById(R.id.rv_houses)
        rvHouses.setHasFixedSize(true)
        list.addAll(HousesData.listHousesData)
        rvHouses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHouses.adapter = listHouseHorizontalAdapter

        listHouseHorizontalAdapter.setOnItemClickCallback(object : CardViewHouseAdapter.OnItemClickCallback {
            override fun onItemClicked(data: House) {
                showSelectedHouse(data)
            }
        })
    }

    private fun showSelectedHouse(house: House) {
        val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveIntent.putExtra("PHOTO", house.photo.toString())
        moveIntent.putExtra("NAME",house.name)
        moveIntent.putExtra("PRICE",house.price)
        moveIntent.putExtra("RATE", house.rate.toString())
        moveIntent.putExtra("ADDRESS",house.address)
        moveIntent.putExtra("DETAILS",house.details)
        moveIntent.putExtra("OWNER", house.owner)
        startActivity(moveIntent)
    }

    private fun showVerticalRecyclerList() {
        rvHousesSmallItem = findViewById(R.id.rv_houses_small_item)
        rvHousesSmallItem.setHasFixedSize(true)
        listSmallItem.addAll(listHousesSmallItemData)
        rvHousesSmallItem.layoutManager = LinearLayoutManager(this)
        rvHousesSmallItem.adapter = listHouseVerticalAdapter

        listHouseVerticalAdapter.setOnItemClickCallback(object : CardViewHouseSmallItemAdapter.OnItemClickCallback{
            override fun onItemClicked(data: House){
                showSelectedHouse(data)
            }
        })
    }

    override fun onClick(p0: View?) {
        val moveToProfileActivity = Intent(this, ProfileActivity::class.java)
        startActivity(moveToProfileActivity)
    }


}