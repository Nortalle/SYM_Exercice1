package ch.heig_vd.iict.symexercices.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import ch.heig_vd.iict.symexercices.R;

/**
 * A {@link AbstractFragment} subclass.
 * Use the {@link AbstractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise2 extends AbstractFragment {

    private int seekBarValue;

    //GUI elements
    private ProgressBar progressBar = null;
    private Button      pbButton    = null;

    private SeekBar     seekBar     = null;
    private TextView    sbText      = null;

    private CheckBox    cbChoice1   = null;
    private CheckBox    cbChoice2   = null;
    private Button      cbButton    = null;

    private RadioGroup  rbChoice    = null;

    private Spinner     spinner     = null;

    public FragmentExercise2() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_exercise2, container, false);

        //we link GUI elements
        this.progressBar = v.findViewById(R.id.ex2_pb);
        this.pbButton = v.findViewById(R.id.ex2_pb_btn);

        this.sbText = v.findViewById(R.id.ex2_sb_tv);
        this.seekBar = v.findViewById(R.id.ex2_sb);

        this.cbChoice1 = v.findViewById(R.id.ex2_cb_choice1);
        this.cbChoice2 = v.findViewById(R.id.ex2_cb_choice2);
        this.cbButton = v.findViewById(R.id.ex2_cb_validate);

        this.rbChoice = v.findViewById(R.id.ex2_rb_val);

        this.spinner = v.findViewById(R.id.ex2_sp);

        //init view
        this.seekBarValue = this.seekBar.getProgress();
        updateSeekBarText();

        //add events
        this.pbButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //TODO Exercice 2.A (part1)
                //on peut setter la progression de la ProgressBar avec la méthode setProgress
                //on veut incrémenter la progression de 1 unité à chaque clic (max 10)

            }
        });
        //TODO Exercice 2.A (part2)
        //on veut remettre à zéro la progression de la ProgressBar sur un long clic sur le bouton
        //-> OnLongClickListener


        //TODO Exercice 2.B
        //on peut utiliser un listener du type SeekBar.OnSeekBarChangeListener
        //pour être notifié des interactions utilisateurs
        //on veut mettre à jour la textview sbText - cf. variable seekBarValue

        this.cbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Exercice 2.C
                //on affichera un message à l'aide de la méthode mListner.displaySnackBar()
                //on fonction des CheckBoxs sélectionnées (0, 1 ou l'autre, les 2).
            }
        });

        //TODO Exercice 2.D
        //on peut utiliser un listener du type OnCheckedChangeListener sur un RadioGroup
        //pour être notifié des interactions utilisateurs
        //on affichera un message à l'aide de la fonction mListner.displaySnackBar("") lors d'un choix

        //TODO Exercice 2.E
        //on peut utiliser un listener du type OnItemSelectedListener sur un Spinner pour être notifié
        //du choix de l'utilisateur
        //Que faut-il faire pour que le Listener ne soit pas notifié lors de l'initialisation du Spinner ?

        return v;
    }

    /*
     *  GUI helpers
     */

    private void updateSeekBarText() {
        this.sbText.setText(getResources().getString(R.string.sct2_sb_val, this.seekBarValue));
    }

}
