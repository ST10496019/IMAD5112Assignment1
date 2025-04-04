package com.example.lastfastfood


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestionText: TextView
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        timeInput = findViewById(R.id.timeInput)
        suggestionText = findViewById(R.id.suggestionText)
        suggestButton = findViewById(R.id.suggestionButton)
        resetButton = findViewById(R.id.resetButton)

        // Set up listeners
        suggestButton.setOnClickListener {
            provideMealSuggestion()
        }

        resetButton.setOnClickListener {
            resetInputs()
        }
    }

    // Function to provide meal suggestions based on the input time of the day
    private fun provideMealSuggestion() {
        val timeOfDay = timeInput.text.toString().trim().lowercase(Locale.getDefault())

        // Validate input and provide suggestions
        val suggestion = when (timeOfDay) {
            "morning" -> "Breakfast: Eggs and Bacon, Pancakes and Syrup and Toast"
            "afternoon" -> "Lunch: Cheese Burger, Double Beef burger and Chicken Crunch Burger"
            "dinner" -> "Dinner: Pap, Oxtail, Macaroni and Mince and Beef"
            else -> {
                showError("Invalid input. Please enter a valid time of day (Morning, Mid-morning, etc.).")
                return
            }
        }

        // Display the suggestion
        suggestionText.text = suggestion
    }

    // Function to reset input fields and suggestions
    private fun resetInputs() {
        timeInput.text.clear()
        suggestionText.text = ""
    }

    // Function to show error message in a Toast
    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}