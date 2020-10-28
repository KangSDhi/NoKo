package com.example.noko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ShoppingCartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_cart, container, false)
    }

    companion object {
        fun newInstance(): ShoppingCartFragment{
            val fragment = ShoppingCartFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}