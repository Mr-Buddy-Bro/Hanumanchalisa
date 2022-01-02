package com.tech2develop.hanumanchalisa.Fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.tech2develop.hanumanchalisa.R

class BhajanFragment(code: Int) : Fragment() {

val code = code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bhajan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = getView()?.findViewById<ImageView>(R.id.ivBhajan)
        when (code){
            0->{
                image?.setImageResource(R.drawable.kastbhanjandev10)
            }
            1->{
                image?.setImageResource(R.drawable.kastbhanjandev10)
            }
            2->{
                image?.setImageResource(R.drawable.kastbhanjandev10)
            }
            3->{
                image?.setImageResource(R.drawable.kastbhanjandev10)
            }
            4->{
                image?.setImageResource(R.drawable.kastbhanjandev10)
            }
        }
    }
}