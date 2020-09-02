package ru.mkedonsky.md

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.*


class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val mFab = findViewById<FloatingActionButton>(R.id.fab)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, state: Int) {
                editText.isEnabled = state != BottomSheetBehavior.STATE_EXPANDED
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                mFab.animate().scaleX(1 - slideOffset)
                    .scaleY(1 - slideOffset).setDuration(0).start()
            }
        })

        mFab.setOnClickListener {
            val snack = Snackbar.make(it, "done", Snackbar.LENGTH_INDEFINITE)
            snack.setAction("esc") {
                println("Fab нажата")
            }
            snack.show()
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setLogo(R.mipmap.ic_launcher_round)

        override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?): Boolean {
            inflater!!.inflate(R.menu.menu_bottom_sheet, menu)
            super.onCreateOptionsMenu(menu)
        }



            override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
                val id = menuItem.itemId
                if (id == R.id.av_action_img_OK) {
                    //                        какойто код
                }
                if (id == R.id.av_action_img_Close) {
                    //                        какойто код
                }

                return super.onOptionsItemSelected(item);
            }


    }
}