package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import androidx.core.text.HtmlCompat.fromHtml
import com.example.myapplication.data.Questions

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var currentQuestion: Int = 0
    private var correctAnswerCount: Int = 0
    private lateinit var tvQuestionsNumber: TextView
    private lateinit var tvQuestionsText: TextView
    private lateinit var btnAnswer1: Button
    private lateinit var btnAnswer2: Button
    private lateinit var btnAnswer3: Button
    private lateinit var btnAnswer4: Button
    private lateinit var tvOcenka: TextView


    private val questions = mutableListOf<Questions>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillQuestions()

        tvQuestionsNumber = findViewById(R.id.tvQuestionsNumber)
        tvQuestionsText = findViewById(R.id.tvQuestionsText)
        btnAnswer1 = findViewById(R.id.btnAnswer1)
        btnAnswer2 = findViewById(R.id.btnAnswer2)
        btnAnswer3 = findViewById(R.id.btnAnswer3)
        btnAnswer4 = findViewById(R.id.btnAnswer4)
        tvOcenka=findViewById(R.id.ocenka)

        updateUI()

        btnAnswer1.setOnClickListener(this)
        btnAnswer2.setOnClickListener(this)
        btnAnswer3.setOnClickListener(this)
        btnAnswer4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.btnAnswer1 -> proccessAnswer(1)
                R.id.btnAnswer2 -> proccessAnswer(2)
                R.id.btnAnswer3 -> proccessAnswer(3)
                R.id.btnAnswer4 -> proccessAnswer(4)
            }
        }
    }

    private fun fillQuestions() {
        questions.run {
            this.add(
                Questions(
                    "Поименованная область в памяти для хранения данных",
                    "Тип данных",
                    "Переменная",
                    "Оператор",
                    "Класс",
                    2
                )
            )
            this.add(
                Questions(
                    "Допустимое множество значений",
                    "Тип данных",
                    "Переменная",
                    "Оператор",
                    "Класс",
                    1
                )
            )
            this.add(
                Questions(
                    "наименьшая автономная часть языка программирования",
                    "Тип данных",
                    "Переменная",
                    "Оператор",
                    "Класс",
                    3
                )
            )
            this.add(
                Questions(
                    "модель для создания объектов определённого типа, описывающая их структуру",
                    "Тип данных",
                    "Переменная",
                    "Оператор",
                    "Класс",
                    2
                )
            )
            this.add(
                Questions(
                    "По умолчанию ассемблер формирует для команды jmp машинную команду длинной",
                    "2 байта",
                    "3 байта",
                    "4 байта",
                    "1 байт",
                    2
                )
            )
            this.add(
                Questions(
                    "Какова будет общая длина отрезка FS в см, если длина FK составляет 2 дм 5 см, а длина KS - 1 дм?",
                    "45 см",
                    "35 см",
                    "40 см",
                    "25 см",
                    2
                )
            )
            this.add(
                Questions(
                    "Сколько суток в 480 часах?",
                    "36",
                    "20",
                    "18",
                    "41",
                    2
                )
            )
            this.add(
                Questions(
                    "Какое равенство верное?",
                    "5 л 250 мл = 5150 мл",
                    "3 кг 50 г = 3500 г",
                    "1500 см = 15 км",
                    "744 часа = 31 день",
                    4
                )
            )
            this.add(
                Questions(
                    "Какая из представленных величин больше 1 метра?",
                    "1 сантиметр",
                    "1 километр",
                    "1 миллиметр",
                    "1 дециметр",
                    2
                )
            )
            this.add(
                Questions(
                    "В каком варианте единицы измерения размещены в порядке убывания?",
                    "час, минута, день, секунда",
                    "килограмм, тонна, грамм, миллиграмм",
                    "километр, метр, сантиметр, дециметр",
                    "год, месяц, эра, век",
                    3
                )
            )
            this.add(
                Questions(
                    "Сколько месяцев содержится в 20 годах?",
                    "240",
                    "200",
                    "280",
                    "260",
                    1
                )
            )
            this.add(
                Questions(
                    "На сколько грамм уменьшится торт весом в 4 кг, если от него отрезать один кусок весом в 240 г?",
                    "на 3800 г",
                    "на 3760 г",
                    "на 3250 г",
                    "на 3620 г",
                    2
                )
            )
            this.add(
                Questions(
                    "Как записать в метрах 20 км?",
                    "2000 м",
                    "200 м",
                    "20000 м",
                    "2 м",
                    3
                )
            )
            this.add(
                Questions(
                    "Всего в двух кувшинах 5 л сока. Сколько мл сока в первом кувшине, если во втором 2 л 750 мл?",
                    "2250 мл",
                    "3750 мл",
                    "1650 мл",
                    "2850 мл",
                    1
                )
            )

            this.add(
                Questions(
                    "Какая единица длины самая большая?",
                    "километр",
                    "метр",
                    "миллиметр",
                    "сантиметр",
                    1
                )
            )
        }
    }

    private fun updateUI() {
        tvQuestionsNumber.text =
            getString(R.string.question_number_ui, currentQuestion + 1, questions.size)
        tvQuestionsText.text =
            fromHtml(questions[currentQuestion].textQuestions, FROM_HTML_MODE_COMPACT)
        btnAnswer1.text = fromHtml(questions[currentQuestion].answer1, FROM_HTML_MODE_COMPACT)
        btnAnswer2.text = fromHtml(questions[currentQuestion].answer2, FROM_HTML_MODE_COMPACT)
        btnAnswer3.text = fromHtml(questions[currentQuestion].answer3, FROM_HTML_MODE_COMPACT)
        btnAnswer4.text = questions[currentQuestion].answer4
    }

    private fun checkAnswer(givenID: Int) = (givenID == questions[currentQuestion].right)

    private fun toNextQuestion(): Boolean {
        if (currentQuestion >= questions.size - 1)
            return false
        currentQuestion++
        updateUI()
        return true
    }

    private fun proccessAnswer(givenID: Int) {
        if (checkAnswer(givenID) == true)
            correctAnswerCount++
        if (toNextQuestion() == false) {
            Toast.makeText(this, "Игра закончена", Toast.LENGTH_SHORT).show()
            btnAnswer1.isEnabled = false
            btnAnswer2.isEnabled = false
            btnAnswer3.isEnabled = false
            btnAnswer4.isEnabled = false
            tvQuestionsNumber.text = getString(R.string.game_over)
            val correctProcent: Int =
                (correctAnswerCount.toDouble() / questions.size.toDouble() * 100).toInt()
            val incorrectProcent: Int = (100 - correctProcent)
            tvQuestionsText.text = getString(R.string.game_result, correctProcent, incorrectProcent)

            if(correctProcent<50){
                tvOcenka.text=getString(R.string.ocenka_text,2)
            }
            else if(correctProcent<75)
            {
                tvOcenka.text=getString(R.string.ocenka_text,3)
            }
            else if(correctProcent<85)
            {
                tvOcenka.text=getString(R.string.ocenka_text,4)
            }
            else{
                tvOcenka.text=getString(R.string.ocenka_text,5)
            }

        }
    }
}