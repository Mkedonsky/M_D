package ru.mkedonsky.md

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_snackbar.*


class SnackbarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        button.setOnClickListener {
            val snack = Snackbar.make(it, "Вот и Снэкбар", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("Отмена") {
                println("Кнопка снэка нажата")
            }
            snack.show()
        }
    }
}