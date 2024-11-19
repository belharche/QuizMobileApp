package com.bra.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bra.quizapp.R
import com.bra.quizapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private var binding: FragmentQuizBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        return binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.nextBtn?.setOnClickListener {
            Toast.makeText(requireContext(), "Next Btn Clicked", Toast.LENGTH_LONG).show();
        }
    }

}