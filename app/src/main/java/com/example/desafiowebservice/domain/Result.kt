package com.example.desafiowebservice.domain

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class Result(
    val id: Int,
    var title: String?,
    var description: String?,
    var pageCount: Int,
    var dates: ArrayList<Date>?,
    var prices: ArrayList<Price>?,
    var thumbnail: Thumbnail?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.createTypedArrayList(Date),
        parcel.createTypedArrayList(Price),
        parcel.readParcelable(Thumbnail::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeInt(pageCount)
        parcel.writeTypedList(dates)
        parcel.writeTypedList(prices)
        parcel.writeParcelable(thumbnail, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}