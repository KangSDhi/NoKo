package com.example.noko.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noko.R
import com.example.noko.model.Category
import kotlinx.android.synthetic.main.card_list_category.view.*
import java.util.ArrayList

class RVAdapterCategory(private val context: Context, private val arrayList: ArrayList<Category>) : RecyclerView.Adapter<RVAdapterCategory.Holder>() {

    class Holder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.card_list_category, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.lb_category_name.text = arrayList?.get(position)?.category_name
    }

    override fun getItemCount(): Int = arrayList!!.size

}