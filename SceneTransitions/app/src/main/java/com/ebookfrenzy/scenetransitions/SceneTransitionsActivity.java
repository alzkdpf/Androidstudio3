package com.ebookfrenzy.scenetransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;

import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.ViewGroup;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;


public class SceneTransitionsActivity extends AppCompatActivity {

    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;
    Transition transitionMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_transitions);

        rootContainer =
                (ViewGroup) findViewById(R.id.rootContainer);

        //transition settter
//        transitionMgr = TransitionInflater.from(this)
//                .inflateTransition(R.transition.transition);

        //default
//        TransitionSet myTransition = new TransitionSet();

        //option 1
//        Transition mychangeBounds = new ChangeBounds();

        //option 2
//        TransitionSet myTransition = new TransitionSet();
//        myTransition.addTransition(new ChangeBounds());
//        myTransition.addTransition(new Fade());

        //option 3
        TransitionSet myTransition = new TransitionSet();
        Transition bounds = new ChangeBounds();
        bounds.setInterpolator(new OvershootInterpolator(3.0f));
        myTransition.addTransition(bounds);

        Transition fade = new Fade();
        fade.setDuration(3000);
        fade.addTarget(R.id.button);
        myTransition.addTransition(fade);


        transitionMgr = myTransition;

        scene1 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene1_layout, this);

        scene2 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene2_layout, this);

        scene1.enter();

    }

    public void goToScene2 (View view)
    {
        TransitionManager.go(scene2, transitionMgr);
        //Toast.makeText(getApplicationContext(),
          //      "장면 전환 2에 도달함", Toast.LENGTH_LONG).show();

    }

    public void goToScene1 (View view)
    {
        TransitionManager.go(scene1, transitionMgr);
    }
}
