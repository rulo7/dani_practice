package com.quohealth.danipractice.domain

import android.content.Context
import com.quohealth.danipractice.R
import java.io.Serializable

open class Identifiable(open var id: String) : Serializable

data class Worker(override var id: String,
                  var name: String,
                  var role: String? = null,
                  var image: String = "https://www.quohealth.com/static/media/smile.efaf64d3.png") : Identifiable(id)

fun Worker.asHasheable() = Pair(id, this)
fun Worker.display(
        context: Context) = "${context.getString(R.string.name).capitalize()}: $name\n${context.getString(R.string.role).capitalize()}: $role"

fun Collection<Worker>.display(context: Context) = map { it.display(context) }.reduce { acc, text -> "$acc\n$text" }