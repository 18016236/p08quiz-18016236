package sg.edu.rp.soi.c346_p08quiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etAge;
    Button btnSave;
    TextView tvName;
    TextView tvAge;
    Spinner spinner;


    @Override
    protected void onPause() {
        super.onPause();

        String strName=etName.getText().toString();
        String StrAge=etAge.getText().toString();

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);

        prefEdit.putString("Name",strName);
        prefEdit.putInt("Age",0);

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);

        String msg=prefs.getString("Name","RealName");
        int Age=prefs.getInt("Age",0);

        etName.setText(msg);
        etAge.setText(Age);

        Age.check(Age);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        etAge=findViewById(R.id.editText);
        spinner=findViewById(R.id.spinner);
        btnSave=findViewById(R.id.btnSave);
        tvName=findViewById(R.id.Name);
        tvAge=findViewById(R.id.Age);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedClass = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this,selectedClass,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
