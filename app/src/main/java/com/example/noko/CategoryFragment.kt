package com.example.noko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.noko.API.ApiEndPoint
import com.example.noko.adapter.RVAdapterCategory
import com.example.noko.model.Category
import kotlinx.android.synthetic.main.fragment_category.*
import org.json.JSONObject


class CategoryFragment : Fragment() {

    var arrayList = ArrayList<Category>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_category, container, false)
        var recycler = view.findViewById(R.id.mRecyclerViewCategory) as RecyclerView
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(view.context)
        AndroidNetworking.get(ApiEndPoint.LIST_CATEGORY)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(object : JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        arrayList.clear()
                        val jsonArray = response?.optJSONArray("data")
                        if (jsonArray?.length() == 0){
                            Toast.makeText(view.context, "Data Kosong!", Toast.LENGTH_SHORT).show()
                        }
                        for(i in 0 until jsonArray?.length()!!){
                            val jsonObject = jsonArray?.optJSONObject(i)
                            arrayList.add(Category(jsonObject.getString("category_name")))
                            if (jsonArray?.length() - 1 == i){
                                val adapter = RVAdapterCategory(view.context, arrayList)
                                adapter.notifyDataSetChanged()
                                recycler.adapter = adapter
                            }
                        }
                    }

                    override fun onError(anError: ANError?) {
                        Toast.makeText(view.context, "Connection Failure", Toast.LENGTH_SHORT).show()
                    }

                })
        return view
    }

    companion object {
        fun newInstance(): CategoryFragment{
            val fragment = CategoryFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}