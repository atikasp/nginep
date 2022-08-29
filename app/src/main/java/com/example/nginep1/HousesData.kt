package com.example.nginep1

object HousesData {

    private val housesname = arrayOf(
        "Kost Misa",
        "Villa Ria",
        "Hotel Cendana",
        "Kong Hostel",
        "Opa Guesthouse",
        "Apartment 166",
        "Kembali Resort",
        "Rumah Nenek Moyang",
        "Kalibri Homestay",
        "Wisma Malahayati"
    )

    private val housesprice = arrayOf(
        "Rp40k",
        "Rp100k",
        "Rp90k",
        "Rp50k",
        "Rp65k",
        "Rp60k",
        "Rp85k",
        "Rp95k",
        "Rp55k",
        "Rp45k"
    )

    private val housesrate = floatArrayOf(
        4.0F, 4.3F, 4.4F, 4.3F, 4.7F, 4.5F, 4.8F, 4.9F, 4.5F, 4.6F
    )

    private val housesaddress = arrayOf(
        "Jl. Perjuangan No.12, Medan Kota",
        "Jl. Simpang Empat No.25, Medan Kota",
        "Jl. Percobaan No.133, Medan Kota",
        "Jl. Brigjend Katamso No.88, Medan Kota",
        "Jl. Bandung No.1, Medan Kota",
        "Jl. Jangkar No.50, Medan Polonia",
        "Jl. Sei Semayang No.32, Medan Maimun",
        "Jl. Minangkabau No.19, Medan Area",
        "Jl. Sei Semayang No.32, Medan Maimun",
        "Jl. Kereta Api, No.2, Medan Maimun"
    )

    private val housesowner = arrayOf(
        "Bu Misa",
        "Bu Ria",
        "Pak Aston",
        "Bu Sarah",
        "Opa Ridwan",
        "Jack Ow",
        "Ningtyas",
        "Samanhudi",
        "Endang Supradja",
        "Bu Titin"
    )

    private val housesdetails = arrayOf(
        "2 tamu . 1 bed . AC . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner",
        "2 tamu . 1 bed . AC . TV . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . WIFI . Dinner",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI . Dinner . Pool",
        "2 tamu . 1 bed . 1 bath. AC . TV . WIFI",
        "2 tamu . 1 bed . 1 bath. AC . WIFI"
    )

    private val housesphoto = intArrayOf(
        R.drawable.kost,
        R.drawable.villa,
        R.drawable.hotel,
        R.drawable.hostel,
        R.drawable.guesthouse,
        R.drawable.apartment,
        R.drawable.resort,
        R.drawable.house,
        R.drawable.homestay,
        R.drawable.wisma
    )

    val listHousesData : ArrayList<House>
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