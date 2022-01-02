package com.tech2develop.hanumanchalisa.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tech2develop.hanumanchalisa.LyricsArrays.LyricsStore
import com.tech2develop.hanumanchalisa.R

class LyricsFragment(code: Int) : Fragment() {

    val code = code

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lyrics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvLyrics = getView()?.findViewById<TextView>(R.id.tvLyrics)

        val lyricsStore = LyricsStore()
        val lyrics = lyricsStore.lyricsArray[code]

        tvLyrics?.text = lyrics

    }
}