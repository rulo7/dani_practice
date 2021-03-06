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

fun Context.dp(value: Int): Int = value * resources.displayMetrics.density.toInt()
fun Context.dp(value: Float): Int = value.toInt() * resources.displayMetrics.density.toInt()
fun Context.dp(value: Double): Int = value.toInt() * resources.displayMetrics.density.toInt()

fun Context.sp(value: Int): Int = value * resources.displayMetrics.scaledDensity.toInt()
fun Context.sp(value: Float): Int = value.toInt() * resources.displayMetrics.scaledDensity.toInt()
fun Context.sp(value: Double): Int = value.toInt() * resources.displayMetrics.scaledDensity.toInt()

fun <T> List<T>.toArrayList() = arrayListOf<T>().also { arrayList -> arrayList.addAll(this) }