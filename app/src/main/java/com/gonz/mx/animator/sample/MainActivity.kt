package com.gonz.mx.animator.sample

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
    }

    private fun initializeView() {
        btnCodeAnimator.setOnClickListener {
            animateWithAnimatorApiUsingCode(vwAnimatorTest)
        }

        btnXmlAnimator.setOnClickListener {
            animateWithAnimatorApiUsingXML(vwAnimatorTest)
        }

        btnViewPropertyAnimator.setOnClickListener {
            animateWithViewPropertyAnimator(vwAnimatorTest)
        }
    }

    private fun animateWithAnimatorApiUsingCode(view: View) {
        // This code creates the animation from scratch
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 0.5f, 1f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 0.5f, 1f)
        val alpha = PropertyValuesHolder.ofFloat(View.ALPHA, 0f, 1f)

        ObjectAnimator.ofPropertyValuesHolder(view, scaleX, scaleY, alpha)
            .apply { interpolator = OvershootInterpolator() }
            .start()
    }

    private fun animateWithAnimatorApiUsingXML(view: View) {
        // This code takes the animation from an XML resource, an inflates
        // The result of the animation is exactly the same
        AnimatorInflater.loadAnimator(this, R.animator.obejct_animator_example)
            .apply {
                setTarget(view)
                start()
            }
    }

    private fun animateWithViewPropertyAnimator(view: View) {
        val animationOne = view.animate()
            .scaleX(0.5f).scaleY(0.5f).alpha(0.5f)
            .setInterpolator(OvershootInterpolator())
            .start()
    }
}
