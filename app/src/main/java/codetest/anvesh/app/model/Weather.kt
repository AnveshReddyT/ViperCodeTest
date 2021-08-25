package codetest.anvesh.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var desc: String? = null
) : Parcelable