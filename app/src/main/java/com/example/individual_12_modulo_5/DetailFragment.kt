package com.example.individual_12_modulo_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val imageView: ImageView = view.findViewById(R.id.imageViewDetail)
        val textView: TextView = view.findViewById(R.id.textViewDetail)
        val backButton: Button = view.findViewById(R.id.backButton)


        val itemName = arguments?.getString("item_name")
        val itemImageUrl = arguments?.getString("item_image_url")

        textView.text = itemName
        Glide.with(this).load(itemImageUrl).into(imageView)

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }
}
