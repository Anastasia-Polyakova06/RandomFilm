package com.example.randomfilm

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var movies: List<String>
    private val remainingMovies = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies = resources.getStringArray(R.array.movies).toList()
        resetMovies()
    }

    fun onNextClick(view: View) {
        val tvTitle = findViewById<TextView>(R.id.title)

        if (remainingMovies.isEmpty()) {
            tvTitle.text = getString(R.string.no_movies)
        } else {
            val randomIndex = remainingMovies.indices.random()
            val movie = remainingMovies.removeAt(randomIndex)
            tvTitle.text = movie
        }
    }

    fun onClearClick(view: View) {
        resetMovies()

        val tvTitle = findViewById<TextView>(R.id.title)
        tvTitle.text = getString(R.string.ready)
    }

    private fun resetMovies() {
        remainingMovies.clear()
        remainingMovies.addAll(movies)
    }
}