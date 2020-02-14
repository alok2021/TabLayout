package registration.devalok.com.activityfragmentsenddata;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{
EditText id_et_data;
Button id_btn;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        id_et_data = (EditText) view.findViewById(R.id.id_et_data);
        id_btn = (Button) view.findViewById(R.id.id_btn);
        id_btn.setOnClickListener((View.OnClickListener) getActivity());
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn :
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.id_mlLayout,new SecondFragment(),"");
                fragmentTransaction.commit();
        }
    }
}
