package com.example.code21032.constraint

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        test()
    }

    private fun test() {
        val button : Button = Button(this)
        button.setText("press me");
        button.setBackgroundColor(Color.BLUE)
        button.id = R.id.button

        val myLayout : ConstraintLayout = ConstraintLayout(this)
        myLayout.setBackgroundColor(Color.BLACK)
        myLayout.addView(button)

        setContentView(myLayout)

        val set = ConstraintSet()
        set.constrainHeight(button.id, ConstraintSet.WRAP_CONTENT)

        val r : Resources = resources
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200f, r.displayMetrics).toInt()


        set.constrainWidth(button.id, px)

        set.connect(button.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,0)
        set.connect(button.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,0)
        set.connect(button.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP,0)
        set.connect(button.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,0)

        set.applyTo(myLayout)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
