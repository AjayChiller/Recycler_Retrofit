package com.technofreak.testtecyclerretrofit.models

@Suppress("UNREACHABLE_CODE")
public data class BLog (
    val title: String,
    val body:String,
    val id:String
) {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)

        if (javaClass != other?.javaClass)
            return false

        other as BLog
        if (title != other.title)
            return false


        if (body != other.body)
            return false


        if (id != other.id)
            return false


    }

    override fun toString(): String {
        return "BLog(title='$title', body='$body', author='$id')"
    }


}
