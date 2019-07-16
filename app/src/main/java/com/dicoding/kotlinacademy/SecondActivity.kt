package com.dicoding.kotlinacademy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    companion object {
        const val detail_club = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val club = intent.getParcelableExtra<Item>("ALL_DETAIL")
        SecondActivityUI(club).setContentView(this)

    }

    inner class SecondActivityUI(var club: Item ) : AnkoComponent<SecondActivity> {

        override fun createView(ui: AnkoContext<SecondActivity>) = with(ui){

            linearLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                imageView{
                    id = R.id.image_club
                    padding = dip(10)
                    Glide.with(this).load(club.image).into(this)
                    this@linearLayout.gravity = Gravity.CENTER_HORIZONTAL
                }.lparams(dip(80), dip(80))

                textView{
                    id = R.id.name_club
                    padding = dip(10)
                    text = club.name
                    textSize = sp(16).toFloat()
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView{
                    id = detail_club
                    padding = dip(10)
                    text = club.detail
                    gravity = Gravity.LEFT
                }
            }
        }
    }
}
