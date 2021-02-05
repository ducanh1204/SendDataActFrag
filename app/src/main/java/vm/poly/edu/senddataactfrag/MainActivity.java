package vm.poly.edu.senddataactfrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements HomeFragment.ISendDataListener {

    private EditText edtData;
    private Button btnSendData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.edt_data);
        btnSendData = findViewById(R.id.btn_send_data);

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToFragment();
            }
        });


    }

    private void sendDataToFragment() {

        String data = edtData.getText().toString().trim();
        User user = new User(data);

        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();

        bundle.putString("data",data);
        bundle.putSerializable("object",user);

        homeFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,homeFragment).commit();
    }

    @Override
    public void sendData(String data) {
        edtData.setText(data);
    }
}