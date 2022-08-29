package com.example.nginep1

object HousesSmallItemData {
    private val housesname = arrayOf(
        "Hotel Omahmu",
        "Elite Kost",
        "Apartment Lembang",
        "Wisma Melati",
        "Hotel Tobangado",
        "Apartment Tenamo",
        "Hotel Cenderawasih",
        "Kost Rasida",
        "Kembali Resort",
        "Wisma Malahayati"
    )

    private val housesprice = arrayOf(
        "Rp120k",
        "Rp50k",
        "Rp90k",
        "Rp60k",
        "Rp95k",
        "Rp70k",
        "Rp155k",
        "Rp35k",
        "Rp85k",
        "Rp45k"
    )

    private val housesrate = floatArrayOf(
        4.6F, 4.5F, 4.6F, 4.5F, 4.7F, 4.7F, 4.9F, 4.7F, 4.8F, 4.6F
    )

    private val housesaddress = arrayOf(
        "Jl. Penggaris No.35, Medan Polonia",
        "Jl. Gunting Empat No.49, Medan Polonia",
        "Jl. Mursala No.13, Medan Polonia",
        "Jl. STM No.1, Medan Polonia",
        "Jl. TB Simatupang No.8, Medan Polonia",
        "Jl. Sei Belara No.10, Medan Polonia",
        "Jl. Repas No.31, Medan Polonia",
        "Jl. Tunik No.89, Medan Polonia",
        "Jl. Simpang Baru No.4, Medan Polonia",
        "Jl. Kereta Api, No.2, Medan Maimun"
    )

    private val housesowner = arrayOf(
        "Lesty",
        "Bu Ria",
        "Randa",
        "Pak Fatur",
        "Khairunnisa",
        "Nilawati",
        "Taree",
        "Bu Rasida",
        "Ningtyas",
        "Bu Titin"
    )

    private val housesdetails = arrayOf(
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Pool",
        "2 tamu . 1 bed . AC . TV . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner ",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath. AC . WIFI"
    )

    private val housesphoto = intArrayOf(
        R.drawable.resort,
        R.drawable.villa,
        R.drawable.house,
        R.drawable.hostel,
        R.drawable.guesthouse,
        R.drawable.apartment,
        R.drawable.hotel,
        R.drawable.hostel,
        R.drawable.resort,
        R.drawable.wisma
    )

    val listHousesSmallItemData : ArrayList<House>
        get() {
            val listHouses = arrayListOf<House>()
            for (position in housesname.indices) {
                val house = House()
                house.name = housesname[position]
                house.price = housesprice[position]
                house.rate = housesrate[position]
                house.address = housesaddress[position]
                house.owner = housesowner[position]
                house.details = housesdetails[position]
                house.photo = housesphoto[position]
                listHouses.add(house)
            }
            return listHouses
        }
}