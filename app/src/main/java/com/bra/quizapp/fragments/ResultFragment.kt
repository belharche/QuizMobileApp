package com.bra.quizapp.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bra.quizapp.MainActivity
import com.bra.quizapp.R
import com.bra.quizapp.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    var binding: FragmentResultBinding? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false);
        return binding?.root;
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score: Int = arguments?.getInt("score") ?: 0;
        val totalQuestion: Int = arguments?.getInt("totalQuestion") ?: 0;
        if(totalQuestion == 0) {
            binding?.result?.text = "An Error Occurred While Calculating Your Score";
        }
        else {
            val percentage = ((score.toDouble() / totalQuestion) * 100).toInt()
            binding?.result?.text = "$percentage %"
        }

        binding?.exit?.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes") { _, _ ->
                    activity?.finishAffinity();
                }
                .setNegativeButton("No", null).show();
        }

        binding?.replay?.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java);
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK;
            startActivity(intent);
            activity?.finish();
        }


    }

}