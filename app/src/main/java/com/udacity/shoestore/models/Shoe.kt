package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String
) : Parcelable{
fun getSIze():String{
    return  size.toString()
}
    companion object {
        fun create(
            shoe: Shoe
        ): Shoe {
            var temp: Shoe = Shoe("UNKNOWN", 0.00, "UNKNOWN", "UNKNOWN")
            if (!shoe.name.equals(""))
                temp.name = shoe.name
            if (!shoe.size.equals(""))
                temp.size = shoe.size.toDouble()
            if (!shoe.company.equals(""))
                temp.company = shoe.company
            if (!shoe.description.equals(""))
                temp.description = shoe.description
            return temp

        }
    }
}