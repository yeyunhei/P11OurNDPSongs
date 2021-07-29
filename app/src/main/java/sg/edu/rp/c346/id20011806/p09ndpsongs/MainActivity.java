package sg.edu.rp.c346.id20011806.p09ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioGroup starRatingGroup;
   // RadioButton radio1, radio2, radio3, radio4, radio5;
    Button btnInsert, btnShowList;
    RatingBar ratingBarInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
//        starRatingGroup = findViewById(R.id.ratingGroup);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnDelete);
        /*radio1 = findViewById(R.id.radioButton1);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);
        radio4 = findViewById(R.id.radioButton4);
        radio5 = findViewById(R.id.radioButton5);*/
        ratingBarInput = findViewById(R.id.ratingBarMain);

        ratingBarInput.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataTitle = etTitle.getText().toString();
                String dataSingers = etSingers.getText().toString();
                int dataYear = Integer.parseInt(etYear.getText().toString());
                int dataStar = Math.round(ratingBarInput.getRating());

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertSong(dataTitle, dataSingers, dataYear, dataStar);

                if (inserted_id != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });


    }
}