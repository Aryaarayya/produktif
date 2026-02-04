package com.rayya.registro.register;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.rayya.registro.R;


public class RegisterActivity extends AppCompatActivity {
    EditText edtNama, edtEmail, edtNim, edtPassword, edtNoHp, edtAlamat;
    Spinner spinnerAgama, spinnerGender;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtNama = findViewById(R.id.edtNama);
        edtEmail = findViewById(R.id.edtEmail);
        edtNim = findViewById(R.id.edtNim);
        edtPassword = findViewById(R.id.edtPassword);
        edtNoHp = findViewById(R.id.edtNoHp);
        edtAlamat = findViewById(R.id.edtAlamat);
        spinnerAgama = findViewById(R.id.spinnerAgama);
        spinnerGender = findViewById(R.id.spinnerGender);
        btnRegister = findViewById(R.id.btnRegister);

        ArrayAdapter<CharSequence> adapterAgama = ArrayAdapter.createFromResource(this,
                R.array.agama_array, android.R.layout.simple_spinner_item);
        adapterAgama.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAgama.setAdapter(adapterAgama);
        spinnerAgama.setSelection(0);



        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);
        spinnerGender.setSelection(0);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void actionregister(View ) {

                String nama = edtNama.getText().toString();
                String email = edtEmail.getText().toString();
                String nim = edtNim.getText().toString();
                String password = edtPassword.getText().toString();
                String noHp = edtNoHp.getText().toString();
                String agama = spinnerAgama.getSelectedItem().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String alamat = edtAlamat.getText().toString();

                String hasil = "Nama: " + nama + "\n"
                        + "Email: " + email + "\n"
                        + "NIM: " + nim + "\n"
                        + "Password: " + password + "\n"
                        + "No. HP: " + noHp + "\n"
                        + "Agama: " + agama + "\n"
                        + "Gender: " + gender + "\n"
                        + "Alamat: " + alamat;

                Toast.makeText(RegisterActivity.this, hasil, Toast.LENGTH_LONG).show();

                new AlertDialog.Builder(RegisterActivity.this)
                        .setTitle("Data Registrasi")
                        .setMessage(hasil)
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

    }
}
