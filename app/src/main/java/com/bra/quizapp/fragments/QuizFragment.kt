package com.bra.quizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bra.quizapp.Question
import com.bra.quizapp.R
import com.bra.quizapp.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    var score: Int = 0;
    private var binding: FragmentQuizBinding? = null;
    val resultFragment: ResultFragment = ResultFragment();

    private val questions = listOf(
        Question("What is the capital of France?", listOf("Paris", "London", "Berlin", "Madrid"), 0),
        Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("What is the largest ocean?", listOf("Atlantic", "Indian", "Pacific", "Arctic"), 2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        return binding!!.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var currQstIndex: Int = 0

        // Show the first question
        displayQuestions(currQstIndex)

        binding?.nextBtn?.setOnClickListener {
            // Check if the selected answer is correct
            if (getSelectedOptionIndex() == questions[currQstIndex].correctOptionIndex) {
                score++
            }

            currQstIndex++
            // Display the next question or navigate to the result screen
            displayQuestions(currQstIndex)
        }
    }

    private fun getSelectedOptionIndex() : Int? {
        return when (binding?.optionsGroup?.checkedRadioButtonId) {
            R.id.option1 -> 0
            R.id.option2 -> 1
            R.id.option3 -> 2
            R.id.option4 -> 3

            else -> null
        }
    }

    private fun displayQuestions (currQstIndex: Int) {
        if (currQstIndex < questions.size) {
            // To Reset The Selected RadioBtn
            binding!!.optionsGroup.clearCheck();

            binding!!.question.text = questions[currQstIndex].text;
            binding!!.option1.text = questions[currQstIndex].options[0];
            binding!!.option2.text = questions[currQstIndex].options[1];
            binding!!.option3.text = questions[currQstIndex].options[2];
            binding!!.option4.text = questions[currQstIndex].options[3];
        }
        else {

            val bundle: Bundle = Bundle();
            bundle.putInt("score", score);
            bundle.putInt("totalQuestion", questions.size);
            resultFragment.arguments = bundle;

            val transaction = parentFragmentManager.beginTransaction();
            transaction.replace(R.id.fragment_container, resultFragment);
            transaction.commit();
        }
    }

}