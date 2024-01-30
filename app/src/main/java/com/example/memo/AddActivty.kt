package com.example.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memo.databinding.ActivityAddActivtyBinding
import com.google.android.material.chip.Chip

class AddActivty : AppCompatActivity() {
    private lateinit var binding: ActivityAddActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddActivtyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val types = listOf(
            "명사", "동사", "대명시", "형용사", "부사", "감탄사", "전치사", "접속사"
        )
        binding.typeChipGroup.apply {
            types.forEach { text ->
                addView(createChip(text))
            }
        }
    }

    private fun createChip(text: String): Chip {
        return Chip(this).apply {
            setText(text)
            isCheckable = true
            isClickable = true
        }
    }
}