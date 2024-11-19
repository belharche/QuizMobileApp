package com.bra.quizapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bra.quizapp.fragments.QuizFragment

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val quizFragment: QuizFragment = QuizFragment();

        val transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, quizFragment);
        transaction.commit();
    }
}