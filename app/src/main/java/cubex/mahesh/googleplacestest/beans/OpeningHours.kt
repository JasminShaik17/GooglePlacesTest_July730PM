package cubex.mahesh.googleplacestest.beans

import com.google.gson.annotations.SerializedName

data class OpeningHours(@SerializedName("open_now")
                        val openNow: Boolean = false)