package com.example.individual_12_modulo_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        setupRecyclerView()
        return view
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter(returnItemList()) { item ->

            val bundle = Bundle().apply {
                putString("item_name", item.name)
                putString("item_image_url", item.imageUrl)
            }
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun returnItemList(): List<Item> {
        return listOf(
            Item("Zhuo Cheng you", "https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640"),
            Item("billow926", "https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640"),
            Item("Philipp Deiß", "https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640"),
            Item("Huper by Joshua Earle", "https://unsplash.com/photos/_p8gVNNsWw4/download?force=true&w=640"),
            Item("Melnychuk Nataliya", "https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640"),
            Item("Teagan Maddux", "https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640"),
            Item("Chen Liu", "https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640"),
            Item("John Fornander", "https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640"),
            Item("Parker Coffman", "https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640"),
            Item("XPS", "https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640"),
            Item("Daniel J. Schwarz", "https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640"),
            Item("Wesley Armstrong", "https://unsplash.com/photos/q0wqYpyWDpc/download?force=true&w=640")
        )
    }
}
