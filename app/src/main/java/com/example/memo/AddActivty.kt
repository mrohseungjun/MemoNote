package com.example.memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.memo.databinding.ActivityAddActivtyBinding
import com.google.android.material.chip.Chip

class AddActivty : AppCompatActivity() {
    private lateinit var binding: ActivityAddActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddActivtyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initViews()
        binding.addButton.setOnClickListener {
            add()
        }
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

    private fun add() {
        val text = binding.textInputEdit.text.toString()
        val mean = binding.meanTextInputEditText.text.toString()
        val type = findViewById<Chip>(binding.typeChipGroup.checkedChipId).text.toString()
        val word = Word(text, mean, type)

        Thread{
            AppDataBase.getInstance(this )?.wordDao()?.insert(word)
            runOnUiThread {
                Toast.makeText(this,"저장을 완료했습니다.",Toast.LENGTH_SHORT).show()
            }
            finish()
        }.start()
    }
}