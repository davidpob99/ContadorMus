package es.davidpob99.ContadorMus;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContadorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContadorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContadorFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn101, btn102, btn103,
            btn104, btn105, btn106,btn107,btn108,btn109,btn1010, btn1011, btn1012, btnreset;
    TextView tx1, tx2, v1, v2;
    EditText et1, et2;
    int j1=0, j2=0, va1=0, va2=0;
    String jug1, jug2, vac1, vac2;

    public ContadorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContadorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContadorFragment newInstance(String param1, String param2) {
        ContadorFragment fragment = new ContadorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contador, container, false);

        tx1 = (TextView) rootView.findViewById(R.id.textView2);
        tx2 = (TextView) rootView.findViewById(R.id.textView102);
        v1 = (TextView) rootView.findViewById(R.id.textView1);
        v2 = (TextView) rootView.findViewById(R.id.textView101);
       
        et1 = (EditText) rootView.findViewById(R.id.editText1);
        et2 = (EditText) rootView.findViewById(R.id.editText101);

        btn1 = (Button) rootView.findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        btn2 = (Button) rootView.findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        btn3 = (Button) rootView.findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = (Button) rootView.findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        btn5 = (Button) rootView.findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        btn6 = (Button) rootView.findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        btn7 = (Button) rootView.findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        btn8 = (Button) rootView.findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        btn9 = (Button) rootView.findViewById(R.id.button9);
        btn9.setOnClickListener(this);
        btn10 = (Button) rootView.findViewById(R.id.button10);
        btn10.setOnClickListener(this);
        btn11 = (Button) rootView.findViewById(R.id.button11);
        btn11.setOnClickListener(this);
        btn12 = (Button) rootView.findViewById(R.id.button12);
        btn12.setOnClickListener(this);


        btn101 = (Button) rootView.findViewById(R.id.button101);
        btn101.setOnClickListener(this);
        btn102 = (Button) rootView.findViewById(R.id.button102);
        btn102.setOnClickListener(this);
        btn103 = (Button) rootView.findViewById(R.id.button103);
        btn103.setOnClickListener(this);
        btn104 = (Button) rootView.findViewById(R.id.button104);
        btn104.setOnClickListener(this);
        btn105 = (Button) rootView.findViewById(R.id.button105);
        btn105.setOnClickListener(this);
        btn106 = (Button) rootView.findViewById(R.id.button106);
        btn106.setOnClickListener(this);
        btn107 = (Button) rootView.findViewById(R.id.button107);
        btn107.setOnClickListener(this);
        btn108 = (Button) rootView.findViewById(R.id.button108);
        btn108.setOnClickListener(this);
        btn109 = (Button) rootView.findViewById(R.id.button109);
        btn109.setOnClickListener(this);
        btn1010 = (Button) rootView.findViewById(R.id.button1010);
        btn1010.setOnClickListener(this);
        btn1011 = (Button) rootView.findViewById(R.id.button1011);
        btn1011.setOnClickListener(this);
        btn1012 = (Button) rootView.findViewById(R.id.button1012);
        btn1012.setOnClickListener(this);

        btnreset = (Button) rootView.findViewById(R.id.reset);
        btnreset.setOnClickListener(this);

        SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int jugador1 = prefs.getInt("jugador1", 0);
        int jugador2 = prefs.getInt("jugador2", 0);

        String vacas1 = prefs.getString("vacas1", "");
        String vacas2 = prefs.getString("vacas2", "");

        String nombre1 = prefs.getString("nombre1", "");
        String nombre2 = prefs.getString("nombre2", "");

        if(jugador1!=0|jugador2!=0){
            j1=jugador1;
            j2=jugador2;

            jug1=String.valueOf(j1);
            tx1.setText(jug1);
            jug2=String.valueOf(j2);
            tx2.setText(jug2);

            v1.setText(vacas1);
            v2.setText(vacas2);

            et1.setText(nombre1);
            et2.setText(nombre2);

            Toast toast =
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Se han restaurado los datos de la partida anterior", Toast.LENGTH_SHORT);
            toast.show();
        }
        
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int jugador1 = prefs.getInt("jugador1", 0);
        int jugador2 = prefs.getInt("jugador2", 0);

        String vacas1 = prefs.getString("vacas1", "");
        String vacas2 = prefs.getString("vacas2", "");

        String nombre1 = prefs.getString("nombre1", "");
        String nombre2 = prefs.getString("nombre2", "");

        if(jugador1!=0|jugador2!=0){
            j1=jugador1;
            j2=jugador2;

            jug1=String.valueOf(j1);
            tx1.setText(jug1);
            jug2=String.valueOf(j2);
            tx2.setText(jug2);

            v1.setText(vacas1);
            v2.setText(vacas2);

            et1.setText(nombre1);
            et2.setText(nombre2);
        }
    }


    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("jugador1", j1);
        editor.putInt("jugador2", j2);
        editor.putString("vacas1", vac1);
        editor.putString("vacas2", vac2);
        editor.putString("nombre1", et1.getText().toString());
        editor.putString("nombre2", et2.getText().toString());
        editor.commit();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        super.onDestroyView();
        SharedPreferences prefs = this.getActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("jugador1", j1);
        editor.putInt("jugador2", j2);
        editor.putString("vacas1", vac1);
        editor.putString("vacas2", vac2);
        editor.putString("nombre1", et1.getText().toString());
        editor.putString("nombre2", et2.getText().toString());
        editor.commit();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void comprobar(){
        if(j1>=40){
            j1=0;
            jug1 = String.valueOf(j1);
            tx1.setText(jug1);
            va1=va1+1;
            vac1= "Vacas: " + String.valueOf(va1);
            v1.setText(vac1);
            if (va1==3){
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Ha ganado la Pareja Azul", Toast.LENGTH_SHORT);
                toast.show();
                j1=0;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                j2=0;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                va1=0;
                vac1= "Vacas: " + String.valueOf(va1);
                v1.setText(vac1);
                va2=0;
                vac2= "Vacas: " + String.valueOf(va2);
                v2.setText(vac2);

            }
        }
    }

    public void comprobar2(){
        if(j2>=40){
            j2=0;
            jug2 = String.valueOf(j2);
            tx2.setText(jug2);
            va2=va2+1;
            vac2= "Vacas: " + String.valueOf(va2);
            v2.setText(vac2);
            if (va2==3){
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Ha ganado la Pareja Roja", Toast.LENGTH_SHORT);
                toast.show();
                j1=0;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                j2=0;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                va1=0;
                vac1= "Vacas: " + String.valueOf(va1);
                v1.setText(vac1);
                va2=0;
                vac2= "Vacas: " + String.valueOf(va2);
                v2.setText(vac2);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                j1 = j1 + 1;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button2:
                j1 = j1 + 2;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button3:
                j1 = j1 + 3;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button4:
                j1 = j1 + 5;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button5:
                j1 = j1 + 10;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button6:
                j1 = j1 + 40;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                comprobar();
                break;
            case R.id.button7:
                j1 = j1 - 1;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button8:
                j1 = j1 - 2;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button9:
                j1 = j1 - 3;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button10:
                j1 = j1 - 5;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button11:
                j1 = j1 - 10;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button12:
                j1 = j1 - 40;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                break;
            case R.id.button101:
                j2 = j2 + 1;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button102:
                j2 = j2 + 2;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button103:
                j2 = j2 + 3;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button104:
                j2 = j2 + 5;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button105:
                j2 = j2 + 10;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button106:
                j2 = j2 + 40;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                comprobar2();
                break;
            case R.id.button107:
                j2 = j2 - 1;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.button108:
                j2 = j2 - 2;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.button109:
                j2 = j2 - 3;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.button1010:
                j2 = j2 - 5;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.button1011:
                j2 = j2 - 10;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.button1012:
                j2 = j2 - 40;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                break;
            case R.id.reset:
                j1=0;
                jug1 = String.valueOf(j1);
                tx1.setText(jug1);
                j2=0;
                jug2 = String.valueOf(j2);
                tx2.setText(jug2);
                va1=0;
                vac1= "Vacas: " + String.valueOf(va1);
                v1.setText(vac1);
                va2=0;
                vac2= "Vacas: " + String.valueOf(va2);
                v2.setText(vac2);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
