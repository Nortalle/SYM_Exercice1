package ch.heig_vd.iict.symexercices.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import ch.heig_vd.iict.symexercices.R;

/**
 * A {@link AbstractFragment} subclass.
 * Use the {@link AbstractFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentExercise3 extends AbstractFragment {

    //GUI elements
    private Button btn = null;
    private ListView list = null;
    private TextView empty = null;

    //data
    private ExampleAdapter adapter = null;

    public FragmentExercise3() { /*Required empty public constructor*/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //TODO Exercice 3
        //on souhaite afficher des données du type Directory (ch.heig_vd.iict.symexercices.models.Directory)
        //le constructeur génère aléatoirement des données, vous modifierez le layout list_item_ex3.xml
        //pour permettre l'affichage du nom, prénom, date de naissance et la photo

        View v = inflater.inflate(R.layout.fragment_exercise3, container, false);

        //link to GUI
        this.btn = v.findViewById(R.id.ex3_lv_btn);
        this.list = v.findViewById(R.id.ex3_lv);
        this.empty = v.findViewById(R.id.ex3_empty);

        //data
        //sample
        this.adapter = new ExampleAdapter(getContext());
        this.list.setAdapter(this.adapter);

        this.list.setEmptyView(this.empty); //displayed if the list is empty

        //events
        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previousSize = adapter.getCount();
                if(previousSize == 0) previousSize = 1;
                adapter.setSize(previousSize * 2);
            }
        });

        return v;
    }

    /**
     *  Sample adapter
     */
    private static class ExampleAdapter extends BaseAdapter {

        private Context context = null;
        private int size = 0;


        public ExampleAdapter(Context context) {
            this.context = context;
        }

        public void setSize(int size) {
            this.size = size;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return this.size;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public View getView(int position, View recycledView, ViewGroup viewGroup) {
            if(recycledView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                recycledView = inflater.inflate(R.layout.list_item_ex3, viewGroup, false);
            }

            //link to GUI
            TextView tv = recycledView.findViewById(R.id.list_item_tv1);

            //set text
            tv.setText(String.format(context.getResources().getConfiguration().locale,"%d", position+1));

            return recycledView;
        }

    }

}
